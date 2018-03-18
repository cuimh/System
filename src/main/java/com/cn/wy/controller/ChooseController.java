package com.cn.wy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/info")
public class ChooseController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(ClassRoomController.class);
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/score/home.do")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main");
		return mv;
	}
	
	@RequestMapping("/stu/check.do")
	public ModelAndView myscore() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/student/myscore");
		return mv;
	}
	
	@RequestMapping("/tea/addScore.do")
	public ModelAndView addScore() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/teacher/scoreAdd");
		return mv;
	}
	
}
