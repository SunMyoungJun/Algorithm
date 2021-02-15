package com.ssafy.exhasutive;

public class P2_BitOperatorTest {

	public static void main(String[] args) {
		
		int k = 0Xa5;   // 16진수  a는 10을 나타냄 a:1010 5:0101 -> 합쳐서 1010 0101
		
		//k 비트열의 상태중 오른쪽에서 1만큼 떨어진 비트 확인
		System.out.println(k & 1<<1);
		System.out.println(k & 1<<2);
		System.out.println(Integer.toBinaryString(k & 1<<2));

		
		//k비트열의 오른쪽에서 1만큼 떨어진 자리 1비트로 만들기
		System.out.println(k | 1<<1);  //1010 0101과 0000 0010이 OR 연산되면서 1010 0111이 됨.
		System.out.println(Integer.toBinaryString(k|1<<1));
		
	}

}
