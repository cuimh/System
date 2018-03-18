package com.cn.wy.dao;

import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.RolePermis;
import com.cn.wy.pojo.RolePermisExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RolePermisMapper {
    long countByExample(RolePermisExample example);

    int deleteByExample(RolePermisExample example);

    int insert(RolePermis record);

    int insertSelective(RolePermis record);

    List<RolePermis> selectByExample(RolePermisExample example);

    int updateByExampleSelective(@Param("record") RolePermis record, @Param("example") RolePermisExample example);

    int updateByExample(@Param("record") RolePermis record, @Param("example") RolePermisExample example);

	void delete(Long perid);
	
	void insertLists(List<RolePermis> posMenuReltions);

	void delete(RolePermis rolePermis);
	
	public Integer deleteListByRoleIdAndSysType(Map<String, String> params);
	
}