package com.cn.wy.service;

import java.util.List;

import com.cn.wy.pojo.Depart;
import com.cn.wy.pojo.DepartExample;
import com.cn.wy.utils.DataPage;

public interface DepartService {
	 long countByExample(DepartExample example);

	    int deleteByPrimaryKey(Long departid);

	    int insert(Depart record);

	    List<Depart> selectByExample(DepartExample example);

	    Depart selectByPrimaryKey(Long departid);
	    
	    int updateByPrimaryKey(Depart record);
	    
	    public DataPage<Depart> getByExampleWithPage(DepartExample example);

	    Depart getdepartByName(String departName);
	    
	    List<Depart> departList();
}
