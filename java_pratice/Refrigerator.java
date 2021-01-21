package com.ssafy.hw4;

public class Refrigerator {

	 String num;   //제품 번호
	 String name; //제품 이름
	 int price;  //가격 정보
	 int stock; //재고수량
	 int size; //용량

	 public Refrigerator() {

	 }
	 public Refrigerator(String num,String name,int price,int stock,int size)
	 {
		 this.num = num;
		 this.name = name;
		 this.price = price;
		 this.stock = stock;
		 this.size =size;
	 }

	public void setNum(String num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString() 
	{
		String ss = this.num +"     ||\t"+this.name+"     ||\t"+this.price+"     ||\t"+this.stock+"     ||\t"+this.size;
		return ss;
	}
	 
}
