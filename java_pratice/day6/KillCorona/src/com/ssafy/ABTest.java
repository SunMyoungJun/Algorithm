package com.ssafy;

public class ABTest {

	public static void main(String[] args) {
		
		B b = new B(); //B생성자 안 super를 통해 A의 생성자로 가고 A의 생성자 안 super를 통해 object의 생성자로감.
		//따라서 object -> A ->B 순으로 생성됨. 	
		
		B b1 = new B(1);
	
	
	}
}

class A{ // extends Object가 생략되어있음.
	A() {
		super();    //사실 생략되어있던 부분.
		System.out.println("A");
	}
	A(int a) {
		super();
		System.out.println("부모매개변수1개");
	}
}

class B extends A {
	B() {
		super();    //얘는 생략해도됨. 기본생성자 호출이기때문
		System.out.println("B");
	}
	B(int a) {
		super(a);  //얘는 생략되버리면 기본생성자 super()가 되버림.... 생략x
	}
}