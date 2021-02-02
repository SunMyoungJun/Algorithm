package com.ssafy.io;

import java.util.Scanner;

public class IO2_ScannerTest {

	public static void main(String[] args) {
//		String s1 = "안  \n녕\n";//구분자(space, \n 등)은 next에서 다 버림.
//		Scanner sc = new Scanner(s1);
//		System.out.print("읽은 문자열 : " + sc.next());//여기서 구분자 나오기 직전까지 읽음. (안)
//		System.out.print(",읽은 문자열 : " + sc.next());//시작할떄 구분자면 전에 입력값이 남겨놧다고 가정하고 다 버림 . 스페이스를 버리고 다음꺼 읽었더니 \n이네?
//													//\n도 버리고 (녕) 읽고 다음꺼봣더니 \n 구분자라서 \n전까지만 읽음.
//		System.out.print("\n======================================");
//		String s2 = "안 녕\n";
//		Scanner sc2 = new Scanner(s2);
//		System.out.print("읽은 문자열 :"+sc2.nextLine()); //nextLine은 안 녕\n에서 구분자가 나오는 \n까지 읽은다음 우리한테 줄때는 \n 빼고 넘겨줌.
//		System.out.print("\n======================================");//그래서 여기 \n까지 합쳐서 2줄이 띄어져야할꺼같지만 위에서 빼고 넘겨받아서 한번만 개행됨.

		String s3 = "안 \n           녕\n";
		Scanner sc3 = new Scanner(s3);
		System.out.print("읽은 문자열:"+sc3.nextLine());
		System.out.print(",읽은 문자열:"+sc3.nextLine());
		
	}

}
