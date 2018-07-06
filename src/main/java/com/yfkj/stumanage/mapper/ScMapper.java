package com.yfkj.stumanage.mapper;


import com.yfkj.stumanage.pojo.Sc;
import com.yfkj.stumanage.pojo.ScKey;

import java.util.List;

public interface ScMapper {

    int deleteByPrimaryKey(ScKey key);

    int insert(Sc record);

    int insertSelective(Sc record);

    Sc selectByPrimaryKey(ScKey key);

    int updateByPrimaryKeySelective(Sc record);

    int updateByPrimaryKey(Sc record);
    
    int inserBatch(List<Sc> sclist);
 
}