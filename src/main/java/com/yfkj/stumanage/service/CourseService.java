package com.yfkj.stumanage.service;


import com.yfkj.stumanage.pojo.Course;
import com.yfkj.stumanage.pojo.CtcKey;

import java.util.List;

/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年5月22日
 * @version 1.0
 */
public interface CourseService {

	List<Course> getCoursePager(int pageNO, int size);

	Course getCourseId(int id);

	int getCourseCount();

	int insert(Course entity);

	int delete(int id);

	int update(Course entity);

	int deletes(int[] ids);
	
	void  insertBatch(List<CtcKey> ctclist);

}
