package com.cn.wy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.UserMapper;
import com.cn.wy.pojo.User;
import com.cn.wy.pojo.UserExample;
import com.cn.wy.service.UserService;
import com.cn.wy.utils.DataPage;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	public int insert(User record) {
		int result = userMapper.insert(record);
		return result;
	}

	@Override
	public DataPage<User> getByExampleWithPage(UserExample example) {
		 DataPage<User> data = new DataPage<User>();
		
	        data.setCurrentPage(example.getCurrentPage());
	        data.setPageSize(example.getPageSize());
	        data.setData(userMapper.selectByExample(example));
	        data.setTotalItem(userMapper.selectByExample(example).size());
	        return data;
	}

	@Override
	public long countByExample(UserExample example) {
		
		return userMapper.countByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteByExample(UserExample example) {
		return userMapper.deleteByExample(example);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		return userMapper.selectByExample(example);
	}

	@Override
	public User selectByPrimaryKey(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public User selectByUsername(String name) {
		return userMapper.selectByUsername(name);
	}

}
