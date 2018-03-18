package com.cn.wy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.PersissionMapper;
import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.PersissionExample;
import com.cn.wy.service.PersisService;
import com.cn.wy.service.UserService;
import com.cn.wy.utils.DataPage;
@Service("perService")
public class PersisServiceImpl implements PersisService{
	
	 @Autowired
	 private PersissionMapper perMapper;
	@Override
	public long countByExample(PersissionExample example) {
		return perMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(PersissionExample example) {
		return perMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return perMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Persission record) {
		return perMapper.insert(record);
	}

	@Override
	public int insertSelective(Persission record) {
		return perMapper.insertSelective(record);
	}

	@Override
	public List<Persission> selectByExample(PersissionExample example) {
		return perMapper.selectByExample(example);
	}

	@Override
	public Persission selectByPrimaryKey(Long id) {
		return perMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Persission record) {
		return perMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Persission record) {
		return perMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataPage<Persission> getByExampleWithPage(PersissionExample example) {
		DataPage<Persission> data = new DataPage<Persission>();
        example.setOrderBy("id desc");
        data.setCurrentPage(example.getCurrentPage());
        data.setPageSize(example.getPageSize());
        data.setData(perMapper.selectByExample(example));
        data.setTotalItem(perMapper.selectByExample(example).size());
        return data;
	}

	@Override
	public List<Persission> findFristMenus() {
		return perMapper.findFristMenus();
	}

	@Override
	public List<Persission> sysList() {
		return perMapper.sysList();
	}

	@Override
	public List<Persission> getMenuListBySysType(Long pid) {
		return perMapper.getMenuListBySysType(pid);
	}

}
