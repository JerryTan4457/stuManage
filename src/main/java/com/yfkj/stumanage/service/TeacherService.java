package com.yfkj.stumanage.service;

import com.yfkj.stumanage.pojo.Grade;
import com.yfkj.stumanage.pojo.StudentView;
import com.yfkj.stumanage.pojo.Teacher;

import java.util.List;

/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年5月22日
 * @version 1.0
 */
public interface TeacherService {

	List<Teacher> getTeacherPager(int pageNO, int size);

	Teacher getTeacherId(int id);

	int getTeacherCount();

	int insert(Teacher entity);

	int delete(int id);

	int update(Teacher entity);

	int deletes(int[] ids);
	
	List<Teacher> getAllTeacher();

	int getMyStuCount(int id);
	
	Teacher loginTea(Teacher tea);
	
	List<StudentView> getMystus(int tid);
	
	int insertGrade(Grade grade);
	
}
