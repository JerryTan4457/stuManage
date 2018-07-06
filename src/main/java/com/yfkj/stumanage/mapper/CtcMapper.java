package com.yfkj.stumanage.mapper;


import com.yfkj.stumanage.pojo.CtcKey;

import java.util.List;

public interface CtcMapper {

    int deleteByPrimaryKey(CtcKey key);

    int insert(CtcKey record);

    int insertSelective(CtcKey record);
   
    void  insertBatch(List<CtcKey> ctclist);
}