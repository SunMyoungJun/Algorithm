package com.ssafy.hw6;

public class Product {
	private int num;
	private String name;
	private int price;
	private int stock;
	private String info;
	
	public Product() {
		
	}
	
	public Product(int num, String name, int price, int stock, String info) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.info = info;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	public String toString() {
		String s = num+" \t | "+name+" \t | "+price+" \t | "+stock+" \t | "+info;
		return s;
	}
}
