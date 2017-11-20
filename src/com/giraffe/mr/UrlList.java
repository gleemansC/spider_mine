package com.giraffe.mr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UrlList {
	private static List<String> urlList = new ArrayList<>();
	
	public static List<String> getUrl(String url) {
		try {
			Document doc = Jsoup.connect(url).timeout(10000).get();
			Elements ele = doc.select("#nowplaying").select(".mod-bd").select(".lists").select(".poster").select("a");
			for (Element e : ele) {
				String eurl = e.attr("href");
				urlList.add(eurl);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlList;
	}
}
