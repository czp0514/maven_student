package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.pojo.StuCou;
import com.bw.pojo.Student;

public interface StudentMapper {

	int getCount(Student student);

	List<Student> getStudentList(Map<String, Object> map);

	List<Student> getStudentList2(Map<String, Object> map);

	int addStudent(Student student);

	int addStuCou(List<StuCou> stuCouList);

	Student getstudentById();

}
