package com.cn.wy.dao;

import com.cn.wy.pojo.Classroom;
import com.cn.wy.pojo.ClassroomExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassroomMapper {
    long countByExample(ClassroomExample example);

    int deleteByExample(ClassroomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    List<Classroom> selectByExample(ClassroomExample example);

    Classroom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Classroom record, @Param("example") ClassroomExample example);

    int updateByExample(@Param("record") Classroom record, @Param("example") ClassroomExample example);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);
    
    Classroom getRoomByNo(Integer classNo);
    
    List<Classroom> roomList();
}