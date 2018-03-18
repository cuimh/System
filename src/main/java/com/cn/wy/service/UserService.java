package com.cn.wy.service;

import java.util.List;

import com.cn.wy.pojo.User;
import com.cn.wy.pojo.UserExample;
import com.cn.wy.utils.DataPage;

public interface UserService {
	/**
	 * 添加用户
	 * @param record
	 * @return
	 */
	int insert(User record);
	/**
	 * 分页
	 * @param example
	 * @return
	 */
    DataPage<User> getByExampleWithPage(UserExample example);
    
    /**
     * 根据条件统计用户信息
     *
     * @param example
     * @return
     */
    long countByExample(UserExample example);
    /**
     * 删除用户信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);
	
    int deleteByExample(UserExample example);
    
    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUsername(String name);
    
}
