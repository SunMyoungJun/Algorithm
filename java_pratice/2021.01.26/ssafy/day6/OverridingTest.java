package com.ssafy.day6;

class Parent{
	int age;
	 void f(int a) {}

}
class Child extends Parent{
	int age;
	 void f(int a) {}        //만약 Parent의 f가 public 이면 자식도 반드시 그거랑 같거나 넓어야함. 만약 protected같은거 쓰면 오류남. 
	 						// 오버라이딩한거임 이건.
	 
	 void f(int a, int b) {}  //얘는 오버로딩 같지만 아님. 같은 클래스아니기 때문.(부모 자식관계기때문)


}

public class OverridingTest {

//	오버라이딩 규칙
//	1.메소드 이름이 같다.(변수 아님!!) , 자바는 변수나, 연산자의 다형성을 지원하지 않는다.
//	2. 서로 다른 클래스의 있는 메소드(서로 다른 클래스는 반드시 상속관계에 있다.)
//	3. 매개변수의 갯수와 타입이 같아야 한다.(반환 되는 타입이 같다.)
//	4. 접근제한자는 부모보다 같거나 넓어야 한다. (private < default < protected< public)
	
	
	
	
	
	
	public static void main(String[] args) {
		new OverridingTest();
		

	}

}
