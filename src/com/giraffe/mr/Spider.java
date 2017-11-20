package com.giraffe.mr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider implements Runnable {
	private String url;
	//所有电影的信息存放到 静态infos，在App直接调用
	public static List<FilmInfo> infos = new ArrayList<>();
	
	//可能会有问题
	
	public Spider(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		FilmInfo film = new FilmInfo();
		
		try {
			Document Sdoc = Jsoup.connect(url).timeout(30000).get();
			Elements e = Sdoc.select("#wrapper").select("#content");
			String title = e.select("span[property=v:itemreviewed]").text();
			String direct = e.select("a[rel=v:directedBy]").text();
			String actors = e.select(".attrs").select("a[rel=v:starring]").text();
			String type = e.select("span[property=v:genre]").text();
			String date = e.select("span[property=v:initialReleaseDate]").text();
			String grade = e.select("strong[class=ll rating_num]").text();
			String rate = e.select("span[property=v:summary]").text();
			String img = e.select("img").attr("src");

			film.setTitle(title);
			
			film.setDirect(direct);
			film.setActors(actors);
			film.setType(type);
			film.setDate(date);
			film.setGrade(grade);
			film.setRate(rate);
			film.setImg(img);
			
			infos.add(film);
			new ImgLoader(film);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
