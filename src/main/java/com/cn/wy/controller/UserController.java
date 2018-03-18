package com.cn.wy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
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
import com.cn.wy.pojo.Role;
import com.cn.wy.pojo.RoleExample;
import com.cn.wy.pojo.User;
import com.cn.wy.pojo.UserExample;
import com.cn.wy.pojoDto.UserDto;
import com.cn.wy.service.RoleService;
import com.cn.wy.service.UserService;
import com.cn.wy.service.impl.UserServiceImpl;
import com.cn.wy.utils.BeanPropertyUtils;
import com.cn.wy.utils.CLSException;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.IDUtils;
import com.cn.wy.utils.MD5Util;
import com.cn.wy.utils.WebUtil;


@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(UserController.class); 
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/index");
		return mv;
	}
	

	
	/**
	 * 添加员工
	 * @param staff 员工
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add.do")
	public String addOrUpdate(User staff, String flag) {
		if (staff == null) return WebUtil.getFailureJson("添加失败");
			if (staff.getPwd() == null) staff.setPwd(MD5Util.MD5("123456"));
			else staff.setPwd(MD5Util.MD5(staff.getPwd()));
			staff.setFlag(1);
			staff.setCreatetime(new Date());
			User user= this.userService.selectByUsername(staff.getName());
			if (Objects.nonNull(user)){
				return WebUtil.getFailureJson("该账号已存在");
			}
			this.userService.insert(staff);
			//logger.info("{}添加了{}的信息", getUserRealName(), staff.getRelname());
		
			return WebUtil.getSuccessJson("添加成功", null);
	}
	@ResponseBody
	@RequestMapping("/Update.do")
	public String Update(User staff, String flag) {
		if (staff == null) return WebUtil.getFailureJson("修改失败");
			User newStaff = this.userService.selectByPrimaryKey(staff.getId());
			if (staff.getName() != null) newStaff.setName(staff.getName());
			if (staff.getRelname() != null) newStaff.setRelname(staff.getRelname());
			if (staff.getPositionid() != null) newStaff.setPositionid(staff.getPositionid());
			if (staff.getInstructions() != null) newStaff.setInstructions(staff.getInstructions());
			/*User user= this.userService.selectByUsername(staff.getName());
			if (Objects.nonNull(user)){
				return WebUtil.getFailureJson("该账号已存在");
			} */
			this.userService.updateByPrimaryKey(newStaff);
			logger.info("{}修改了{}的信息", getUserRealName(), staff.getRelname());
			return WebUtil.getSuccessJson("修改成功", null);
	}
	
	/**
	 * 改变员工状态
	 * @param staff
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeFlag.do")
	public JSONObject changeFlag(User staff) {
		JSONObject result = new JSONObject();
		if (staff.getId() == null) return result;
		staff = this.userService.selectByPrimaryKey(staff.getId());
		if (staff.getFlag() == 1) staff.setFlag(0);
		else staff.setFlag(1);
		this.userService.updateByPrimaryKey(staff);
		logger.info("{}改变了{}的状态", getUserRealName(), staff.getRelname());
		return result;
	}
	
	
	/**
	 * 删除员工
	 * @param staff
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteStaff.do")
	public String deleteStaff(Long userId) {
		User staff = userService.selectByPrimaryKey(userId);
		this.userService.deleteByPrimaryKey(userId);
		logger.info("{}删除了{}", getUserRealName(), staff.getRelname());
		return WebUtil.getSuccessJson("删除成功", null);
	}
	
	/**
	 * 员工列表
	 * @param page
	 * @param searchData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request,
			@RequestParam(value = "name",required = false, defaultValue = "") String name,
	@RequestParam(value = "relname", required = false,defaultValue = "") String relname,
	@RequestParam(value = "flag", required = false,defaultValue = "") Integer flag,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<UserDto> datas = new DataPage<>();
		try {
		UserExample example = new UserExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		UserExample.Criteria criteria = example.createCriteria();
		 if (!Objects.equals(name, ""))
		criteria.andNameLike(name);
		 if (!Objects.equals(relname, ""))
		criteria.andRelnameLike(relname);
		 if (Objects.nonNull(flag))
				criteria.andFlagEqualTo(flag);
		DataPage<User> data = this.userService.getByExampleWithPage(example);
		
		List<UserDto> list = new ArrayList<>();
		data.getData().forEach((User) -> {
			UserDto userDto = new UserDto();
			try {
				BeanPropertyUtils.copyProperties(userDto, User);
				Role role = roleService.selectByPrimaryKey(Long.valueOf(User.getPositionid()));
				userDto.setRoleName(role.getRolename());
				list.add(userDto);
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
	@ResponseBody
	@RequestMapping("/userInfo.do")
	public String getUserInfo(HttpServletRequest request,Long userId)throws Exception{
		User user = this.userService.selectByPrimaryKey(userId);
		return WebUtil.getSuccessJson(user);
	}
	
}
