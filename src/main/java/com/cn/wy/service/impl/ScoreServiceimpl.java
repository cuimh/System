package com.cn.wy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.controller.ScoreController;
import com.cn.wy.dao.ScoreMapper;
import com.cn.wy.pojo.Course;
import com.cn.wy.pojo.Score;
import com.cn.wy.pojo.ScoreExample;
import com.cn.wy.service.ScoreService;
import com.cn.wy.utils.DataPage;
@Service("scoreService")
public class ScoreServiceimpl implements ScoreService{
	private static Logger logger = LoggerFactory.getLogger(ScoreService.class); 

	@Autowired
	private ScoreMapper scoreMapper;
	@Override
	public long countByExample(ScoreExample example) {
		return scoreMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ScoreExample example) {
		// TODO Auto-generated method stub
		return scoreMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return scoreMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Score record) {
		// TODO Auto-generated method stub
		return scoreMapper.insert(record);
	}


	@Override
	public List<Score> selectByExample(ScoreExample example) {
		// TODO Auto-generated method stub
		return scoreMapper.selectByExample(example);
	}

	@Override
	public Score selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return scoreMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Score record) {
		// TODO Auto-generated method stub
		return scoreMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataPage<Score> getByExampleWithPage(ScoreExample example) {
		DataPage<Score> data = new DataPage<Score>();
        example.setOrderBy("id desc");
        data.setCurrentPage(example.getCurrentPage());
        data.setPageSize(example.getPageSize());
        data.setData(scoreMapper.selectByExample(example));
        data.setTotalItem(scoreMapper.selectByExample(example).size());
        return data;
	}

	@Override
	public long countScore(Score record) {
		return scoreMapper.countScore(record);
	}

	@Override
	public long countScore1(Long coursrid) {
		// TODO Auto-generated method stub
		return scoreMapper.countScore1(coursrid);
	}

	@Override
	public List<Score> scoreList(String stuNo) {
		// TODO Auto-generated method stub
		return scoreMapper.scoreList(stuNo);
	}

	@Override
	public long countStuNo(String stuNo) {
		// TODO Auto-generated method stub
		return scoreMapper.countStuNo(stuNo);
	}


}
