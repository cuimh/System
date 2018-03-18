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
import com.cn.wy.pojo.ScoreExample;
import com.cn.wy.pojo.StuInfo;
import com.cn.wy.pojo.TeaInfo;
import com.cn.wy.pojo.User;
import com.cn.wy.pojoDto.ScoreDto;
import com.cn.wy.service.ClassRoomService;
import com.cn.wy.service.CourseService;
import com.cn.wy.service.DepartService;
import com.cn.wy.service.ScoreService;
import com.cn.wy.service.StuService;
import com.cn.wy.service.TeaService;
import com.cn.wy.utils.BeanPropertyUtils;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.WebUtil;

@Controller
@RequestMapping("/info/score")
public class ScoreController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(ScoreController.class); 
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private TeaService teaService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ClassRoomService classRoomService;
	
	@Autowired
	private StuService stuService;
	
	@Autowired
	private DepartService departService;
	/**
	 * 选课
	 * @return
	 */
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home");
		return mv;
	}
	/**
	 * 选课
	 * @param request
	 * @param courseid
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/add.do")
	public String addOrUpdate(HttpServletRequest request,Long courseid)throws Exception{
		Score score1 = new Score();
		score1.setStuno(getUserLoginName());
		score1.setCoursrid(courseid.doubleValue());
		long countPeo = scoreService.countScore(score1);
		if(countPeo>0){
			 return WebUtil.getFailureJson("该课程已经选修不能再选");
		}
		long num = scoreService.countStuNo(getUserLoginName());
		if(num>0){
			return WebUtil.getFailureJson("您已选择其他课程，请先去退选在重新选择");
		}
		long countSco = scoreService.countScore1(courseid);
		Course course = courseService.selectByPrimaryKey(courseid);
		Classroom room = classRoomService.selectByPrimaryKey(course.getCourseaddress());
		if(countSco>=room.getCalsspeople()){
			 return WebUtil.getFailureJson("该课程已满，请选择其他课程");
		}
		Score score = new Score();
		score.setCoursrid(course.getCourseid().doubleValue());
		score.setCredit((float)0);
		score.setStuno(getUserLoginName());
		score.setTeacherid(course.getTeacherno().doubleValue());
		score.setScore((float)0);
		score.setFlag(0);
		scoreService.insert(score);
		return WebUtil.getSuccessJson("添加成功", null);
	}
	@ResponseBody
	@RequestMapping("/Update.do")
	public String Update(Score score) {
		if (score == null) return WebUtil.getFailureJson("修改失败");
		Score newcourse = this.scoreService.selectByPrimaryKey(score.getId());
			if (Objects.nonNull(score.getCoursrid())) newcourse.setCoursrid(score.getCoursrid());
			if (Objects.nonNull(score.getCredit())) newcourse.setCredit(score.getCredit());
			if (Objects.nonNull(score.getScore())) newcourse.setScore(score.getScore());
			if (Objects.nonNull(score.getStuno())) newcourse.setStuno(score.getStuno());
			if (Objects.nonNull(score.getTeacherid())) newcourse.setTeacherid(score.getTeacherid());
			 newcourse.setFlag(1);
			
			this.scoreService.updateByPrimaryKey(newcourse);
			logger.info("{}修改了{}的信息", getUserRealName(), score.getStuno());
			return WebUtil.getSuccessJson("修改成功", null);
	}
	
	
	
	
	/**
	 * 删除员工
	 * @param course
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletescore.do")
	public String deletecourse(Long scoreId) {
		Score course = scoreService.selectByPrimaryKey(scoreId);
		this.scoreService.deleteByPrimaryKey(scoreId);
		logger.info("{}退选了{}", getUserRealName(), course.getStuno());
		return WebUtil.getSuccessJson("退选成功", null);
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
			@RequestParam(value = "flag",required = false, defaultValue = "") Integer flag,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<ScoreDto> datas = new DataPage<>();
		try{
		DataPage<Score> data = new DataPage<>();
		ScoreExample example = new ScoreExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		ScoreExample.Criteria criteria = example.createCriteria();
		 if (Objects.nonNull((flag)))
		criteria.andFlagEqualTo(flag);
		 User user = getUser();
			if(Objects.nonNull(user)){
				if("2".equals(user.getPositionid()))
					criteria.andTeacheridEqualTo(teaService.getTeaByNo(getUserLoginName()).getId().doubleValue());
			} 
		data = this.scoreService.getByExampleWithPage(example);
		List<ScoreDto> list = new ArrayList<>();;
		data.getData().forEach((Course) -> {
			ScoreDto courseDto = new ScoreDto();
			try {
				BeanPropertyUtils.copyProperties(courseDto, Course);
				TeaInfo tea = teaService.selectByPrimaryKey(Course.getTeacherid().longValue());
				Course course = courseService.selectByPrimaryKey(Course.getCoursrid().longValue());
				courseDto.setTeaname(tea.getTername());
				courseDto.setCoursename(course.getCoursename());
				StuInfo stu  = stuService.getStuByNo(Course.getStuno());
				courseDto.setStuname(stu.getStuname());
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
	@RequestMapping("/Score.do")
	public String getUserInfo(HttpServletRequest request,Long scoreId)throws Exception{
		Score course = this.scoreService.selectByPrimaryKey(scoreId);
		return WebUtil.getSuccessJson(course);
	}
	
	/**
	 * 员工列表
	 * @param page
	 * @param searchData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listMyScore.do")
	public String listMyScore(HttpServletRequest request,
			@RequestParam(value = "flag",required = false, defaultValue = "") Integer flag,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<ScoreDto> datas = new DataPage<>();
		try{
		DataPage<Score> data = new DataPage<>();
		ScoreExample example = new ScoreExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		ScoreExample.Criteria criteria = example.createCriteria();
		 if (Objects.nonNull((flag)))
		criteria.andFlagEqualTo(flag);
		 criteria.andStunoEqualTo(getUserLoginName());
		data = this.scoreService.getByExampleWithPage(example);
		List<ScoreDto> list = new ArrayList<>();;
		data.getData().forEach((Course) -> {
			ScoreDto courseDto = new ScoreDto();
			try {
				BeanPropertyUtils.copyProperties(courseDto, Course);
				TeaInfo tea = teaService.selectByPrimaryKey(Course.getTeacherid().longValue());
				Course course = courseService.selectByPrimaryKey(Course.getCoursrid().longValue());
				Classroom room = classRoomService.selectByPrimaryKey(course.getCourseaddress());
				Long currentPeople = scoreService.countScore1(Course.getCoursrid().longValue());
				Depart depart = departService.selectByPrimaryKey(tea.getDepartid());
				courseDto.setTeaname(tea.getTername());
				courseDto.setCoursename(course.getCoursename());
				courseDto.setCourseabout(course.getCourseabout());
				courseDto.setCourseaddress(course.getCourseaddress());
				courseDto.setCoursegrade(course.getCoursegrade());
				courseDto.setCoursetime(course.getCoursetime());
				courseDto.setClassNo(course.getClassno());
				courseDto.setClassAddress(room.getClassaddress());
				courseDto.setClassPeople(room.getCalsspeople());
				courseDto.setCurrentPeople(currentPeople);
				courseDto.setDepartname(depart.getDepartname());
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





