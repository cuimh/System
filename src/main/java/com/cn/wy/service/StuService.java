package com.cn.wy.service;

import java.util.List;

import com.cn.wy.pojo.StuInfo;
import com.cn.wy.pojo.StuInfoExample;
import com.cn.wy.utils.DataPage;

public interface StuService {
	long countByExample(StuInfoExample example);

    int deleteByExample(StuInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

    List<StuInfo> selectByExample(StuInfoExample example);

    StuInfo selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(StuInfo record);
    
    DataPage<StuInfo> getByExampleWithPage(StuInfoExample example);

    StuInfo getStuByNo(String stuNo);
}
