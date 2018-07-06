package com.yfkj.stumanage.service.impl;

import com.yfkj.stumanage.mapper.CourseMapper;
import com.yfkj.stumanage.mapper.CtcMapper;
import com.yfkj.stumanage.pojo.Course;
import com.yfkj.stumanage.pojo.CtcKey;
import com.yfkj.stumanage.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年5月22日
 * @version 1.0
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
	 CourseMapper courseMapper;
    @Autowired
	CtcMapper ctcMapper;

	@Override
	public int deletes(int[] ids) {
		int rows=0;
        for (int id : ids) {
            rows+=delete(id);
        }
     return rows;
	}

	@Override
	public List<Course> getCoursePager(int pageNO, int size) {
		int skip=(pageNO-1)*size;
		return courseMapper.getCoursePager(skip, size);
	}

	/*
	 * @see com.offcn.service.CourseService#getCourseId(int)
	 */
	@Override
	public Course getCourseId(int id) {
		// TODO Auto-generated method stub
		return courseMapper.getCourseId(id);
	}

	@Override
	public int getCourseCount() {
		// TODO Auto-generated method stub
		return courseMapper.getCourseCount();
	}

	@Override
	public int insert(Course entity) {
		// TODO Auto-generated method stub
		return courseMapper.insert(entity);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return courseMapper.delete(id);
	}

	@Override
	public int update(Course entity) {
		// TODO Auto-generated method stub
		return courseMapper.update(entity);
	}

	@Override
	public void insertBatch(List<CtcKey> ctclist) {
		// TODO Auto-generated method stub
		ctcMapper.insertBatch(ctclist);
	}

}
