package com.ssafy;

public class passByValueTest {

	public static void main(String[] args) {
		int i = 10;
		setVal(i);
		System.out.println(i); // 10
		
		Pass p = new Pass();
		p.val = 10;
		setVal(p); 
		System.out.println(p.val);  //5
	}
	
	public static void setVal(int x) { x = 5; } //call by value
	
	public static void setVal(Pass p) { p.val = 5; } //call by reference 
}

class Pass{
	public int val = 3;
}
