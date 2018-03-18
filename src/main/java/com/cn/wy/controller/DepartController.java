package com.cn.wy.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.wy.pojo.Depart;
import com.cn.wy.pojo.Depart;
import com.cn.wy.pojo.DepartExample;
import com.cn.wy.service.DepartService;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.WebUtil;

@Controller
@RequestMapping("/info/depart")
public class DepartController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(DepartController.class); 
	@Autowired
	private DepartService departService;
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/depart/index");
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("/add.do")
	public String addOrUpdate(Depart depart) {
		if (depart == null) return WebUtil.getFailureJson("添加失败");
		Depart depart1= this.departService.getdepartByName(depart.getDepartname());
			if (Objects.nonNull(depart1)){
				return WebUtil.getFailureJson("该院系已存在");
			}
			this.departService.insert(depart);
			logger.info("{}添加了{}的信息", getUserRealName(), depart.getDepartname());
		
			return WebUtil.getSuccessJson("添加成功", null);
	}
	@ResponseBody
	@RequestMapping("/Update.do")
	public String Update(Depart depart) {
		if (depart == null) return WebUtil.getFailureJson("修改失败");
		Depart newdepart = this.departService.selectByPrimaryKey(depart.getDepartid());
			if (!Objects.equals(depart.getDepartname(),"")) newdepart.setDepartname(depart.getDepartname());
			if (!Objects.equals(depart.getDepartinfo(),"")) newdepart.setDepartinfo(depart.getDepartinfo());

			/*User user= this.userService.selectByUsername(depart.getName());
			if (Objects.nonNull(user)){
				return WebUtil.getFailureJson("该账号已存在");
			} */
			this.departService.updateByPrimaryKey(newdepart);
			logger.info("{}修改了{}的信息", getUserRealName(), depart.getDepartname());
			return WebUtil.getSuccessJson("修改成功", null);
	}
	
	
	
	
	/**
	 * 删除员工
	 * @param depart
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletedepart.do")
	public String deletedepart(Long departId) {
		Depart depart = departService.selectByPrimaryKey(departId);
		this.departService.deleteByPrimaryKey(departId);
		logger.info("{}删除了{}", getUserRealName(), depart.getDepartname());
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
			@RequestParam(value = "departname",required = false, defaultValue = "") String departname,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<Depart> data = new DataPage<>();
		try {
		DepartExample example = new DepartExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		DepartExample.Criteria criteria = example.createCriteria();
		 if (!Objects.equals((departname),""))
		criteria.andDepartnameLike(departname);
		 
		data = this.departService.getByExampleWithPage(example);
	} catch (Exception e) {
		logger.error(e.getMessage());
		return WebUtil.getFailureJson(e.getMessage());
	}
	return WebUtil.getSuccessJson(data, WebUtil.DATE_FMT);
}
	@ResponseBody
	@RequestMapping("/Depart.do")
	public String getUserInfo(HttpServletRequest request,Long departId)throws Exception{
		Depart depart = this.departService.selectByPrimaryKey(departId);
		return WebUtil.getSuccessJson(depart);
	}
	
	@ResponseBody
	@RequestMapping("/DepartList.do")
	public String getDepartList(HttpServletRequest request)throws Exception{
		List<Depart> depart = this.departService.departList();
		return WebUtil.getSuccessJson(depart);
	}
	
}



