package com.ssafy;

import java.io.FileInputStream;
import java.util.Scanner;

public class ExceptionTest999 {

	public ExceptionTest999() {
		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
		String sNum = sc.next();
//		Integer.parseInt("123");
		int num = Integer.parseInt(sNum); //얘는  string으로 "ssafy"라고 들어오면 NumberFormatException 발생할수잇는데
										  //빨간줄 아닌 이유는 런타임 Exception 계열이기  떄문..
		//컴파일은 되는데 정상적인 입력 하면 아무 이상없는데 정상적인 숫자 스트링이 입력되지 않으면 그떄 오류뜸
		
		
		System.out.println(num + 99);
		
//		CheckedException 계열은 처리하지 않으면 컴파일 오류 발생 -> 빨간줄!
//		FileInputStream is = new FileInputStream("a.txt");  //이거는 오류임. 왜냐면 런타임Exception밑의 예외가 아님!!
	}

	public static void main(String[] args) {
		new ExceptionTest999();
	}

}
