package com.ssafy.ws04.step5;

import java.util.ArrayList;

class SBook {
	String name;
	int price;
	public SBook(String name, int price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "SBook [name=" + name + ", price=" + price + "]";
	}
	
}


public class ArrayListTest {

	public ArrayListTest() {
		ArrayList<SBook> list = new ArrayList<>();
//		C,R,U,D
//		추가
		list.add(new SBook("A",1000));
		list.add(new SBook("B",1000));
		list.add(new SBook("C",1000));
		list.add(new SBook("D",1000));
	
//		접근
		System.out.println(list.get(0));
		
//		전체 갯수
		System.out.println(list.size());
		
//		마지막 항목
		System.out.println(list.get(list.size()-1));
		
		System.out.println("----------------------------------");
		
//		전체 출력
		for(SBook sbook : list)
			System.out.println(sbook);

		
		System.out.println("----------------------------------");

//		삭제
		list.remove(2);
		System.out.println("----------------------------------");

//		수정1
		list.set(2, new SBook("수정 타이틀",7000)); //set은 새로만들어서 그자리에 덮어 씌움
		for(SBook sbook : list)
			System.out.println(sbook);
		System.out.println("----------------------------------");

//	 	수정2
		list.get(2).price = 3000;
		for(SBook sbook : list)
			System.out.println(sbook);
		System.out.println("----------------------------------");

	}

	public static void main(String[] args) {
		new ArrayListTest();
		
		
	}

}
