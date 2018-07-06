package com.yfkj.stumanage.mapper;

import com.yfkj.stumanage.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
    List<Course> getCoursePager(@Param("skip") int skip, @Param("size") int size);

	Course getCourseId(int id);

	int getCourseCount();

	int delete(int id);

	int update(Course entity);
    
    
}