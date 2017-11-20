package com.giraffe.mr.sqldata;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

import com.giraffe.mr.FilmInfo;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

public class InsertData {
		
	SqlSessionFactory factory;
	InsertMapper insertMapper;
	private List<FilmInfo> infos;
	SqlSession sqlSession;
	
	public InsertData() {
		// TODO Auto-generated constructor stub
	}
	
	public InsertData(List<FilmInfo> info) {
		this.infos = info;
		factory = getFactory();
		sqlSession = factory.openSession();
		insertMapper = sqlSession.getMapper(InsertMapper.class);
		insertData();
	}

	private SqlSessionFactory getFactory() {
		try {
			InputStream in = Resources.getResourceAsStream("config.xml");
			return new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	void insertData() {
//		System.out.println(insertMapper.findAll());
		int t = 0;
		for (FilmInfo f : infos) {

			insertMapper.insertAlldata(f);

		}
		sqlSession.commit();
	}
}
