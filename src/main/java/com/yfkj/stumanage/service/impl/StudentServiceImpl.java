package com.yfkj.stumanage.service.impl;

import com.yfkj.stumanage.mapper.ScMapper;
import com.yfkj.stumanage.mapper.StudentMapper;
import com.yfkj.stumanage.pojo.CourseExt;
import com.yfkj.stumanage.pojo.Sc;
import com.yfkj.stumanage.pojo.Student;
import com.yfkj.stumanage.pojo.StudentExt;
import com.yfkj.stumanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;
	@Autowired
	ScMapper scMapper;
	
	@Override
	public List<Student> getStudentPager(int pageNO, int size) {
		// TODO Auto-generated method stub
		int skip=(pageNO-1)*size;
		return studentMapper.getStudentPager(skip, size);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return studentMapper.getCount();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int multiDelete(int[] ids) {
		// TODO Auto-generated method stub
		int rows=0;
		for(int id:ids){
			rows+=deleteByPrimaryKey(id);
		}
		return rows;
	}

	@Override
	public int insert(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.insert(record);
	}

	@Override
	public Student selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<StudentExt> getStuByCid(int id) {
		// TODO Auto-generated method stub
		return studentMapper.getStuByCid(id);
	}

	@Override
	public Student stulogin(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.stulogin(student);
	}

	@Override
	public List<CourseExt> getXuxiu(int classid) {
		// TODO Auto-generated method stub
		return studentMapper.getXuxiu(classid);
	}

	@Override
	public int inserBatch(List<Sc> sclist) {
		// TODO Auto-generated method stub
		return scMapper.inserBatch(sclist);
	}

	@Override
	public List<CourseExt> getMycourses(int classid, int stuid) {
		// TODO Auto-generated method stub
		List<CourseExt> bxlist=studentMapper.getBxCourse(classid);
		List<CourseExt> xxlist=studentMapper.getxxCourse(stuid);
		List<CourseExt> ctlist=new ArrayList<CourseExt>();
		ctlist.addAll(bxlist);
		ctlist.addAll(xxlist);
		return ctlist;
	}
 
}