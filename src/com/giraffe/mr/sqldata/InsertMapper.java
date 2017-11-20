package com.giraffe.mr.sqldata;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.giraffe.mr.FilmInfo;
import com.giraffe.mr.Spider;

public interface InsertMapper {
		
		@Insert("insert into spider(title,direct,actors,type,date,grade,rate,img) "
				+"values (#{title},#{direct},#{actors},#{type},#{date},#{grade},#{rate},#{img})")
		void insertAlldata(FilmInfo f);
		
//		@Insert("insert into spider(title,direct,actors,type,date,grade,rate,img) "
//				+ "values (#{title},#{direct},#{actors},#{type},#{date},#{grade},#{rate},#{img})")
//		void insertAlldata(FilmInfo info);
		
//		@Insert("insert into spider(title, direct) values(#{title}, #{direct})")
//		void test(FilmInfo f);
}
