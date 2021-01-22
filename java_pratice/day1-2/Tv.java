package com.ssafy.hw4;

public class Tv {
	
	 String num;   //제품 번호
	 String name; //제품 이름
	 int price;  //가격 정보
	 int stock; //재고수량
	 int inch;  //인치
	 String type; //타입정보
	
	
	public Tv() {
		
	}
	public Tv(String num,String name,int price,int stock,int inch,String type)
	{
		this.num = num;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.inch = inch;
		this.type = type;
	}
	public void setNum(String num)
	{
		this.num = num;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	public void setInch(int inch)
	{
		this.inch = inch;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String toString() 
	{
		String s = num +"     ||\t"+name+"     ||\t"+price+"     ||\t"+stock+"     ||\t"+inch+"     ||\t"+type;
		return s;
	}
	
	
	
	
	
}
