package com.cn.wy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.PersissionExample;
import com.cn.wy.pojo.User;
import com.cn.wy.service.PersisService;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.WebUtil;

@Controller
@RequestMapping("/sys/menu")
public class PersisController extends BaseController{
	@Autowired
	private PersisService perService;
	
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/menu/index");
		return mv;
	}
	
	/**
	 * 菜单列表
	 * @param page
	 * @param searchData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request,
			@RequestParam(value = "name",required = false, defaultValue = "") String name,
	@RequestParam(value = "path", required = false,defaultValue = "") String path,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		PersissionExample example = new PersissionExample();
		example.setPageSize(pageSize);
		example.setCurrentPage(page);
		PersissionExample.Criteria criteria = example.createCriteria();
		if (!Objects.equals(name, ""))
		criteria.andPermisnameLike(name);
		if (!Objects.equals(path, ""))
		criteria.andPathEqualTo(path);
		DataPage<Persission> datas = this.perService.getByExampleWithPage(example);
		return WebUtil.getSuccessJson(datas, WebUtil.DATE_FMT);
	}
	
	/**
	 * 所有系统
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/sysList.do")
	public String sysList(HttpServletRequest request){
		
		List<Persission> sysMenuListDTO = new ArrayList<Persission>();

		//List<Persission> sysList = new ArrayList<>();
			List<Persission> parentSysMenuList = perService.findFristMenus();
			for(int j=0;j<parentSysMenuList.size();j++){
				Persission zaSysMenu = parentSysMenuList.get(j);
				//主菜单下的所有子菜单
				List<Persission> sysMenuList = perService.getMenuListBySysType(zaSysMenu.getId());
				zaSysMenu.setSysMenuList(sysMenuList);
				sysMenuListDTO.add(zaSysMenu);
			}
		
		return WebUtil.getSuccessJson(sysMenuListDTO);
	}
}
