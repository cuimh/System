package com.cn.wy.service;

import java.util.List;

import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.Role;
import com.cn.wy.pojo.RoleExample;
import com.cn.wy.pojo.RolePermis;
import com.cn.wy.pojo.User;
import com.cn.wy.pojo.UserExample;
import com.cn.wy.utils.DataPage;

public interface RoleService {
	long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    DataPage<Role> getByExampleWithPage(RoleExample example);
    
    List<Role> findRole();
    
    void deleteRoleAndPer(Role role,RolePermis posMenuReltion);
    
    void changePower(List<RolePermis> posMenuReltions, List<RolePermis> lists);
		
    public List<Persission> getPosById(Long positionId);

}
