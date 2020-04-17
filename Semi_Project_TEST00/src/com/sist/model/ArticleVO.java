package com.sist.model;

public class ArticleVO {
	
	private int article_no;
	private String article_writer;
	private String article_name;
	private String article_media;
	private String article_gen1;
	private String article_gen2;
	private String article_title;
	private String article_cont;
	private String article_file1;
	private String article_file2;
	private String article_file3;
	private String article_file4;
	private int article_hit;
	private String article_date;
	
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public String getArticle_writer() {
		return article_writer;
	}
	public void setArticle_writer(String article_writer) {
		this.article_writer = article_writer;
	}
	public String getArticle_name() {
		return article_name;
	}
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	public String getArticle_gen1() {
		return article_gen1;
	}
	public void setArticle_gen1(String article_gen1) {
		this.article_gen1 = article_gen1;
	}
	public String getArticle_gen2() {
		return article_gen2;
	}
	public void setArticle_gen2(String article_gen2) {
		this.article_gen2 = article_gen2;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_cont() {
		return article_cont;
	}
	public void setArticle_cont(String article_cont) {
		this.article_cont = article_cont;
	}
	public String getArticle_file1() {
		return article_file1;
	}
	public void setArticle_file1(String article_file1) {
		this.article_file1 = article_file1;
	}
	public String getArticle_file2() {
		return article_file2;
	}
	public void setArticle_file2(String article_file2) {
		this.article_file2 = article_file2;
	}
	public String getArticle_file3() {
		return article_file3;
	}
	public void setArticle_file3(String article_file3) {
		this.article_file3 = article_file3;
	}
	public String getArticle_file4() {
		return article_file4;
	}
	public void setArticle_file4(String article_file4) {
		this.article_file4 = article_file4;
	}
	public int getArticle_hit() {
		return article_hit;
	}
	public void setArticle_hit(int article_hit) {
		this.article_hit = article_hit;
	}
	public String getArticle_date() {
		return article_date;
	}
	public void setArticle_date(String article_date) {
		this.article_date = article_date;
	}
	public String getArticle_media() {
		return article_media;
	}
	public void setArticle_media(String article_media) {
		this.article_media = article_media;
	}
	
	
	@Override
	public String toString() {
		return "ArticleVO [article_no=" + article_no + ", article_writer=" + article_writer + ", article_name="
				+ article_name + ", article_media=" + article_media + ", article_gen1=" + article_gen1
				+ ", article_gen2=" + article_gen2 + ", article_title=" + article_title + ", article_cont="
				+ article_cont + ", article_file1=" + article_file1 + ", article_file2=" + article_file2
				+ ", article_file3=" + article_file3 + ", article_file4=" + article_file4 + ", article_hit="
				+ article_hit + ", article_date=" + article_date + "]";
	}
	
	
	
}
