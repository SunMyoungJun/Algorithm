package com.ssafy;
//////////////////////////////// java.lang.package 자동 임포트
public class StringTest {

	public static void main(String[] args) {
		
		int i1 = 10;
		int i2 = 10;
		
		String s1 = "Hello";
		String s2 = "Hello"; //위에 같은 Hello가 있으면 그쪽의 주소값을 가지게 됨.
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		
		if( i1 == i2 ) { System.out.println("i1 i2 Same"); }
		if( s1 == s2 ) { System.out.println("s1 s2 Same"); } //이거 출력되는이유가 s1과 s2의 주소가 같은지 비교함
		if( s3 == s4 ) { System.out.println("s3 s4 Same"); }
		if(s1.equals(s3)) { System.out.println("s3 s4 Same2"); };
	}

}
