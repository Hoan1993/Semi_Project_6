package com.sist.model;

public class QNAVO {
	
	private int num;
	private String email;
	private String title;
	private String content;
	private int readcount;
	private String writedate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	
	
	@Override
	public String toString() {
		return "QNAVO [num=" + num + ", email=" + email + ", title=" + title + ", content=" + content + ", readcount="
				+ readcount + ", writedate=" + writedate + "]";
	}

	
	
	
	
}
