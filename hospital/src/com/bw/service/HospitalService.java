package com.bw.service;

import java.util.List;

import com.bw.pojo.Hospital;
import com.bw.pojo.Type;
import com.bw.util.PageUtil;

public interface HospitalService {

	int getCount();

	List<Hospital> getHospitalList(PageUtil pageUtil);

	List<Type> getTypeList();

	int add(Hospital hospital);

	int deleteAll(String[] ids);

}
