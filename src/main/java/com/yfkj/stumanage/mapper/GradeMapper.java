package com.yfkj.stumanage.mapper;


import com.yfkj.stumanage.pojo.Grade;

public interface GradeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
    
    int insertGrade(Grade grade);
    
}