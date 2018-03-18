package com.cn.wy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.StuInfoMapper;
import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.StuInfo;
import com.cn.wy.pojo.StuInfoExample;
import com.cn.wy.service.StuService;
import com.cn.wy.utils.DataPage;
@Service("stuService")
public class StuServiceimpl implements StuService{
	 @Autowired
	 private StuInfoMapper stuMapper;
	@Override
	public long countByExample(StuInfoExample example) {
		return stuMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(StuInfoExample example) {
		// TODO Auto-generated method stub
		return stuMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return stuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(StuInfo record) {
		// TODO Auto-generated method stub
		return stuMapper.insert(record);
	}

	@Override
	public int insertSelective(StuInfo record) {
		// TODO Auto-generated method stub
		return stuMapper.insertSelective(record);
	}

	@Override
	public List<StuInfo> selectByExample(StuInfoExample example) {
		// TODO Auto-generated method stub
		return stuMapper.selectByExample(example);
	}

	@Override
	public StuInfo selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return stuMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(StuInfo record) {
		// TODO Auto-generated method stub
		return stuMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataPage<StuInfo> getByExampleWithPage(StuInfoExample example) {
		DataPage<StuInfo> data = new DataPage<StuInfo>();
        example.setOrderBy("id desc");
        data.setCurrentPage(example.getCurrentPage());
        data.setPageSize(example.getPageSize());
        data.setData(stuMapper.selectByExample(example));
        data.setTotalItem(stuMapper.selectByExample(example).size());
        return data;
	}

	@Override
	public StuInfo getStuByNo(String stuNo) {
		// TODO Auto-generated method stub
		return stuMapper.getStuByNo(stuNo);
	}

}
