package com.bw.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bw.mapper.HospitalMapper;
import com.bw.pojo.Hospital;
import com.bw.pojo.Type;
import com.bw.service.HospitalService;
import com.bw.util.MybatisUtil;
import com.bw.util.PageUtil;

/**
 * 功能描述：业务层 <br>
 * 作者： zz <br>
 * 时间：2019年7月10日  下午3:12:28
 */
public class HospitalServiceImpl implements HospitalService {

	@Override
	public int getCount() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		HospitalMapper mapper = sqlSession.getMapper(HospitalMapper.class);
		int count = mapper.getCount();
		MybatisUtil.closeSqlSession(sqlSession);
		return count;
	}

	@Override
	public List<Hospital> getHospitalList(PageUtil pageUtil) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		HospitalMapper mapper = sqlSession.getMapper(HospitalMapper.class);
		List<Hospital> hlist = mapper.getHospitalList(pageUtil);
		MybatisUtil.closeSqlSession(sqlSession);
		return hlist;
	}

	@Override
	public List<Type> getTypeList() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		HospitalMapper mapper = sqlSession.getMapper(HospitalMapper.class);
		List<Type> tlist = mapper.getTypeList();
		MybatisUtil.closeSqlSession(sqlSession);
		return tlist;
	}

	@Override
	public int add(Hospital hospital) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		HospitalMapper mapper = sqlSession.getMapper(HospitalMapper.class);
		int row = mapper.add(hospital);
		if(row > 0) {
			sqlSession.commit();
		}
		MybatisUtil.closeSqlSession(sqlSession);
		return row;
	}

	@Override
	public int deleteAll(String[] ids) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		HospitalMapper mapper = sqlSession.getMapper(HospitalMapper.class);
		int row = mapper.deleteAll(ids);
		if(row > 0) {
			sqlSession.commit();
		}
		MybatisUtil.closeSqlSession(sqlSession);
		return row;
	}

}
