package sjava;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		
		//swtich case문을 이용해서 그 달의 마지막 날을 출력하라
		//단, 2월은 무조건 28일이다.
		//단, 1~12가 아닌것들은 모름으로 출력
		
//		int month = 5;
//		switch(month)
//		{
//			case 1: case 3: case 5:
//			case 7: case 8: case 10:
//			case 12:
//				System.out.println("31");
//				break;
//			case 2:
//				System.out.println("28");
//				break;
//			
//			default:
//				System.out.println("30");
//		}
			/////////////////////////////
		// 두 수를 입력받아 그 합을 출력하라
		
		Scanner sc = new Scanner(System.in);
		//메서드는 특정 클래스 객체에 종속됐다 ->자바는 전부 이럼
		//int num1 = sc.nextInt();
		//int num2 = sc.nextInt();
		
		//int res = num1 +num2;
		//System.out.println(res);
		
//		String s1 = sc.next();
//		String s2 = sc.next();
//		System.out.println(s1 +" , "+s2);
		
		
//		키보드를 통해서 C,R,U,D 라는 문자열을 입력받아 분기 작업하라
//		C : 입력, R : 읽기, U : 수정, D : 삭제
		String command = sc.next();
		String result ="";
		switch(command) {
		case "C":
			result ="입력";
			break;
		case "R":
			result ="읽기";
			break;
		case "U":
			result ="수정";
			break;
		case "D":
			result ="삭제";
			break;
		}
		System.out.println(result);
	}

}
