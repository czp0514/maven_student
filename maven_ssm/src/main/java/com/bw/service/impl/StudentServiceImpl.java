package com.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.mapper.StudentMapper;
import com.bw.pojo.Student;
import com.bw.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public List<Student> findStudent() {
		List<Student> findStudent = studentMapper.findStudent();
		return findStudent;
	}

	@Override
	public List<Student> findByPage(int index) {
		// TODO Auto-generated method stub
		return studentMapper.findByPage(index);
	}

	@Override
	public int pageCount() {
		// TODO Auto-generated method stub
		return studentMapper.pageCount();
	}
	 
}
