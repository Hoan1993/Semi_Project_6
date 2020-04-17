package com.sist.model;

public class CommentVO {
	// ARTICLE_NO, COM_NO, COM_WRITER, COM_NAME, COM_TITLE, COM_CONT, COM_HIT, COM_UP, COM_DOWN, COM_DATE
		private int article_no;
		private int com_no;
		private String com_writer;
		private String com_name;
		private String com_cont;
		private int com_hit;
		private int com_up;
		private int com_down;
		private String com_date;
		
		
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
		public String getCom_writer() {
			return com_writer;
		}
		public void setCom_writer(String com_writer) {
			this.com_writer = com_writer;
		}
		public String getCom_name() {
			return com_name;
		}
		public void setCom_name(String com_name) {
			this.com_name = com_name;
		}
		public String getCom_cont() {
			return com_cont;
		}
		public void setCom_cont(String com_cont) {
			this.com_cont = com_cont;
		}
		public int getCom_hit() {
			return com_hit;
		}
		public void setCom_hit(int com_hit) {
			this.com_hit = com_hit;
		}
		public int getCom_up() {
			return com_up;
		}
		public void setCom_up(int com_up) {
			this.com_up = com_up;
		}
		public int getCom_down() {
			return com_down;
		}
		public void setCom_down(int com_down) {
			this.com_down = com_down;
		}
		public String getCom_date() {
			return com_date;
		}
		public void setCom_date(String com_date) {
			this.com_date = com_date;
		}
}
