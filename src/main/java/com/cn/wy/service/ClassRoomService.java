package com.cn.wy.service;

import java.util.List;

import com.cn.wy.pojo.Classroom;
import com.cn.wy.pojo.ClassroomExample;
import com.cn.wy.utils.DataPage;

public interface ClassRoomService {
	long countByExample(ClassroomExample example);

    int deleteByExample(ClassroomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    List<Classroom> selectByExample(ClassroomExample example);
    /**
     * 根据教室ID查询信息
     * @param id
     * @return
     */
    Classroom selectByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);
    
	public DataPage<Classroom> getByExampleWithPage(ClassroomExample example);

    Classroom getRoomByNo(Integer classNo);
    
    List<Classroom> roomList();

}
