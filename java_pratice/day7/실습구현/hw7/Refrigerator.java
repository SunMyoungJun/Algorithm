package com.ssafy.hw7;

public class Refrigerator extends Product {
	private int productSize;
	private String color;
	public Refrigerator(int num, String name, int price, int stock, String info,int productSize,String color) {
		super(num,name,price,stock,info);
		this.productSize = productSize;
		this.color = color;
	}

	public int getSize() {
		return productSize;
	}

	public int getProductSize() {
		return productSize;
	}

	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSize(int productSize) {
		this.productSize = productSize;
	}
	public String toString() {
		String s = super.toString();
		return s+"\t |"+this.productSize+"L"+" \t |"+this.color;
		
	}
}
