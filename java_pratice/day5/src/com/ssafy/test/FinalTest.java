package com.ssafy.test;

public class FinalTest {

	public static void main(String[] args) {
		//		final 키워드
		//		1.클래스 앞에 선언 2. 메소드 앞에 선언 ->상속에 관련됨
		//		3.변수 앞에 선언
	
		int max =10; //일반 변수
		max =30;
		max =50;
		
//		int jumsumax = 100;   //총점은 100점
//		jumsumax = 50 ; //이렇게 마음대로 바꾸면 안됨.
//		따라서 밑에 처럼 선언.
//		final int jumsuMax =100;     //이렇게 쓰면 일반변수랑 구분안되서 모두 대문자를 권장.
//		final int JUMSU_MAX =100;     //두개 이상의 단어로 구성된 이름은 중간에 _사용.
//		final int MAX; // 지역변수는 이렇게 써도 오류안남.
//		MAX =99;        // final로 위에 쓰고 밑에 이렇게 써도됨. 단 한번 넣고 나면 다시 다른값넣으려고 하면 오류.
//		final int MAX; 이거만 있고 밑에 sysout 해주면 오류남. 
	
		
//		final Sam sam = new Sam();
//		sam.name = "ssafy";
//		sam.name = "algo";        ///이렇게 밑에꺼 써도 오류안남 .sam이라는 객체에 새로운 생성이 안될뿐 밑에처럼		
//		sam = new Sam();           //이렇게 위에 final로 객체선언하면 새로 못 함. 단 그안의 이름같은건 상관x
		
		
	}

}



class Data{
//	int MAX;   //멤버 변수는 자동 초기화 값이 들어가므로 0이 들어가있음.
//	final int MAX =99; 멤버변수 일때 : 그러나 final로 주면 default value는 아니라고 생각하고 반드시 값을 줘야함. 아니면
//			컴파일에러
}

class Sam{
	String name;
}



