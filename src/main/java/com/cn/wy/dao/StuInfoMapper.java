package com.cn.wy.dao;

import com.cn.wy.pojo.StuInfo;
import com.cn.wy.pojo.StuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuInfoMapper {
    long countByExample(StuInfoExample example);

    int deleteByExample(StuInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

    List<StuInfo> selectByExample(StuInfoExample example);

    StuInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StuInfo record, @Param("example") StuInfoExample example);

    int updateByExample(@Param("record") StuInfo record, @Param("example") StuInfoExample example);

    int updateByPrimaryKeySelective(StuInfo record);

    int updateByPrimaryKey(StuInfo record);
    
    StuInfo getStuByNo(String stuNo);

}