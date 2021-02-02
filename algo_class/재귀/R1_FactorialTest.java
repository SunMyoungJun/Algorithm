package com.ssafy.recursive;

public class R1_FactorialTest {

	//반복문
	private static int factorial(int n) {
		int result =1;
		for(int i=n; i>0;i--)
		{
			result *=i;    //단위반복
		}
		return result;
	}
	
	//재귀(리턴값을 활용안함.)
	private static int res=1;
	private static void factorial2(int n) {
		
		if(n==0)
			return;
		
		res*=n;				//
		factorial2(n-1);	//
		
		
	}
	
//	재귀(리턴값 활용)
	private static int factorial3(int n) {
		if(n ==1)
			return 1;
		
		return n * factorial3(n-1);
		
	}
	
	
	
	
	public static void main(String[] args) {
		int n=5;
		System.out.println(factorial(n));
		factorial2(n);
		System.out.println(res);
		System.out.println(factorial3(n));
	
	}

}
