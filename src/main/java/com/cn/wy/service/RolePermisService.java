package com.cn.wy.service;

import java.util.List;

import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.RolePermis;
import com.cn.wy.pojo.RolePermisExample;
import com.cn.wy.pojo.User;
import com.cn.wy.pojo.UserExample;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.ResultDO;

public interface RolePermisService {
	long countByExample(RolePermisExample example);

    int deleteByExample(RolePermisExample example);

    int insert(RolePermis record);

    int insertSelective(RolePermis record);

    List<RolePermis> selectByExample(RolePermisExample example);
    
    DataPage<RolePermis> getByExampleWithPage(RolePermisExample example);
    
	void insertLists(List<RolePermis> posMenuReltions);

	void delete(Long perid);
	
	public ResultDO<Void> deleteRoleMenuByRoleIdAndSysType(Long roleId);

}
