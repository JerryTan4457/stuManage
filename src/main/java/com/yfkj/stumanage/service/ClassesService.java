package com.yfkj.stumanage.service;


import com.yfkj.stumanage.pojo.Classes;

import java.util.List;

public interface ClassesService {
	List<Classes> getAllClasses();
	
	List<Classes> getClassPager(int pageNO, int size);

	Classes getCLassId(int id);

	int getClassesCount();

	int insert(Classes entity);

	int delete(int id);

	int deletes(int[] ids);

	int update(Classes entity);
	
	Classes getStuByid(int id);
	
}
