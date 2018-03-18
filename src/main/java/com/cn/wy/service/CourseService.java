package com.cn.wy.service;

import java.util.List;

import com.cn.wy.pojo.Course;
import com.cn.wy.pojo.CourseExample;
import com.cn.wy.utils.DataPage;

public interface CourseService {
	 long countByExample(CourseExample example);

	    int deleteByPrimaryKey(Long courseid);

	    int insert(Course record);


	    List<Course> selectByExample(CourseExample example);

	    Course selectByPrimaryKey(Long courseid);
	    
	    int updateByPrimaryKey(Course record);
	
	DataPage<Course> getByExampleWithPage(CourseExample example);

	Course getCourseByNo(Long classno);
	
}
