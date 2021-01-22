package com.ssafy.hw4;

public class ProductTest {

	public static void main(String[] args) {
		
		Tv tv = new Tv();
		
		tv.setNum("삼성1등 KDM-1345");
		tv.setName("눈피로 없는 최고급 TV");
		tv.setPrice(1000000);
		tv.setStock(203);
		tv.setInch(45);
		tv.setType("LCD");
		String tvinfo = tv.toString();
		System.out.println(tvinfo);
		
		Tv tv2 = new Tv("삼성2등 KDM-0234","눈피로 조금 있는 (최고급-1) TV",900000,155,43,"LCD");
		String tvinfo2 = tv2.toString();
		System.out.println(tvinfo2.toString());
		
		
		Refrigerator rf1 = new Refrigerator();
		rf1.setNum("삼성1등KDW-1765");
		rf1.setName("엄청 시원한 냉장고");
		rf1.setPrice(2000000);
		rf1.setStock(120);
		rf1.setSize(40000);
		
		String ss = rf1.toString();
		System.out.println(rf1);
		
		Refrigerator rf2 = new Refrigerator("삼성2등KDW-1777","많이 시원한 냉장고",1500000,400,35400);
		String ss2 = rf2.toString();
		System.out.println(ss2.toString());
	}

}
