package com.yfkj.stumanage.service;

import com.yfkj.stumanage.pojo.CourseExt;
import com.yfkj.stumanage.pojo.Sc;
import com.yfkj.stumanage.pojo.Student;
import com.yfkj.stumanage.pojo.StudentExt;

import java.util.List;

public interface StudentService {
	List<Student> getStudentPager(int pageNO, int size);
	int getCount();
	int deleteByPrimaryKey(Integer id);//删除
	int multiDelete(int[] ids);
	int insert(Student record);
	Student selectByPrimaryKey(Integer id);
	int updateByPrimaryKey(Student record);
	List<StudentExt> getStuByCid(int id);
	
	Student stulogin(Student student);
	
	List<CourseExt> getXuxiu(int classid);
	
	int inserBatch(List<Sc> sclist);
	 
	List<CourseExt> getMycourses(int classid, int stuid);

}
