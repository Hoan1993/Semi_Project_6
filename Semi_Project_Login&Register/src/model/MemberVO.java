package model;

public class MemberVO {
	private String name;
	private String userid;
	private String userpwd;
	private String address;
	private String email;
	private Integer pwdq;
	private String pwda;
	private Integer budget;
	private Integer balance;
	
	
	
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
	public Integer getPwdq() {
		return pwdq;
	}
	public void setPwdq(Integer pwdq) {
		this.pwdq = pwdq;
	}
	public String getPwda() {
		return pwda;
	}
	public void setPwda(String pwda) {
		this.pwda = pwda;
	}
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", userid=" + userid + ", userpwd=" + userpwd + ", address=" + address
				+ ", email=" + email + ", pwdq=" + pwdq + ", pwda=" + pwda + ", budget=" + budget + ", balance="
				+ balance + "]";
	}
	
	
	
	
}
