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
import com.cn.wy.pojo.StuInfo;
import com.cn.wy.pojo.StuInfoExample;
import com.cn.wy.pojoDto.StuInfoDto;
import com.cn.wy.service.DepartService;
import com.cn.wy.service.MajorService;
import com.cn.wy.service.StuService;
import com.cn.wy.utils.BeanPropertyUtils;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.WebUtil;

@Controller
@RequestMapping("/info/stu")
public class StuController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(StuController.class); 
	@Autowired
	private StuService stuService;
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
		mv.setViewName("/student/index");
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("/add.do")
	public String addOrUpdate(StuInfo stu) {
		if (stu == null) return WebUtil.getFailureJson("添加失败");
		StuInfo stu1= this.stuService.getStuByNo(stu.getStuNo());
			if (Objects.nonNull(stu1)){
				return WebUtil.getFailureJson("该学生已存在");
			}
			this.stuService.insert(stu);
			logger.info("{}添加了{}的信息", getUserRealName(), stu.getStuname());
		
			return WebUtil.getSuccessJson("添加成功", null);
	}
	@ResponseBody
	@RequestMapping("/Update.do")
	public String Update(StuInfo stu) {
		if (stu == null) return WebUtil.getFailureJson("修改失败");
		StuInfo newstu = this.stuService.selectByPrimaryKey(stu.getId());
			if (Objects.nonNull(stu.getDepartid())) newstu.setDepartid(stu.getDepartid());
			if (!Objects.equals(stu.getSex(),"")) newstu.setSex(stu.getSex());
			if (Objects.nonNull(stu.getStuclass())) newstu.setStuclass(stu.getStuclass());
			if (!Objects.equals(stu.getStuname(),"")) newstu.setStuname(stu.getStuname());
			if (Objects.nonNull(stu.getStuNo())) newstu.setStuNo(stu.getStuNo());
			if (Objects.nonNull(stu.getZid())) newstu.setZid(stu.getZid());

			this.stuService.updateByPrimaryKey(newstu);
			logger.info("{}修改了{}的信息", getUserRealName(), stu.getStuname());
			return WebUtil.getSuccessJson("修改成功", null);
	}
	
	
	
	
	/**
	 * 删除员工
	 * @param stu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletestu.do")
	public String deletestu(Long stuId) {
		StuInfo stu = stuService.selectByPrimaryKey(stuId);
		this.stuService.deleteByPrimaryKey(stuId);
		logger.info("{}删除了{}", getUserRealName(), stu.getStuname());
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
			@RequestParam(value = "stuName",required = false, defaultValue = "") String stuName,
			@RequestParam(value = "stuNo",required = false, defaultValue = "") String stuNo,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<StuInfoDto> datas = new DataPage<>();
		try{
		DataPage<StuInfo> data = new DataPage<>();
		StuInfoExample example = new StuInfoExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		StuInfoExample.Criteria criteria = example.createCriteria();
		 if (!Objects.equals((stuName),""))
		criteria.andStunameLike(stuName);
		 if (!Objects.equals((stuNo),""))
				criteria.andStuNoLike(stuNo);
		data = this.stuService.getByExampleWithPage(example);
		List<StuInfoDto> list = new ArrayList<>();;
		data.getData().forEach((StuInfo) -> {
			StuInfoDto stuDto = new StuInfoDto();
			try {
				BeanPropertyUtils.copyProperties(stuDto, StuInfo);
				Depart depart = departService.selectByPrimaryKey(StuInfo.getDepartid());
				Major major = majorService.selectByPrimaryKey(StuInfo.getZid());
				stuDto.setDepartname(depart.getDepartname());
				stuDto.setMajorname(major.getMajorname());
				list.add(stuDto);
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
	@RequestMapping("/stuInfo.do")
	public String getUserInfo(HttpServletRequest request,Long stuId)throws Exception{
		StuInfo stu = this.stuService.selectByPrimaryKey(stuId);
		return WebUtil.getSuccessJson(stu);
	}
}


