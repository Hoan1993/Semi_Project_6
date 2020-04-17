package com.sist.model;

public class MemberVO {

	private String mem_email;
	private String mem_pwd;
	private String mem_name;
	private int mem_phone;
	private int mem_state;
	private String mem_vote;
	
	
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public int getMem_state() {
		return mem_state;
	}
	public void setMem_state(int mem_state) {
		this.mem_state = mem_state;
	}
	public String getMem_vote() {
		return mem_vote;
	}
	public void setMem_vote(String mem_vote) {
		this.mem_vote = mem_vote;
	}
	
	public int getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(int mem_phone) {
		this.mem_phone = mem_phone;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mem_email=" + mem_email + ", mem_pwd=" + mem_pwd + ", mem_name=" + mem_name + ", mem_phone="
				+ mem_phone + ", mem_state=" + mem_state + ", mem_vote=" + mem_vote + "]";
	}

	
}
