package com.cn.wy.dao;

import com.cn.wy.pojo.Persission;
import com.cn.wy.pojo.PersissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersissionMapper {
    long countByExample(PersissionExample example);

    int deleteByExample(PersissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Persission record);

    int insertSelective(Persission record);

    List<Persission> selectByExample(PersissionExample example);

    Persission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Persission record, @Param("example") PersissionExample example);

    int updateByExample(@Param("record") Persission record, @Param("example") PersissionExample example);

    int updateByPrimaryKeySelective(Persission record);

    int updateByPrimaryKey(Persission record);
    
    List<Persission> findFristMenus();
    
    List<Persission> sysList();
    
    List<Persission> getMenuListBySysType(Long pid);
}