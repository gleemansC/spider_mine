package com.giraffe.mr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.print.attribute.standard.DocumentName;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider implements Runnable {
	private String url;
	private String urls;
	private int t = 0;
	//所有电影的信息存放到 静态infos，在App直接调用
	public static List<FilmInfo> infos = new ArrayList<>();
	
	public Spider(String url, String urls, int t) {
		this.url = url;
		this.urls = urls;
		this.t = t;
	}

	@Override
	public void run() {
		FilmInfo film = new FilmInfo();
		
		try {
			//正在上映的url
			Document doc = Jsoup.connect(urls).timeout(10000).get();
			Elements eles = doc.select("#nowplaying").select(".mod-bd").select(".lists").select("li[id]");
			
			//每个电影单独的url
			Document edoc = Jsoup.connect(url).timeout(10000).get();
			Elements ele = edoc.select("#wrapper").select("#content");
			
			
			int id = Integer.parseInt(eles.get(t).attr("id"));
			String title = eles.get(t).attr("data-title");
			String direct = eles.get(t).attr("data-director");
			String actors = eles.get(t).attr("data-actors");
			double score = Double.parseDouble(eles.get(t).attr("data-score"));
			
			String type = ele.select("span[property=v:genre]").text();
			String date = ele.select("span[property=v:initialReleaseDate]").text();
			String rate = ele.select("span[property=v:summary]").text();
			String img = ele.select("img").attr("src");
			
			film.setId(id);
			film.setTitle(title);			
			film.setDirect(direct);
			film.setActors(actors);
			film.setScore(score);
			
			film.setType(type);
			film.setDate(date);
			film.setRate(rate);
			film.setImg(img);

			System.out.println(film.getDirect());
			infos.add(film);
			new ImgLoader(film);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("yichang");
		}
	}

}
