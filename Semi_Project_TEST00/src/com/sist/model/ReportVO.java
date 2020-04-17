package com.sist.model;

public class ReportVO {
	private int report_no;
	private String report_type;
	private String report_title;
	private String report_writer;
	private String report_helper;
	private String report_date;
	private String report_status;
	private String report_content;
	
	public int getReport_no() {
		return report_no;
	}
	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}
	public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	public String getReport_title() {
		return report_title;
	}
	public void setReport_title(String report_title) {
		this.report_title = report_title;
	}
	public String getReport_writer() {
		return report_writer;
	}
	public void setReport_writer(String report_writer) {
		this.report_writer = report_writer;
	}
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public String getReport_status() {
		return report_status;
	}
	public void setReport_status(String report_status) {
		this.report_status = report_status;
	}
	public String getReport_content() {
		return report_content;
	}
	public void setReport_content(String report_content) {
		this.report_content = report_content;
	}
	public String getReport_helper() {
		return report_helper;
	}
	public void setReport_helper(String report_helper) {
		this.report_helper = report_helper;
	}
	
}
