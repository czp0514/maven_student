package com.bw.service;

import java.util.List;

import com.bw.pojo.Student;

public interface StudentService {
	public List<Student> findStudent();
	/**查询当前页数*/
	public List<Student> findByPage(int index); 
	/**查询总条数*/
	public int pageCount();
}
