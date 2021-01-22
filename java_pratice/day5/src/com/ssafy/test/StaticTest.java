package com.ssafy.test;

public class StaticTest {

	public static void main(String[] args) {
//		static(정적)       다이나믹(동적)
//		1.클래스(Inner , Nested(이너랑 같은말)) 앞에 선언  ex) 여기선 StaticTest클래스 앞에는 못씀. 
//		2.메소드 앞에 선언  3.멤버 변수앞에 선언
		
		SData s1 = new SData();
		SData s2 = new SData();
		SData s3 = new SData();
		s1.a++;
		s1.b++;
		s2.a++;
		s2.b++;
		s3.a++;
		s3.b++;
	
		System.out.println("s1 a : " + s1.a+ ", b : " + s1.b);
		System.out.println("s2 a : " + s2.a+ ", b : " + s2.b);
		System.out.println("s3 a : " + s2.a+ ", b : " + s3 .b);
		
	}

	
	static class S{  //이렇게 특정 클래스 안에 있는 클래스이므로 Inner임 이런건 static 앞에 붙힐수잇음.
		
	}
	
}


class SData{
	static int a;
	int b;
}





