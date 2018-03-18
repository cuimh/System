package com.cn.wy.dao;

import com.cn.wy.pojo.Course;
import com.cn.wy.pojo.Score;
import com.cn.wy.pojo.ScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
    /**
     * 根据学号，课程ID查询信息
     * @param coursrid
     * @return
     */
    long countScore1(Long coursrid);
    
    List<Score> scoreList(String stuNo);
    
    long countScore(Score record);
    long countStuNo(String stuNo);
    
}