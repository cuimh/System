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
import com.cn.wy.pojo.TeaInfo;
import com.cn.wy.pojo.TeaInfoExample;
import com.cn.wy.pojoDto.TeaInfoDto;
import com.cn.wy.service.DepartService;
import com.cn.wy.service.TeaService;
import com.cn.wy.utils.BeanPropertyUtils;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.WebUtil;

@Controller
@RequestMapping("/info/tea")
public class TeaController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(TeaController.class); 
	@Autowired
	private TeaService teaService;
	
	@Autowired
	private DepartService departService;

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/teacher/index");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/add.do")
	public String addOrUpdate(TeaInfo tea) {
		if (tea == null) return WebUtil.getFailureJson("添加失败");
		TeaInfo tea1= this.teaService.getTeaByNo(tea.getTeaNo());
			if (Objects.nonNull(tea1)){
				return WebUtil.getFailureJson("该教室已存在");
			}
			this.teaService.insert(tea);
			logger.info("{}添加了{}的信息", getUserRealName(), tea.getTername());
		
			return WebUtil.getSuccessJson("添加成功", null);
	}
	@ResponseBody
	@RequestMapping("/Update.do")
	public String Update(TeaInfo tea) {
		if (tea == null) return WebUtil.getFailureJson("修改失败");
		TeaInfo newtea = this.teaService.selectByPrimaryKey(tea.getId());
			if (Objects.nonNull(tea.getDepartid())) newtea.setDepartid(tea.getDepartid());
			if (Objects.nonNull(tea.getSex())) newtea.setSex(tea.getSex());
			if (!Objects.equals(tea.getTername(),"")) newtea.setTername(tea.getTername());
			if (!Objects.equals(tea.getNote(),"")) newtea.setNote(tea.getNote());
			if (!Objects.equals(tea.getTeaNo(),"")) newtea.setTeaNo(tea.getTeaNo());
			this.teaService.updateByPrimaryKey(newtea);
			logger.info("{}修改了{}的信息", getUserRealName(), tea.getTername());
			return WebUtil.getSuccessJson("修改成功", null);
	}
	
	
	
	
	/**
	 * 删除员工
	 * @param tea
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletetea.do")
	public String deletetea(Long teaId) {
		TeaInfo tea = teaService.selectByPrimaryKey(teaId);
		this.teaService.deleteByPrimaryKey(teaId);
		logger.info("{}删除了{}", getUserRealName(), tea.getTername());
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
			@RequestParam(value = "tername",required = false, defaultValue = "") String tername,
			@RequestParam(value = "teaNo",required = false, defaultValue = "") String teaNo,
	@RequestParam(value = "page",required = false, defaultValue = "1") Integer page,
	@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize) throws Exception {
		DataPage<TeaInfoDto> datas = new DataPage<>();
		try{
		DataPage<TeaInfo> data = new DataPage<>();
		TeaInfoExample example = new TeaInfoExample();
		example.setCurrentPage(page);
		example.setPageSize(pageSize);
		TeaInfoExample.Criteria criteria = example.createCriteria();
		 if (!Objects.equals((tername),""))
		criteria.andTernameLike(tername);
		 if (!Objects.equals((teaNo),""))
				criteria.andTeaNoLike(teaNo);
		data = this.teaService.getByExampleWithPage(example);
		List<TeaInfoDto> list = new ArrayList<>();
		data.getData().forEach((TeaInfo) -> {
			TeaInfoDto teaDto = new TeaInfoDto();
			try {
				BeanPropertyUtils.copyProperties(teaDto, TeaInfo);
				Depart depart = departService.selectByPrimaryKey(TeaInfo.getDepartid());
				teaDto.setDepartname(depart.getDepartname());
				list.add(teaDto);
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
	@RequestMapping("/TeaInfo.do")
	public String getUserInfo(HttpServletRequest request,Long teaId)throws Exception{
		TeaInfo tea = this.teaService.selectByPrimaryKey(teaId);
		return WebUtil.getSuccessJson(tea);
	}
	@ResponseBody
	@RequestMapping("/TeaList.do")
	public String getTeaList(HttpServletRequest request,Long departId)throws Exception{
		List<TeaInfo> tea = this.teaService.teaList(departId);
		return WebUtil.getSuccessJson(tea);
	}
}



