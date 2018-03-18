package com.cn.wy.service;

import java.util.List;

import com.cn.wy.pojo.Classroom;
import com.cn.wy.pojo.ClassroomExample;
import com.cn.wy.pojo.Major;
import com.cn.wy.pojo.MajorExample;
import com.cn.wy.utils.DataPage;

public interface MajorService {
	 long countByExample(MajorExample example);

	    int deleteByExample(MajorExample example);

	    int deleteByPrimaryKey(Long id);

	    int insert(Major record);

	    int insertSelective(Major record);

	    List<Major> selectByExample(MajorExample example);

	    Major selectByPrimaryKey(Long id);
	    
	    int updateByPrimaryKey(Major record);
	    
	public DataPage<Major> getByExampleWithPage(MajorExample example);

	Major getMajorByNo(String majorName);
	
	List<Major> majorList(Long departid);
	
}
