package com.sist.model;

public class ReplyVO {
	//COM_NO, REPLY_NO, REPLY_WRITE, REPLY_NAME, REPLY_CONT, REPLY_DATE
	private int article_no;	
	private int com_no;
	private int reply_no;
	private String reply_write ;
	private String reply_name;
	private String reply_cont;
	private String reply_date;
	
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public int getCom_no() {
		return com_no;
	}
	public void setCom_no(int com_no) {
		this.com_no = com_no;
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_write() {
		return reply_write;
	}
	public void setReply_write(String reply_write) {
		this.reply_write = reply_write;
	}
	public String getReply_name() {
		return reply_name;
	}
	public void setReply_name(String reply_name) {
		this.reply_name = reply_name;
	}
	public String getReply_cont() {
		return reply_cont;
	}
	public void setReply_cont(String reply_cont) {
		this.reply_cont = reply_cont;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	
}
