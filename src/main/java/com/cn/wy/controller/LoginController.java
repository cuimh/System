package com.cn.wy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.PersissionExample;
import com.cn.wy.pojo.Role;
import com.cn.wy.pojo.User;
import com.cn.wy.pojo.UserExample;
import com.cn.wy.service.PersisService;
import com.cn.wy.service.RoleService;
import com.cn.wy.service.UserService;
import com.cn.wy.utils.MD5Util;

@Controller
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class); 
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PersisService perService;
	
	/**
	 * 跳转登录界面
	 * @return
	 */
    @RequestMapping("/toLogin.do")
    public ModelAndView toLogin() {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("/login");
    	return mv;
    }
    
    /**
     * 跳转登录界面
     * @return
     */
    @RequestMapping("/toIndex.do")
    public ModelAndView toIndex() {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("/index");
    	return mv;
    }

    /**
     * 登录
     * @param staff
     * @param session
     * @return
     */
	@RequestMapping("/login.do")
	protected ModelAndView login(User staff, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (staff.getName() == null) {
			mv.addObject("tip", "请输入用户名！");
			mv.setViewName("/login");
            return mv;
		}
		if (staff.getPwd() == null) {
			mv.addObject("tip", "请输入密码！");
			mv.setViewName("/login");
			return mv;
		}
		UserExample example = new UserExample();
		if (!Objects.equals(staff.getName(), ""));
		example.createCriteria().andNameEqualTo(staff.getName());
		List<User> staffs = this.userService.selectByExample(example); 
		if (staffs.size() == 0) {
			mv.addObject("tip", "该账户不存在！");
			mv.setViewName("/login");
            return mv;
		}
		User staff1 = staffs.get(0);
		if (!MD5Util.checkPassword(staff.getPwd(), staff1.getPwd())) {
			mv.addObject("tip", "密码错误！");
			mv.setViewName("/login");
			return mv;
		}
        if(staff1.getFlag().equals("0")){  
        	mv.addObject("tip", "该账户已被冻结！");
        	mv.setViewName("/login");
            return mv;  
        }
        User user = new User();
        user.setId(staff1.getId());
        user.setName(staff1.getName());
        user.setPwd(staff1.getPwd());
        user.setPositionid(staff1.getPositionid());
        user.setRelname(staff1.getRelname());
        /*PersissionExample perExample = new PersissionExample();
        if(!Objects.equals(staff1.getPositionid(), ""));
        perExample.createCriteria().andIdEqualTo(Long.valueOf((staff1.getPositionid())));*/
        
        List<Persission> menus = this.roleService.getPosById(Long.valueOf(staff1.getPositionid()));
        user.setMenus(menus);
        List<Persission> mainMenu = new ArrayList<Persission>();
        for (Persission menu : menus) {
			if (menu.getPid() == 0) {
				mainMenu.add(menu);
			}
		}
        user.setMainMenus(mainMenu);
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(60 * 60);
        logger.info("{}登录系统", user.getRelname());
		return new ModelAndView("redirect:/toIndex.do");
	}
	
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginOut.do")
	public ModelAndView loginOut(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		logger.info("{}注销", user.getRelname());
		session.invalidate();
		mv.setViewName("/login");
		return mv;
	}
	
	/**
	 * 修改密码
	 * @param session
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updatePwd.do")
	public JSONObject updatePwd(HttpSession session, String oldPassword, String newPassword) {
		JSONObject result = new JSONObject();
		if (oldPassword == null) return result;
		if (newPassword == null) return result;
		User user = (User) session.getAttribute("user");
		if (!MD5Util.checkPassword(oldPassword, user.getPwd())) {
			result.put("code", 101);
			return result;
		}
		User staff = new User();
		staff.setId(user.getId());
		staff = this.userService.selectByPrimaryKey(user.getId());
		staff.setPwd(MD5Util.MD5(newPassword));
		this.userService.updateByPrimaryKeySelective(staff);
		logger.info("{}修改密码", user.getRelname());
		result.put("code", 10000);
		return result;
	}
	

}
