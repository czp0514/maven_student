package com.bw.mapper;

import java.util.List;

import com.bw.pojo.Student;

public interface StudentMapper {
	public List<Student> findStudent();
	
	/**查询当前页数*/
	public List<Student> findByPage(int index); 
	/**查询总条数*/
	public int pageCount();

}
