package com.ssafy;

public class Phone {
	private String name = "Galaxy Note";
	private char color;
	private int price;
	
	
	public int getSalePrice() {
		if(this.color =='A')
			return price;
		else
			return price+1000;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRealDebt() {
		return price + 200;
	}
	public Phone(String name) {
		this.name = name;
		System.out.println("A");
		System.out.println(this.name);
	}
	public Phone() { //기본생성자 . 위의 생성자 정의하고 밑에 기본생성자도 정의해서 총 2개의 생성자 있어도 됨.
		System.out.println("B");
		System.out.println(this.name);
	}
}
