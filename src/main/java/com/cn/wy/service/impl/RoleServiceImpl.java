package com.cn.wy.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.wy.dao.PersissionMapper;
import com.cn.wy.dao.RoleMapper;
import com.cn.wy.dao.RolePermisMapper;
import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.Role;
import com.cn.wy.pojo.RoleExample;
import com.cn.wy.pojo.RolePermis;
import com.cn.wy.pojo.User;
import com.cn.wy.pojo.UserExample;
import com.cn.wy.service.RoleService;
import com.cn.wy.service.UserService;
import com.cn.wy.utils.DataPage;
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	

		@Autowired
		private RoleMapper roleMapper;
		
		@Autowired
		private RolePermisMapper rolePerMapper;
		
	@Override
	public long countByExample(RoleExample example) {
		return roleMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RoleExample example) {
		return roleMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Role record) {
		return roleMapper.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		return roleMapper.insertSelective(record);
	}

	@Override
	public List<Role> selectByExample(RoleExample example) {
		return roleMapper.selectByExample(example);
	}

	@Override
	public Role selectByPrimaryKey(Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return roleMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataPage<Role> getByExampleWithPage(RoleExample example) {
		DataPage<Role> data = new DataPage<Role>();
        example.setOrderBy("id desc");
        data.setCurrentPage(example.getCurrentPage());
        data.setPageSize(example.getPageSize());
        data.setData(roleMapper.selectByExample(example));
        data.setTotalItem(roleMapper.selectByExample(example).size());
        return data;
	}

	@Override
	public List<Role> findRole() {
		return roleMapper.findRole();
	}

	@Override
	public void deleteRoleAndPer(Role role, RolePermis per) {
		this.roleMapper.deleteByPrimaryKey(role.getId());
		if(per != null) this.rolePerMapper.delete(per.getPerid());
	}

	@Override
	public void changePower(List<RolePermis> posMenuReltions, List<RolePermis> lists) {
		if (lists.size() > 0) this.rolePerMapper.delete(lists.get(0));
		this.rolePerMapper.insertLists(posMenuReltions);
	}

	@Override
	public List<Persission> getPosById(Long positionId) {
		return roleMapper.getPosById(positionId);
		
	}

}
