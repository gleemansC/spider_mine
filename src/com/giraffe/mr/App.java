package com.giraffe.mr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.giraffe.mr.sqldata.InsertData;

/**
 * 
 * @author Mr.Giraffe 获取豆瓣网站上正在上映的电影的全部信息
 */
public class App {
	public static void main(String[] args) {
		String url = "https://movie.douban.com/cinema/nowplaying/changsha/";

		// 获取每个电影单独的网址
		List<String> urlList = UrlList.getUrl(url);

		ExecutorService pool = Executors.newFixedThreadPool(10);
//		System.out.println(urlList.size());
		for (String eurl : urlList) {
			// info有问题
			pool.execute(new Spider(eurl));
		}
		pool.shutdown();

//		while (true) {
//			if (pool.isTerminated()) {
//				 InsertData data = new InsertData(Spider.infos);
//
//				break;
//			} else {
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
