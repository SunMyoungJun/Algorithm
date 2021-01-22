package com.ssafy.test;

public class StaticTest2 {

	public static void main(String[] args) {
		DataSam ds1 = new DataSam();
		DataSam ds2 = new DataSam();
		DataSam ds3 = new DataSam();
		ds1.a =10;
		ds2.a =20;
		ds3.a =30;
		System.out.println(ds1.a);
//		ds3이 ds1의 a를 변화시키는 방법은 없다.(인스턴스 변수)
		
		ds1.b = 100;
		ds2.b = 200;
		ds3.b = 300;
		System.out.println(ds1.b);
//		ds3과 ds1의 b는 공유되므로 ds3가 ds1의 b를 변화시킬수 있다.(클래스 변수(스태틱 변수)) (side effect(우리나라말:부작용))
		//객체지향은 서로의 객체가 영향을 미치는 것을 최소화하는게 베스트.
//		 그러므로 인스턴스 변수로 싹 하는게 좋은거같지만 알고리즘에는 메모리 최적화라는게있음.
//		알고리즘에서 instance 변수인 int a를 100만개 선언하면 400만 바이트가 사용되버림.
//		따라서 알고리즘으로 잘 짜서 static int a로 쓰면 4바이트로 사용가능..
		
	}

}

class DataSam{
	int a;
	static int b;
}