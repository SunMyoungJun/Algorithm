package com.ssafy.test;

public class StaticMethodTest {
	int a =10;
	public static void main(String[] args) {
//		satic을 메소드 앞에 쓰기
//		class내 메소드는 각각 인스턴스화 한다고 각각 생성 되는거아님 클래스 영역 내 하나의 메소드를 같이 공유해서 사용함. 	
		
//		a =50; 메인메소드가 static 메소드이므로 staticMethodTest 내의 인스턴스 변수인 a에는 접근할 수 없다!!
		
		
		
		SSData.aa();    //생성과 무관하게 SSdata 내 aa가 static으로 되어있으므로 인스턴스화가 아니라 클래스영역에
		SSData.aa();     //  올라오면서 클래스이름으로 바로 접근해서 사용가능.
		
		
		SSData sdata1 = new SSData();
		SSData sdata2= new SSData();
		SSData sdata3 = new SSData();
		sdata1.bb(); //인스턴스화 된 다음에 쓸수있음.(new한 다음에)
		
		
	
		
		
	}

}

// 정리 : static 메소드에서는 static 변수와 static 메소드만 접근할 수 있따. 
//   Instance 메소드는  instance 메소드와 static 메소드 다 접근이 가능하다.

class SSData {
	int num;    //인스턴스화(new) 되야 사용가능.
	static int su;  //클래스 로딩 후 바로 사용 가능.
	static void aa() { //static 메소드   -> 클래스 메소드라고 많이 부름.
		su =1;  //이건 오류안나.
//		num=9;   //이건 오류남. aa 클래스 메소드가 인스턴스화 없이 클래스영역에 올라가는데 num은 인스턴스화 되야 사용가능하므로.
	}
	void bb() {         // Instance Method 
		su =1;  //이건 오류안나.
//		num=9;   //이것도 오류안나. bb는 인스턴스 메소드 이므로 인스턴스화 후 bb가 사용될것이므로 num도 사용가능.
	}
	
}