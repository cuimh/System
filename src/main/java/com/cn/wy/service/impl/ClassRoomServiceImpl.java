package com.cn.wy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.ClassroomMapper;
import com.cn.wy.pojo.Classroom;
import com.cn.wy.pojo.ClassroomExample;
import com.cn.wy.pojo.UserExample;
import com.cn.wy.service.ClassRoomService;
import com.cn.wy.service.UserService;
import com.cn.wy.utils.DataPage;
@Service("classRoomService")
public class ClassRoomServiceImpl implements ClassRoomService{
	 @Autowired
	 private ClassroomMapper classRoomMapper;
	@Override
	public long countByExample(ClassroomExample example) {
		return classRoomMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ClassroomExample example) {
		return classRoomMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return classRoomMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Classroom record) {
		return classRoomMapper.insert(record);
	}

	@Override
	public int insertSelective(Classroom record) {
		return classRoomMapper.insertSelective(record);
	}

	@Override
	public List<Classroom> selectByExample(ClassroomExample example) {
		return classRoomMapper.selectByExample(example);
	}
	/**
	 * 根据教室ID查询
	 */
	@Override
	public Classroom selectByPrimaryKey(Long id) {
		return classRoomMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Classroom record) {
		return classRoomMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Classroom record) {
		return classRoomMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public DataPage<Classroom> getByExampleWithPage(ClassroomExample example) {
		 DataPage<Classroom> data = new DataPage<Classroom>();
	        data.setCurrentPage(example.getCurrentPage());
	        data.setPageSize(example.getPageSize());
	        data.setData(classRoomMapper.selectByExample(example));
	        data.setTotalItem(classRoomMapper.selectByExample(example).size());
	        return data;
	}

	@Override
	public Classroom getRoomByNo(Integer classNo) {
		return classRoomMapper.getRoomByNo(classNo);
	}

	@Override
	public List<Classroom> roomList() {
		// TODO Auto-generated method stub
		return classRoomMapper.roomList();
	}
}
