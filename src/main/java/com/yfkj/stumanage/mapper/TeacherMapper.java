package com.yfkj.stumanage.mapper;


import com.yfkj.stumanage.pojo.StudentView;
import com.yfkj.stumanage.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);


    Teacher selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    
    List<Teacher> getTeacherPager(@Param("skip") int skip, @Param("size") int size);

	Teacher getTeacherId(int id);

	int getTeacherCount();

	int delete(int id);

	int update(Teacher entity);
	
	List<Teacher> getAllTeacher();
	
	Teacher loginTea(Teacher tea);
	
	Teacher tealogin(Teacher teacher);
	
	List<StudentView> getxxStudent(int tid);
	
	List<StudentView> getbxStudent(int tid);
	
    
}