package com.ssafy.io;

import java.util.Scanner;

public class IO3_ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("기수 : "+sc.nextInt());
		System.out.println("이름 : "+sc.next()); //(1)이거 앞에 아무리 많은 구분자들이 있어도 다 버리고 입력값을 받고 \n나오면 그전까지만 받음.
//		sc.nextLine();		// (3)얘는 버리는 값. 위에서 이름을 받고 엔터칠때 그 \ㅜ을 버리기 위해 사용..
		System.out.println("이름 : "+sc.nextLine());// (2)그러나 얘는 앞에 구분자들이있으면 읽어버림 . 따라서 위에서 이름을 next()로 받아서 치면 구분자를 남김 .
													//따라서 여기서 구분자가 처음으로 나오므로 구분자까지 읽고 구분자를 버리므로 공백이 답이 나오고 종료되버림..
	}												//따라서 (3)을 통해 \n을 버림..

}
