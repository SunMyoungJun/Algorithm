package com.ssafy.hw8;

public class TV extends Product{
	private int inch;
	
	public TV(int num, String name, int price, int stock, String info,int inch) {
		super(num,name,price,stock,info);
		this.inch =inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
	public String toString() {
		String s = super.toString();
		return s+"\t |"+this.inch +"인치";
		
	}
}
