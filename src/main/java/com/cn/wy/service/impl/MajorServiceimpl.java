package com.cn.wy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.MajorMapper;
import com.cn.wy.pojo.Major;
import com.cn.wy.pojo.MajorExample;
import com.cn.wy.service.MajorService;
import com.cn.wy.utils.DataPage;
@Service("majorService")
public class MajorServiceimpl implements MajorService{
	 @Autowired
	 private MajorMapper majorMapper;
	@Override
	public long countByExample(MajorExample example) {
		// TODO Auto-generated method stub
		return majorMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MajorExample example) {
		// TODO Auto-generated method stub
		return majorMapper.deleteByExample(example);
	}

	

	@Override
	public int insert(Major record) {
		// TODO Auto-generated method stub
		return majorMapper.insert(record);
	}

	@Override
	public int insertSelective(Major record) {
		// TODO Auto-generated method stub
		return majorMapper.insertSelective(record);
	}

	@Override
	public List<Major> selectByExample(MajorExample example) {
		// TODO Auto-generated method stub
		return majorMapper.selectByExample(example);
	}

	

	@Override
	public int updateByPrimaryKey(Major record) {
		// TODO Auto-generated method stub
		return majorMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataPage<Major> getByExampleWithPage(MajorExample example) {
		DataPage<Major> data = new DataPage<Major>();
        data.setCurrentPage(example.getCurrentPage());
        data.setPageSize(example.getPageSize());
        data.setData(majorMapper.selectByExample(example));
        data.setTotalItem(majorMapper.selectByExample(example).size());
        return data;
	}

	@Override
	public Major getMajorByNo(String majorName) {
		// TODO Auto-generated method stub
		return majorMapper.getMajorByNo(majorName);
	}

	@Override
	public List<Major> majorList(Long departid) {
		// TODO Auto-generated method stub
		return majorMapper.majorList(departid);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return majorMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Major selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return majorMapper.selectByPrimaryKey(id);
	}

}
