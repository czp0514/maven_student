package com.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.mapper.CourseMapper;
import com.bw.pojo.Course;
import com.bw.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	
	@Override
	public List<Course> getCourseList() {
		return courseMapper.getCourseList();
	}

}
