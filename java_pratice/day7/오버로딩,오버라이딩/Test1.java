package com.ssafy.day6;

public class Test1 {

	class SA{
		void pr() {
			System.out.println("SA pr");
		}
	}
	class SB extends SA{
		
	}
	class SC extends SB{
		void pr() { //얘가 반환형 int면 바로 오류남. 부모 클래스에 void라서
			System.out.println("SC pr");
		}
	}
	class SD extends SC {
		
	}
	
	public Test1() {
		SA sa = new SC(); //SC 생성되기전에 부모 꺼가 먼저 호출됨 .따라서 SA , SB ,SC순으로 호출. 
		sa.pr();		// SA의 pr을 보고 SB,SC 를 보면서 pr이 오버라이딩 된거 있으면 그거 호출하는데 제일 밑에잇는 pr호출함.
		
		SA sa2 = new SB();//SB 전에 부모인 SA 생성 후 SB 생성 .
		sa2.pr();         // 따라서 SA의 pr메소드 먼저 보고 SB에 pr이 오버라이딩 되있으면 그거호출. 아니면 SA꺼 호출.
	
	}
	
	
	public static void main(String[] args) {
		

	}

}
