package com.giraffe.mr.sqldata;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.giraffe.mr.FilmInfo;

public class Storage {
	private static StorageMapper storageMapper;
	private static SqlSession session;
	
	private static StorageMapper getFactory() {
		try {
			InputStream in = Resources.getResourceAsStream("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
			session = factory.openSession();
			return session.getMapper(StorageMapper.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void insertData(List<FilmInfo> info) {
		storageMapper = Storage.getFactory();
		for (FilmInfo f : info) {
			storageMapper.insertAlldata(f);
		}
		session.commit();
	}
}
