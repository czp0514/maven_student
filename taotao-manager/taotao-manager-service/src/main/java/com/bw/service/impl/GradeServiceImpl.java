package com.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.mapper.GradeMapper;
import com.bw.pojo.Grade;
import com.bw.service.GradeService;
@Service
public class GradeServiceImpl implements GradeService {
	@Autowired
	private GradeMapper gradeMapper;
	@Override
	public List<Grade> getGradeList() {
		return gradeMapper.getGradeList();
	}

}
