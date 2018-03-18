package com.cn.wy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.Role;
import com.cn.wy.pojo.RoleExample;
import com.cn.wy.pojo.RolePermis;
import com.cn.wy.pojo.RolePermisExample;
import com.cn.wy.pojo.User;
import com.cn.wy.pojo.UserExample;
import com.cn.wy.pojoDto.RolePerDto;
import com.cn.wy.service.PersisService;
import com.cn.wy.service.RolePermisService;
import com.cn.wy.service.RoleService;
import com.cn.wy.service.UserService;
import com.cn.wy.utils.BeanPropertyUtils;
import com.cn.wy.utils.DataPage;
import org.apache.commons.lang.StringUtils;

import com.cn.wy.utils.WebUtil;


@Controller
@RequestMapping("/sys/role")
public class RoleController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RolePermisService rolePermisService;
	
	@Autowired 
	private PersisService perService;
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		List<Persission> menus = this.perService.findFristMenus();
		mv.addObject("menus", menus);
		mv.setViewName("/position/index");
		return mv;
	}
	
	/**
	 * 职位列表
	 * @param page
	 * @param searchData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request,
			@RequestParam(value = "rolename",required = false, defaultValue = "") String rolename,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<RolePerDto> datas = new DataPage<>();
		try{
		RoleExample example = new RoleExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		RoleExample.Criteria criteria = example.createCriteria();
		 if (!Objects.equals(rolename, ""))
		criteria.andRolenameEqualTo(rolename);
		DataPage<Role> data = this.roleService.getByExampleWithPage(example);
		List<RolePerDto> list = new ArrayList<>();
		data.getData().forEach((role) -> {
			RolePerDto rolePerDto = new RolePerDto();
			try {
				RolePermisExample example1 = new RolePermisExample();

				RolePermisExample.Criteria criteria1 = example1.createCriteria();

				BeanPropertyUtils.copyProperties(rolePerDto, role);
				criteria1.andRoleidEqualTo(rolePerDto.getId());
				List<RolePermis> rolper = rolePermisService.selectByExample(example1);
				List<Persission> per = new ArrayList<>();
				for(int i=0;i<rolper.size();i++){
					per.add(perService.selectByPrimaryKey(rolper.get(i).getPerid()));
				}
				String perName ="";
				String menusId ="";
				for(int j=0;j<per.size();j++){
					perName += per.get(j).getPermisname()+",";
					menusId += per.get(j).getId()+",";
				}
				rolePerDto.setMenus(perName);
				rolePerDto.setMenuIds(menusId);
				list.add(rolePerDto);
			} catch (Exception e1) { 
				logger.error(e1.getMessage());
			}
		});
		datas.setCurrentPage(data.getCurrentPage());
		datas.setPageSize(data.getPageSize());
		datas.setTotalItem(data.getTotalItem());
		datas.setData(list);
	} catch (Exception e) {
		logger.error(e.getMessage());
		return WebUtil.getFailureJson(e.getMessage());
	}
		return WebUtil.getSuccessJson(datas, WebUtil.DATE_FMT);
	}
	
	/**
	 * 编辑职位信息
	 * @param page
	 * @param searchData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeName.do")
	public JSONObject changeName(Role position) {
		JSONObject result = new JSONObject();
		if (position.getId() == null) return result;
		if (position.getRolename() == null) return result;
		this.roleService.updateByPrimaryKey(position);
		logger.info("{}修改{}职位信息", getUserRealName(), position.getRolename());
		return result;
	}
	
	/**
	 * 查询是否可以进行删除
	 */
	@ResponseBody
	@RequestMapping("/checkStaff.do")
	public JSONObject checkStaff(Role position) {
		JSONObject result = new JSONObject();
		if (position.getId() == null) return result;
		UserExample example = new UserExample();
		example.createCriteria().andPositionidEqualTo(String.valueOf(position.getId()));
		List<User> staffs = this.userService.selectByExample(example);
		if (staffs.size() > 0) result.put("flag", 0);
		else result.put("flag", 1);
		return result;
	}
	
	/**
	 * 查询是否可以进行删除
	 */
	@ResponseBody
	@RequestMapping("/deletePosition.do")
	public JSONObject deletePosition(Long roleId) {
		JSONObject result = new JSONObject();
		if (roleId == null) return result;
		RolePermisExample example = new RolePermisExample();
		example.createCriteria().andRoleidEqualTo(roleId);
		Role role = this.roleService.selectByPrimaryKey(roleId);
		this.roleService.deleteByPrimaryKey(roleId);
		rolePermisService.deleteRoleMenuByRoleIdAndSysType(roleId);
		logger.info("{}删除{}职位", getUserRealName(),role.getRolename());
		return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/roleInfo.do")
	public String getRoleInfo(HttpServletRequest request,Long roleId)throws Exception{
		Role role = this.roleService.selectByPrimaryKey(roleId);
		return WebUtil.getSuccessJson(role);
	}
	

	
	/**
	 * 添加职位
	 */
	@ResponseBody
	@RequestMapping("/addPosition.do")
	public String addPosition(Role position) {
		if (position.getRolename() == null) return WebUtil.getFailureJson("获取信息失败");
		this.roleService.insert(position);
		logger.info("{}添加{}职位", getUserRealName(), position.getRolename());
		return WebUtil.getSuccessJson("添加成功", WebUtil.DATE_FMT);
	}
	
	
	@RequestMapping("/setauth.do")
	@ResponseBody
	public String setauth(HttpServletRequest req, Long roleId, String menuStr) {
		if (roleId == null || Objects.isNull(menuStr)) {
			return WebUtil.getFailureJson("参数不正确");
		}
		// zaRoleMenuService.removeZaRoleMenuByRoleId(roleId, getZaUser(req));
		// 删除车贷菜单和角色关系重新插入
		rolePermisService.deleteRoleMenuByRoleIdAndSysType(roleId);

		List<RolePermis> menuList = genRoleMenu(menuStr, roleId);
		if (menuList.size() > 0) {
			// 重新创建菜单和角色对应关系
			for (RolePermis menu : menuList) {
				rolePermisService.insert(menu);
			}
		} else {
			return WebUtil.getFailureJson("菜单权限不能为空");
		}

		return WebUtil.getSuccessJson();
	}
	
	private List<RolePermis> genRoleMenu(String menuStr, Long roleId) {
		List<RolePermis> list = new ArrayList<RolePermis>();
		try {
			String[] menuIdArr = StringUtils.split(menuStr, ",");
			for (String mid : menuIdArr) {
				RolePermis menu = new RolePermis();
				menu.setRoleid(Long.valueOf(roleId));
				menu.setPerid(Long.valueOf(mid));
				list.add(menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}