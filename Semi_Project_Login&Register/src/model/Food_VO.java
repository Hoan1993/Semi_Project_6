package model;

import javax.swing.ImageIcon;

public class Food_VO {
	private int bno;
	private ImageIcon icon;
	private ImageIcon icon2;
	private String store_name;
	private String food_name;
	private int price;
	private String review;
	private String address;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public ImageIcon getIcon2() {
		return icon2;
	}
	public void setIcon2(ImageIcon icon2) {
		this.icon2 = icon2;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Food_VO [bno=" + bno + ", icon=" + icon + ", icon2=" + icon2 + ", store_name=" + store_name
				+ ", food_name=" + food_name + ", price=" + price + ", review=" + review + ", address=" + address + "]";
	}
	
	
	
	
	
}
