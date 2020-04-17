package com.sist.model;

public class FavoriteVO {
	private int fav_no;
	private int article_no;
	private String mem_email;
	private String article_title;
	private String fav_date;
	
	public int getFav_no() {
		return fav_no;
	}
	public void setFav_no(int fav_no) {
		this.fav_no = fav_no;
	}
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getFav_date() {
		return fav_date;
	}
	public void setFav_date(String fav_date) {
		this.fav_date = fav_date;
	}
}
