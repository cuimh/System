package com.cn.wy.dao;

import com.cn.wy.pojo.TeaInfo;
import com.cn.wy.pojo.TeaInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeaInfoMapper {
    long countByExample(TeaInfoExample example);

    int deleteByExample(TeaInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeaInfo record);

    int insertSelective(TeaInfo record);

    List<TeaInfo> selectByExample(TeaInfoExample example);

    TeaInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeaInfo record, @Param("example") TeaInfoExample example);

    int updateByExample(@Param("record") TeaInfo record, @Param("example") TeaInfoExample example);

    int updateByPrimaryKeySelective(TeaInfo record);

    int updateByPrimaryKey(TeaInfo record);
    
	TeaInfo getTeaByNo(String teaNo);
	List<TeaInfo> teaList(Long departid);
}