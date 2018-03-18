package com.cn.wy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.DepartMapper;
import com.cn.wy.pojo.Classroom;
import com.cn.wy.pojo.Depart;
import com.cn.wy.pojo.DepartExample;
import com.cn.wy.service.DepartService;
import com.cn.wy.service.UserService;
import com.cn.wy.utils.DataPage;

@Service("departService")
public class DepartServiceimpl implements DepartService{
	 @Autowired
	 private DepartMapper departMapper;
	@Override
	public long countByExample(DepartExample example) {
		// TODO Auto-generated method stub
		return departMapper.countByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long departid) {
		// TODO Auto-generated method stub
		return departMapper.deleteByPrimaryKey(departid);
	}

	@Override
	public int insert(Depart record) {
		// TODO Auto-generated method stub
		return departMapper.insert(record);
	}

	@Override
	public List<Depart> selectByExample(DepartExample example) {
		// TODO Auto-generated method stub
		return departMapper.selectByExample(example);
	}

	@Override
	public Depart selectByPrimaryKey(Long departid) {
		// TODO Auto-generated method stub
		return departMapper.selectByPrimaryKey(departid);
	}

	@Override
	public int updateByPrimaryKey(Depart record) {
		// TODO Auto-generated method stub
		return departMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataPage<Depart> getByExampleWithPage(DepartExample example) {
		 DataPage<Depart> data = new DataPage<Depart>();
	        data.setCurrentPage(example.getCurrentPage());
	        data.setPageSize(example.getPageSize());
	        data.setData(departMapper.selectByExample(example));
	        data.setTotalItem(departMapper.selectByExample(example).size());
	        return data;
	}

	@Override
	public Depart getdepartByName(String departName) {
		// TODO Auto-generated method stub
		return departMapper.getdepartByName(departName);
	}

	@Override
	public List<Depart> departList() {
		// TODO Auto-generated method stub
		return departMapper.departList();
	}

}
