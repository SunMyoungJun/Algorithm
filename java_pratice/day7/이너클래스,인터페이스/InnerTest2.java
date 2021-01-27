package com.ssafy.day7;

public class InnerTest2 {
// local Inner 클래스 (Inner, nested 클래스)
	
	void ppp() {
		aa();
	}
	void aa() {
//		자바소스는 선언과 호출에 라인우선순위 무시
//		단, Inner 클래스는 선언하고 생성해서 사용해야 함.
		
//		ATest11 a = new ATest11();
		class ATest11{
			void pr() {};
		}
		ATest11 a = new ATest11();
		a.pr();
	}
	public InnerTest2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new InnerTest2();

	}

}
