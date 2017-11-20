package com.giraffe.mr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImgLoader {

	private String img;

	public ImgLoader(FilmInfo film) {
		this.img = film.getImg();
		run();
	}
	
//	@Override
	private void run() 
	{
		File path = new File("pic");
		if (!path.exists())
			path.mkdir();
		// 建立一个HTTP链接，使用输入流获得数据，使用输出流存放到磁盘
		HttpURLConnection conn = null;
		InputStream in = null;
		FileOutputStream out = null;

		try {
			// 建立链接
			conn = (HttpURLConnection) new URL(img).openConnection();
			in = conn.getInputStream();
			
			// io获得图片的名字
			int index = img.lastIndexOf("/");
			String file = img.substring(index + 1);
			// 输出流写入
			out = new FileOutputStream(path + "/" + file);
			byte[] buf = new byte[1024 * 16];
			int size;

			while (-1 != (size = in.read(buf))) {
				out.write(buf, 0, size);
			}
			
//			System.out.println(Thread.currentThread().getName() + "下载完成" + img);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
