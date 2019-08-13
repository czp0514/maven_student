package com.bw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bw.pojo.Course;

public interface CourseMapper {
	@Select("select * from course")
	List<Course> getCourseList();

}
