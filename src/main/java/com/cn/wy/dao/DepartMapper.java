package com.cn.wy.dao;

import com.cn.wy.pojo.Depart;
import com.cn.wy.pojo.DepartExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartMapper {
    long countByExample(DepartExample example);

    int deleteByExample(DepartExample example);

    int deleteByPrimaryKey(Long departid);

    int insert(Depart record);

    int insertSelective(Depart record);

    List<Depart> selectByExample(DepartExample example);

    Depart selectByPrimaryKey(Long departid);

    int updateByExampleSelective(@Param("record") Depart record, @Param("example") DepartExample example);

    int updateByExample(@Param("record") Depart record, @Param("example") DepartExample example);

    int updateByPrimaryKeySelective(Depart record);

    int updateByPrimaryKey(Depart record);
    
    Depart getdepartByName(String departName);
    
    List<Depart> departList();


}