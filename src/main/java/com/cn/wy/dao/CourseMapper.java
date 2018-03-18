package com.cn.wy.dao;

import com.cn.wy.pojo.Course;
import com.cn.wy.pojo.CourseExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Long courseid);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);
    /**
     * 根据课程ID查询信息
     * @param courseid
     * @return
     */
    Course selectByPrimaryKey(Long courseid);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
	Course getCourseByNo(Long classno);

}