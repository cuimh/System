package com.cn.wy.service;

import java.util.List;

import com.cn.wy.pojo.TeaInfo;
import com.cn.wy.pojo.TeaInfoExample;
import com.cn.wy.utils.DataPage;

public interface TeaService {
		long countByExample(TeaInfoExample example);

	    int deleteByPrimaryKey(Long id);

	    int insert(TeaInfo record);

	    List<TeaInfo> selectByExample(TeaInfoExample example);

	    TeaInfo selectByPrimaryKey(Long id);
	    
	    int updateByPrimaryKey(TeaInfo record);
		
		DataPage<TeaInfo> getByExampleWithPage(TeaInfoExample example);

		TeaInfo getTeaByNo(String teaNo);
		
		List<TeaInfo> teaList(Long departid);
	}
