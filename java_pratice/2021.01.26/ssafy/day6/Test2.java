package com.ssafy.day6;

public class Test2 {

	class TA{

		void a(int i) {
			System.out.println("매개변수 1개");
		}
	}
	
	class TB extends TA{
		void b() {
			System.out.println("TB b 매개변수 없음.");
		}
	}
	
	class TC extends TB {
		void a() {      //오버로딩 개념 적용, 오버로딩은 아님... TC에 추가된 일반 메소드로 보자.
			System.out.println("TC a 매개변수 없음.");
		}
		void b(int i) { //오버로딩 개념과 같지만 오버로딩 아니고 TC에 추가된 일반 메소드.
			System.out.println("TC b 매개변수 1개");
		}
	}
	class TD extends TC {
		void a(int i) { //재정의 메소드 (오버라이딩)
			System.out.println("TD a 매개변수 1개");
		}
		void b() {    //재정의 메소드 TB것  재정의(오버라이딩)
			System.out.println("TD b 매개변수 없음 재정의");
		}
	}
	
	class TE extends TD {
		void a() {  //TC클래스의 메소드 재정의
			System.out.println("TE a 매개변수 없음 재정의");
		}
		void b() {   //얘는 TD가 아니라 TB클래스의 b메소드를 재정의한것.
			System.out.println("TE b 매개변수업음 재정의");
		}
	}
	
	
	
	public Test2() {

		TA ta = new TC();
		//ta.a(i);    //ta가 a(int i)라는 메서드가 없음!! TC까지 접근가능한건 ta에 있는 메소드중에서 재정의한 메소드만 밑으로 찾아감.
		TC tc = new TE();
//		tc.b(1);       //TC에 b(int i)라는 메서드가 있음! 따라서 TC부터 TE까지 내려가면서 재정의된거잇는지 찾고 잇으면 그거씀.
		TB tb = new TD();
		tb.a(2);       //TB에는 a(int i)가 메서드가 없음! 따라서 부모를 타고가면서 있는지 확인
					   //없으면 오류.			   
					   //있으면 다시 TD까지 보면서 재정의 된거잇는지봄.
					   
	
	}

	public static void main(String[] args) {
		new Test2();
	}

}
