package com.cn.wy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.RolePermisMapper;
import com.cn.wy.dao.UserMapper;
import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.RolePermis;
import com.cn.wy.pojo.RolePermisExample;
import com.cn.wy.pojo.User;
import com.cn.wy.service.RolePermisService;
import com.cn.wy.service.UserService;
import com.cn.wy.utils.DataPage;
import com.cn.wy.utils.ResultDO;

@Service("rolePerService")
public class RolePermisServiceImpl implements RolePermisService{
	

	@Autowired
	private RolePermisMapper rolePermisMapper;
	@Override
	public long countByExample(RolePermisExample example) {
		return rolePermisMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RolePermisExample example) {
		return rolePermisMapper.deleteByExample(example);
	}

	@Override
	public int insert(RolePermis record) {
		return rolePermisMapper.insert(record);
	}

	@Override
	public int insertSelective(RolePermis record) {
		return rolePermisMapper.insertSelective(record);
	}

	@Override
	public List<RolePermis> selectByExample(RolePermisExample example) {
		return rolePermisMapper.selectByExample(example);
	}

	@Override
	public DataPage<RolePermis> getByExampleWithPage(RolePermisExample example) {
		 DataPage<RolePermis> data = new DataPage<RolePermis>();
			
	        data.setCurrentPage(example.getCurrentPage());
	        data.setPageSize(example.getPageSize());
	        data.setData(rolePermisMapper.selectByExample(example));
	        data.setTotalItem(rolePermisMapper.selectByExample(example).size());
	        return data;
	}

	@Override
	public void insertLists(List<RolePermis> posMenuReltions) {
		rolePermisMapper.insertLists(posMenuReltions);
	}

	@Override
	public void delete(Long perid) {
		rolePermisMapper.delete(perid);
	}
	
	@Override
	public ResultDO<Void> deleteRoleMenuByRoleIdAndSysType(Long roleId) {
		if (roleId == null || roleId == 0 ) {
			return new ResultDO<Void>("参数不正确");
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("roleId", String.valueOf(roleId));
//		params.put("sysType", sysType);
		if (rolePermisMapper.deleteListByRoleIdAndSysType(params) >= 0) {
			return new ResultDO<Void>(true);
		}
		return new ResultDO<Void>("操作失败");
	}
}
