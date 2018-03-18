package com.cn.wy.controller;

import java.util.ArrayList;
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
import com.cn.wy.pojo.Major;
import com.cn.wy.pojo.MajorExample;
import com.cn.wy.pojo.Role;
import com.cn.wy.pojoDto.MajorDto;
import com.cn.wy.pojoDto.UserDto;
import com.cn.wy.service.DepartService;
import com.cn.wy.service.MajorService;
import com.cn.wy.utils.BeanPropertyUtils;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.WebUtil;

@Controller
@RequestMapping("/info/major")
public class MajorController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(MajorController.class); 
	@Autowired
	private MajorService majorService;
	@Autowired
	private DepartService departService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/major/index");
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("/add.do")
	public String addOrUpdate(Major major) {
		if (major == null) return WebUtil.getFailureJson("添加失败");
		Major major1= this.majorService.getMajorByNo(major.getMajorname());
			if (Objects.nonNull(major1)){
				return WebUtil.getFailureJson("该专业已存在");
			}
			this.majorService.insert(major);
			logger.info("{}添加了{}的信息", getUserRealName(), major.getMajorname());
		
			return WebUtil.getSuccessJson("添加成功", null);
	}
	@ResponseBody
	@RequestMapping("/Update.do")
	public String Update(Major major) {
		if (major == null) return WebUtil.getFailureJson("修改失败");
		Major newmajor = this.majorService.selectByPrimaryKey(major.getId());
			if (Objects.nonNull(major.getDepartid())) newmajor.setDepartid(major.getDepartid());
			if (!Objects.equals(major.getMajorname(),"")) newmajor.setMajorname(major.getMajorname());
			if (!Objects.equals(major.getMajorno(),"")) newmajor.setMajorno(major.getMajorno());

			/*User user= this.userService.selectByUsername(major.getName());
			if (Objects.nonNull(user)){
				return WebUtil.getFailureJson("该账号已存在");
			} */
			this.majorService.updateByPrimaryKey(newmajor);
			logger.info("{}修改了{}的信息", getUserRealName(), major.getMajorname());
			return WebUtil.getSuccessJson("修改成功", null);
	}
	
	
	
	
	/**
	 * 删除员工
	 * @param major
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletemajor.do")
	public String deletemajor(Long majorId) {
		Major major = majorService.selectByPrimaryKey(majorId);
		this.majorService.deleteByPrimaryKey(majorId);
		logger.info("{}删除了{}", getUserRealName(), major.getMajorname());
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
			@RequestParam(value = "majorname",required = false, defaultValue = "") String majorname,
			@RequestParam(value = "majorno",required = false, defaultValue = "") String majorno,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<MajorDto> datas = new DataPage<>();
		try{
		DataPage<Major> data = new DataPage<>();
		
		MajorExample example = new MajorExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		MajorExample.Criteria criteria = example.createCriteria();
		 if (!Objects.equals((majorname),""))
		criteria.andMajornameLike(majorname);
		 if (!Objects.equals((majorno),""))
				criteria.andMajornoLike(majorno);
		data = this.majorService.getByExampleWithPage(example);
		List<MajorDto> list = new ArrayList<>();;
		data.getData().forEach((Major) -> {
			MajorDto majorDto = new MajorDto();
			try {
				BeanPropertyUtils.copyProperties(majorDto, Major);
				Depart depart = departService.selectByPrimaryKey(Major.getDepartid());
				majorDto.setDepartname(depart.getDepartname());
				list.add(majorDto);
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
	@RequestMapping("/Major.do")
	public String getUserInfo(HttpServletRequest request,Long majorId)throws Exception{
		Major major = this.majorService.selectByPrimaryKey(majorId);
		return WebUtil.getSuccessJson(major);
	}
	
	@ResponseBody
	@RequestMapping("/MajorList.do")
	public String getDepartList(HttpServletRequest request,Long departid)throws Exception{
		List<Major> major = this.majorService.majorList(departid);
		return WebUtil.getSuccessJson(major);
	}
}



