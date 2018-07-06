package com.yfkj.stumanage.mapper;


import com.yfkj.stumanage.pojo.CourseExt;
import com.yfkj.stumanage.pojo.Student;
import com.yfkj.stumanage.pojo.StudentExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Student record);
    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Student record);
    int updateByPrimaryKey(Student record);
    List<Student> getStudentPager(@Param("skip") int skip, @Param("size") int size);
    int getCount();
    
    List<StudentExt> getStuByCid(int id);
    Student stulogin(Student student);
    List<CourseExt> getXuxiu(int classid);
    
    List<CourseExt> getBxCourse(int classid);
    List<CourseExt> getxxCourse(int stuid);
    
}