package com.bw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bw.pojo.Grade;

public interface GradeMapper {

	
	
	@Select("select * from grade")
	List<Grade> getGradeList();
}
