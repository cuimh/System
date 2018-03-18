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

import com.cn.wy.pojo.Classroom;
import com.cn.wy.pojo.Course;
import com.cn.wy.pojo.Depart;
import com.cn.wy.pojo.Score;
import com.cn.wy.pojo.TeaInfo;
import com.cn.wy.pojoDto.CourseDto;
import com.cn.wy.pojo.CourseExample;
import com.cn.wy.service.ClassRoomService;
import com.cn.wy.service.CourseService;
import com.cn.wy.service.DepartService;
import com.cn.wy.service.ScoreService;
import com.cn.wy.service.TeaService;
import com.cn.wy.utils.BeanPropertyUtils;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.WebUtil;

@Controller
@RequestMapping("/info/course")
public class CourseController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(CourseController.class); 
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private DepartService departService;
	
	@Autowired
	private ClassRoomService classRoomService;
	
	@Autowired
	private TeaService teaService;
	
	@Autowired
	private ScoreService scoreService;
	

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/course/index");
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("/add.do")
	public String addOrUpdate(Course course) {
		if (course == null) return WebUtil.getFailureJson("添加失败");
		System.out.println(course.getClassno());
		Course course1= this.courseService.getCourseByNo(course.getClassno());
			if (Objects.nonNull(course1)){
				return WebUtil.getFailureJson("该课程已存在");
			}
			this.courseService.insert(course);
			logger.info("{}添加了{}的信息", getUserRealName(), course.getCoursename());
		
			return WebUtil.getSuccessJson("添加成功", null);
	}
	@ResponseBody
	@RequestMapping("/Update.do")
	public String Update(Course course) {
		if (course == null) return WebUtil.getFailureJson("修改失败");
		Course newcourse = this.courseService.selectByPrimaryKey(course.getCourseid());
			if (Objects.nonNull(course.getDepartid())) newcourse.setDepartid(course.getDepartid());
			if (Objects.nonNull(course.getClassno())) newcourse.setClassno(course.getClassno());
			if (!Objects.equals(course.getCourseabout(),"")) newcourse.setCourseabout(course.getCourseabout());
			if (Objects.nonNull(course.getCourseaddress())) newcourse.setCourseaddress(course.getCourseaddress());
			if (!Objects.equals(course.getCoursetime(),"")) newcourse.setCoursetime(course.getCoursetime());
			if (Objects.nonNull(course.getTeacherno())) newcourse.setTeacherno(course.getTeacherno());
			if (Objects.nonNull(course.getCoursegrade())) newcourse.setCoursegrade(course.getCoursegrade());

			/*User user= this.userService.selectByUsername(course.getName());
			if (Objects.nonNull(user)){
				return WebUtil.getFailureJson("该账号已存在");
			} */
			this.courseService.updateByPrimaryKey(newcourse);
			logger.info("{}修改了{}的信息", getUserRealName(), course.getCoursename());
			return WebUtil.getSuccessJson("修改成功", null);
	}
	
	
	
	
	/**
	 * 删除员工
	 * @param course
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletecourse.do")
	public String deletecourse(Long courseId) {
		Course course = courseService.selectByPrimaryKey(courseId);
		this.courseService.deleteByPrimaryKey(courseId);
		logger.info("{}删除了{}", getUserRealName(), course.getCoursename());
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
			@RequestParam(value = "coursename",required = false, defaultValue = "") String coursename,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<CourseDto> datas = new DataPage<>();
		try{
		DataPage<Course> data = new DataPage<>();
		CourseExample example = new CourseExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		CourseExample.Criteria criteria = example.createCriteria();
		 if (!Objects.equals((coursename),""))
		criteria.andCoursenameLike(coursename);
		 
		data = this.courseService.getByExampleWithPage(example);
		List<CourseDto> list = new ArrayList<>();;
		data.getData().forEach((Course) -> {
			CourseDto courseDto = new CourseDto();
			try {
				BeanPropertyUtils.copyProperties(courseDto, Course);
				Depart depart = departService.selectByPrimaryKey(Course.getDepartid());
				Classroom room = classRoomService.selectByPrimaryKey(Course.getCourseaddress());
				Long currentPeople = scoreService.countScore1(Course.getCourseid().longValue());

				TeaInfo tea = teaService.selectByPrimaryKey(Course.getTeacherno());
				courseDto.setDepartname(depart.getDepartname());
				courseDto.setAddress(room.getClassaddress());
				courseDto.setTername(tea.getTername());
				courseDto.setCurrentPeople(currentPeople);
				courseDto.setClassPeople(room.getCalsspeople());
				list.add(courseDto);
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
	@RequestMapping("/Course.do")
	public String getUserInfo(HttpServletRequest request,Long courseId)throws Exception{
		Course course = this.courseService.selectByPrimaryKey(courseId);
		return WebUtil.getSuccessJson(course);
	}
	@ResponseBody
	@RequestMapping("/listScore.do")
	public String listScore(HttpServletRequest request,
			@RequestParam(value = "coursename",required = false, defaultValue = "") String coursename,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<CourseDto> datas = new DataPage<>();
			List<Score> course = this.scoreService.scoreList(getUserLoginName());
			
		try{
		DataPage<Course> data = new DataPage<>();
		CourseExample example = new CourseExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		CourseExample.Criteria criteria = example.createCriteria();
		 if (!Objects.equals((coursename),""))
		criteria.andCoursenameLike(coursename);
		 
		data = this.courseService.getByExampleWithPage(example);
		List<CourseDto> list = new ArrayList<>();;
		data.getData().forEach((Course) -> {
			CourseDto courseDto = new CourseDto();
			try {
				BeanPropertyUtils.copyProperties(courseDto, Course);
				Depart depart = departService.selectByPrimaryKey(Course.getDepartid());
				Classroom room = classRoomService.selectByPrimaryKey(Course.getCourseaddress());
				TeaInfo tea = teaService.selectByPrimaryKey(Course.getTeacherno());
				courseDto.setDepartname(depart.getDepartname());
				courseDto.setAddress(room.getClassaddress());
				courseDto.setTername(tea.getTername());
				
				list.add(courseDto);
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
}





