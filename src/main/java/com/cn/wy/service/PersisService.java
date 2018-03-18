package com.cn.wy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.PersissionExample;
import com.cn.wy.pojo.Role;
import com.cn.wy.pojo.RoleExample;
import com.cn.wy.utils.DataPage;

public interface PersisService {
	long countByExample(PersissionExample example);

    int deleteByExample(PersissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Persission record);

    int insertSelective(Persission record);

    List<Persission> selectByExample(PersissionExample example);

    Persission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Persission record);

    int updateByPrimaryKey(Persission record);	
    
    DataPage<Persission> getByExampleWithPage(PersissionExample example);
    
    List<Persission> findFristMenus();
    
    List<Persission> sysList();
    
    List<Persission> getMenuListBySysType(Long pid);

}
