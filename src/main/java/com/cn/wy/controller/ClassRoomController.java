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

import com.cn.wy.pojo.Classroom;
import com.cn.wy.pojo.ClassroomExample;
import com.cn.wy.service.ClassRoomService;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.WebUtil;

@Controller
@RequestMapping("/info/classRoom")
public class ClassRoomController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(ClassRoomController.class); 
	@Autowired
	private ClassRoomService classRoomService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/room/index");
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("/add.do")
	public String addOrUpdate(Classroom room) {
		if (room == null) return WebUtil.getFailureJson("添加失败");
		Classroom room1= this.classRoomService.getRoomByNo(room.getClassNo());
			if (Objects.nonNull(room1)){
				return WebUtil.getFailureJson("该教室已存在");
			}
			this.classRoomService.insert(room);
			logger.info("{}添加了{}的信息", getUserRealName(), room.getClassNo());
		
			return WebUtil.getSuccessJson("添加成功", null);
	}
	@ResponseBody
	@RequestMapping("/Update.do")
	public String Update(Classroom room) {
		if (room == null) return WebUtil.getFailureJson("修改失败");
		Classroom newroom = this.classRoomService.selectByPrimaryKey(room.getId());
			if (Objects.nonNull(room.getClassNo())) newroom.setClassNo(room.getClassNo());
			if (Objects.nonNull(room.getCalsspeople())) newroom.setCalsspeople(room.getCalsspeople());
			if (Objects.nonNull(room.getClassaddress())) newroom.setClassaddress(room.getClassaddress());

			/*User user= this.userService.selectByUsername(room.getName());
			if (Objects.nonNull(user)){
				return WebUtil.getFailureJson("该账号已存在");
			} */
			this.classRoomService.updateByPrimaryKey(newroom);
			logger.info("{}修改了{}的信息", getUserRealName(), room.getClassNo());
			return WebUtil.getSuccessJson("修改成功", null);
	}
	
	
	
	
	/**
	 * 删除员工
	 * @param room
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteroom.do")
	public String deleteroom(Long roomId) {
		Classroom room = classRoomService.selectByPrimaryKey(roomId);
		this.classRoomService.deleteByPrimaryKey(roomId);
		logger.info("{}删除了{}", getUserRealName(), room.getClassNo());
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
			@RequestParam(value = "classNo",required = false, defaultValue = "") Integer classNo,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<Classroom> data = new DataPage<>();
		try {
		ClassroomExample example = new ClassroomExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		ClassroomExample.Criteria criteria = example.createCriteria();
		 if (Objects.nonNull(classNo))
		criteria.andClassNoEqualTo(classNo);
		
		data = this.classRoomService.getByExampleWithPage(example);
		
		
	} catch (Exception e) {
		logger.error(e.getMessage());
		return WebUtil.getFailureJson(e.getMessage());
	}
	return WebUtil.getSuccessJson(data, WebUtil.DATE_FMT);
}
	@ResponseBody
	@RequestMapping("/roomInfo.do")
	public String getUserInfo(HttpServletRequest request,Long roomId)throws Exception{
		Classroom room = this.classRoomService.selectByPrimaryKey(roomId);
		return WebUtil.getSuccessJson(room);
	}
	
	@ResponseBody
	@RequestMapping("/roomList.do")
	public String getRoomList(HttpServletRequest request)throws Exception{
		List<Classroom> room = this.classRoomService.roomList();
		return WebUtil.getSuccessJson(room);
	}
}
