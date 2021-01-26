package com.ssafy.day6;

public class OverloadingTest {
//	void sum(int a, int b) {}
//	int sum(int a, long b) {return 1;}
//	public void sum(int a, int b, int c) {}
	
	
//  return a + b + c;
//}
//int fourSum(int a, int b ,int c, int d) {
//  return a + b + c + d;
//}
//int fiveSum(int a, int b, int c, int d, int e) {
//  return a + b + c + d + e;
//}
	
	
	
	int sum(int... arr) {
		//배열로 인식
		int tot =0;
		for(int i=0;i<arr.length;i++) {
			tot += arr[i];
		}
		return tot;
	}
	
	
	
	public OverloadingTest() {
		
		int res =sum(2,3);
		res = sum(2,3,4,55,66,88,45);
		res = sum(2,4,6,7);
		res = sum(2);
		
		
//		오버로딩의 규칙
//		1.메소드의 이름이 같다.
//		2. within a class에서(같은 클래스 안에서)
//		3.반드시 매개변수의 갯수나 타입이 틀려야 한다.
//		4. 반환타입은 상관없다.
//		5. 접근제한자는 상관없다.

		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new OverloadingTest();
	}

}
