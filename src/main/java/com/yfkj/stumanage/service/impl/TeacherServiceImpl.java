package com.yfkj.stumanage.service.impl;

import com.yfkj.stumanage.mapper.GradeMapper;
import com.yfkj.stumanage.mapper.TeacherMapper;
import com.yfkj.stumanage.pojo.Grade;
import com.yfkj.stumanage.pojo.StudentView;
import com.yfkj.stumanage.pojo.Teacher;
import com.yfkj.stumanage.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年5月22日
 * @version 1.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {

	 //自动装配
    @Autowired
	 TeacherMapper teacherMapper;
    @Autowired
	GradeMapper gradeMapper;

	@Override
	public int deletes(int[] ids) {
		int rows=0;
        for (int id : ids) {
            rows+=delete(id);
        }
     return rows;
	}

	@Override
	public List<Teacher> getTeacherPager(int pageNO, int size) {
		int skip=(pageNO-1)*size;
		return teacherMapper.getTeacherPager(skip, size);
	}

	@Override
	public Teacher getTeacherId(int id) {
		// TODO Auto-generated method stub
		return teacherMapper.getTeacherId(id);
	}

	@Override
	public int getTeacherCount() {
		// TODO Auto-generated method stub
		return teacherMapper.getTeacherCount();
	}
	@Override
	public int insert(Teacher entity) {
		// TODO Auto-generated method stub
		return teacherMapper.insert(entity);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return teacherMapper.delete(id);
	}

	@Override
	public int update(Teacher entity) {
		// TODO Auto-generated method stub
		return teacherMapper.update(entity);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return teacherMapper.getAllTeacher();
	}

	@Override
	public Teacher loginTea(Teacher tea) {
		// TODO Auto-generated method stub
		return teacherMapper.tealogin(tea);
	}

	@Override
	public int getMyStuCount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StudentView> getMystus(int tid) {
		// TODO Auto-generated method stub
		List<StudentView> xxslist=teacherMapper.getxxStudent(tid);
		List<StudentView> bxslist=teacherMapper.getbxStudent(tid);
		List<StudentView> slist=new ArrayList<StudentView>();
		slist.addAll(xxslist);
		slist.addAll(bxslist);
		return slist;
	}

	@Override
	public int insertGrade(Grade grade) {
		// TODO Auto-generated method stub
		return gradeMapper.insertGrade(grade);
	}


}