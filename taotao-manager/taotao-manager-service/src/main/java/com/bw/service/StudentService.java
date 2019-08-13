package com.bw.service;

import java.util.List;

import com.bw.pojo.PageUtil;
import com.bw.pojo.Student;

public interface StudentService {

	int getCount(Student student);

	List<Student> getStudentList(Student student, PageUtil pageUtil);

	boolean addStudent(Student student);

	Student getStudentById(Integer sid);

}
