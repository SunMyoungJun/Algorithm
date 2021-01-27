package com.ssafy.day7;


class Other{
//	다른 클래스
}

//클래스의 이름은 사용가능 문자, 영문자대소문자, 숫자 , _, $(사용가능하나 선언하지 않는것이추천)

class Sam$Test{
	
}
public class InnerTest {
	int a = 10;
	static int num = 0;
	class MemberInnerClass{
		void pr() {
			System.out.println("MemberInnerClass");
		}
	}
	static class StaticMemberInnerClass{
		void pr1() {
			System.out.println("StaticMemberInnerClass");
		}
	}
	public InnerTest() {
		a = 88;
		
		MemberInnerClass aaa = new MemberInnerClass();
	}

	public static void main(String[] args) {
//		a = 10;
//		new InnerTest();
		InnerTest itt = new InnerTest();
		itt.a = 99;
		MemberInnerClass it = itt.new MemberInnerClass();
		it.pr();
		
		num = 999;
		
		StaticMemberInnerClass sss = new StaticMemberInnerClass();
		sss.pr1();
	}

}
