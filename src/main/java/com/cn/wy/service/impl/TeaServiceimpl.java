package com.cn.wy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.TeaInfoMapper;
import com.cn.wy.pojo.TeaInfo;
import com.cn.wy.pojo.TeaInfoExample;
import com.cn.wy.service.TeaService;
import com.cn.wy.utils.DataPage;

@Service("teaService")
public class TeaServiceimpl implements TeaService{
	@Autowired
	 private TeaInfoMapper teaMapper;
	@Override
	public long countByExample(TeaInfoExample example) {
		// TODO Auto-generated method stub
		return teaMapper.countByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return teaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TeaInfo record) {
		// TODO Auto-generated method stub
		return teaMapper.insert(record);
	}

	@Override
	public List<TeaInfo> selectByExample(TeaInfoExample example) {
		// TODO Auto-generated method stub
		return teaMapper.selectByExample(example);
	}

	@Override
	public TeaInfo selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return teaMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(TeaInfo record) {
		// TODO Auto-generated method stub
		return teaMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataPage<TeaInfo> getByExampleWithPage(TeaInfoExample example) {
		DataPage<TeaInfo> data = new DataPage<TeaInfo>();
        example.setOrderBy("id desc");
        data.setCurrentPage(example.getCurrentPage());
        data.setPageSize(example.getPageSize());
        data.setData(teaMapper.selectByExample(example));
        data.setTotalItem(teaMapper.selectByExample(example).size());
        return data;
	}

	@Override
	public TeaInfo getTeaByNo(String teaNo) {
		// TODO Auto-generated method stub
		return teaMapper.getTeaByNo(teaNo);
	}

	@Override
	public List<TeaInfo> teaList(Long departid) {
		// TODO Auto-generated method stub
		return teaMapper.teaList(departid);
	}

}
