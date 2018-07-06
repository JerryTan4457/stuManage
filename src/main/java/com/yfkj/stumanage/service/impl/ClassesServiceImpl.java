package com.yfkj.stumanage.service.impl;

import com.yfkj.stumanage.mapper.ClassesMapper;
import com.yfkj.stumanage.pojo.Classes;
import com.yfkj.stumanage.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	ClassesMapper classesMapper;
	
	@Override
	public List<Classes> getAllClasses() {
		// TODO Auto-generated method stub
		return classesMapper.getAllClasses();
	}

	@Override
	public List<Classes> getClassPager(int pageNO, int size) {
		// TODO Auto-generated method stub
		int skip=(pageNO-1)*size;
		return classesMapper.getClassPager(skip, size);
	}

	@Override
	public Classes getCLassId(int id) {
		// TODO Auto-generated method stub
		return classesMapper.getCLassId(id);
	}

	@Override
	public int getClassesCount() {
		// TODO Auto-generated method stub
		return classesMapper.getClassesCount();
	}

	@Override
	public int insert(Classes entity) {
		// TODO Auto-generated method stub
		return classesMapper.insert(entity);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		int row=classesMapper.delete(id);
		return row;
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stu
		int rows=0;
		for(int id:ids){
			rows+=delete(id);
		}
		return rows;
	}

	@Override
	public int update(Classes entity) {
		// TODO Auto-generated method stub
		return classesMapper.update(entity);
	}

	@Override
	public Classes getStuByid(int id) {
		// TODO Auto-generated method stub
		return classesMapper.getStuByid(id);
	}

}
