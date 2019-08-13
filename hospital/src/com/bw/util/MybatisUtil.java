package com.bw.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 功能描述：获取sqlSession,关闭sqlSession <br>
 * 作者： zz <br>
 * 时间：2019年7月5日  上午10:15:25
 */
public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 功能描述：获取sqlSession <br>
	 * 作者： zz <br>
	 * 时间：2019年7月5日  上午10:18:56
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	/**
	 * 功能描述：关闭SqlSession <br>
	 * 作者： zz <br>
	 * 时间：2019年7月5日  上午10:20:07
	 */
	public static void closeSqlSession(SqlSession sqlSession) {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
}
