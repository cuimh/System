package com.cn.wy.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.wy.pojo.Course;
import com.cn.wy.pojo.CourseExample;
import com.cn.wy.pojo.Score;
import com.cn.wy.pojo.ScoreExample;
import com.cn.wy.utils.DataPage;

public interface ScoreService {
	 long countByExample(ScoreExample example);

	    int deleteByExample(ScoreExample example);

	    int deleteByPrimaryKey(Long id);

	    int insert(Score record);


	    List<Score> selectByExample(ScoreExample example);

	    Score selectByPrimaryKey(Long id);




	    int updateByPrimaryKey(Score record);
	    
	
	    
	    DataPage<Score> getByExampleWithPage(ScoreExample example);
	    /**
	     * 根据学号，课程ID统计
	     * @param record
	     * @return
	     */
	    long countScore(Score record);
	    long countScore1(Long coursrid);
	    List<Score> scoreList(String stuNo);
	    long countStuNo(String stuNo);
}
