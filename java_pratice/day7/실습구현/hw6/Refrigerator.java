package com.ssafy.hw6;

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

	public void setSize(int productSize) {
		this.productSize = productSize;
	}
	public String toString() {
		String s = super.toString();
		return s+"\t |"+this.productSize+"사이즈"+" \t |"+this.color;
		
	}
}
