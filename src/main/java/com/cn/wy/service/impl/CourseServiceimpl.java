package com.cn.wy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.CourseMapper;
import com.cn.wy.pojo.Course;
import com.cn.wy.pojo.CourseExample;
import com.cn.wy.service.CourseService;
import com.cn.wy.utils.DataPage;
@Service("courseService")
public class CourseServiceimpl implements CourseService{
	@Autowired
	private CourseMapper courseMapper;
	@Override
	public long countByExample(CourseExample example) {
		// TODO Auto-generated method stub
		return courseMapper.countByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long courseid) {
		// TODO Auto-generated method stub
		return courseMapper.deleteByPrimaryKey(courseid);
	}

	@Override
	public int insert(Course record) {
		// TODO Auto-generated method stub
		return courseMapper.insert(record);
	}

	@Override
	public List<Course> selectByExample(CourseExample example) {
		// TODO Auto-generated method stub
		return courseMapper.selectByExample(example);
	}
	/**
	 * 根据课程ID查询信息
	 */
	@Override
	public Course selectByPrimaryKey(Long courseid) {
		return courseMapper.selectByPrimaryKey(courseid);
	}

	@Override
	public int updateByPrimaryKey(Course record) {
		// TODO Auto-generated method stub
		return courseMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataPage<Course> getByExampleWithPage(CourseExample example) {
		DataPage<Course> data = new DataPage<Course>();
        example.setOrderBy("id desc");
        data.setCurrentPage(example.getCurrentPage());
        data.setPageSize(example.getPageSize());
        data.setData(courseMapper.selectByExample(example));
        data.setTotalItem(courseMapper.selectByExample(example).size());
        return data;
	}

	@Override
	public Course getCourseByNo(Long classno) {
		return courseMapper.getCourseByNo(classno);
	}


}
