package com.giraffe.mr;

public class FilmInfo {
	//电影ID号OK
	private int id;
	//电影名OK
	private String title;
	//导演OK
	private String direct;
	//主演OK
	private String actors;
	//类型
	private String type;
	//上映时间
	private String date;
	//评分OK
	private String grade;
	//剧情
	private String rate;
	//图片地址
	private String img;
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirect() {
		return direct;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "FilmInfo [title=" + title + ", direct=" + direct + ", actors=" + actors + ", type=" + type + ", date="
				+ date + ", grade=" + grade + ", rate=" + rate + ", img=" + img + "]";
	}
	
}
