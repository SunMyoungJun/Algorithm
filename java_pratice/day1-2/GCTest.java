package com.ssafy.classsam;

public class GCTest {

	public static void main(String[] args) {
		Sam1 s1;
		s1 = new Sam1();
		Sam1 s2 = new Sam1();
		s2 = null;
		System.gc(); // 이제 gc해라고 했으니 VM(JVM)이 알고 있다가 유효시간에 동작하도록 함. 이 명령문 없어도 알아서 일정조건이나 시간 되면  동작함.
		s1 =null;
		System.gc();
	
		System.out.println("end");
	/////////////////////////////////////
		String s = "s";
		s = s+ "a" + 3 + true + 3.4 + new String("ss"); 
		//스트링에는 + 연산은 원래 없음. 따라서 내부적으로  new StringBuilder(s).append("a").toString() ----이렇게 각각 가져와서 붙힘. 
		//하나 붙히고 s로 반환해주고 거기에 다시 new StringBuilder(s).append("3").toString() --- 계속 한개씩 더하면서 반복.
		// 이렇게 되면 s 할당된 공간 따로 sa따로 sa3따로   따로따로 메모리 차지함.
	
		//따라서 밑에 처럼 써야함 11111111111111111111
		StringBuilder sb = new StringBuilder();
		sb = sb.append(s).append(3).append(true).append(3.4); //메소드체인기법.//이렇게 써도 되고 한줄씩 append 하나씩 해도됨 
		//그렇게 하면 계속 StringBuilder로 계속 생성안하고 마지막에 생성됨.
	//그러고 toString()사용하면 끝.
		
	//	그러나 s = s+ "a" + 3 + true + 3.4 + new String("ss"); 이렇게 반복문아니고 넣는거면 컴파일러가 알아서 1111111 처럼함 
		//그러나 반복문안에서 s =s+ 로 붙혀나가면 11111처럼 처리안해줌.
		
		s = sb.toString();
		
	
	
	
	}

}

class Sam1 {
	int a;
	void f() {
		
	}
}
