package com.ssafy.io;

import java.util.Scanner;

public class IO1_ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 , 실수 , 문자열을 차례로 입력하세요.");
		System.out.println("읽은 정수 : " + sc.nextInt());
		System.out.println("읽은 실수 : " + sc.nextDouble());
//		System.out.println("읽은 문자열 : " + sc.next());	//얘는 앞에 공백 아무리 많이 넣어도 빼고 출력됨
		System.out.println("읽은 문자열 : " + sc.nextLine());  // 얘는 앞에 공백 많이 주면 많이 준만큼 출력됨.
		
		
	}

}
