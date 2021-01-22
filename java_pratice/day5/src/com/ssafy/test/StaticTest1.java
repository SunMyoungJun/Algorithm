package com.ssafy.test;

public class StaticTest1 {

	public static void main(String[] args) {
		Data1 data1; //이 줄만 있고 밑에 없으면 컴파일러가 원래는 Data1내에 static 블럭이 실행되야하지만 
					 // 컴파일러가 얘밖에없으면 그냥 자체적으로 주석처리해버림..
		new Data1();    // 위에 주석이고 밑에 다 주석이고 이것만 실행해도됨. 그때 상태 한번보기.
//		data1 = new Data1();
//		data1 = new Data1(1);
//		data1 = new Data1();
		
		Data1.print();
		Data1.print();
		Data1.print();
		Data1.print();
	}

}


class Data1{
	int num1 = 10;
	static int num2 =20;
	
	static { //static 블럭 : 클래스가 메모리에 로딩되면 한번만 실행되는 블럭.
		System.out.println("클래스 로딩");
//		print();            //한번만 실행
		// int a;       //이지역에서만 사용되는 변수(지역변수) -> 스태틱 변수가되는거아님!!
	}
	
	static void print() {
		System.out.println("print");
	}
	
	{ //인스턴스 블럭 : 어떠한 인스턴스이든지 무조건 실행함.
	System.out.println("같은내용");
	}
	Data1() {
//		System.out.println("같은내용");
		System.out.println("생성자 1111 num1 : " + num1 + " , num2 : "+num2);
	}
	Data1(int num1) {
//		System.out.println("같은내용");
		this.num1 = num1;
		System.out.println("생성자 2222 num1 : " + num1 + " , num2 : "+num2);

	}
	
}