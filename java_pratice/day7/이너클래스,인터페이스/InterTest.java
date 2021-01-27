package com.ssafy.day7;


interface Sam1{   //특별한 클래스
//	interface 안에 있는 모든 변수와 메소드의 접근 제한자는 public만 허용한다.
	public static final int MAX = 100;
	int MIN = 0;
	public  abstract void f1();
	void f2();      //실제 사용하려면 반드시 구현(상속)해야만 사용한다.
}
interface Sam99{
	void f99();
}

// 인터페이스의 상속
interface inter1{
	void aa();
}
interface inter2{
	void bb();
}
interface inter3{
	void cc();
}
interface SubInter extends inter1, inter2, inter3{
	void dd();
}
class Work implements SubInter{
	public void cc() {}
	public void bb() {}
	public void aa() {}
	public void dd() {}
	
}
//class Work implements inter1, inter2, inter3{
//	public void cc() {}
//	public void bb() {}
//	public void aa() {}
//	
//}
class Parent{  //생성도 되고, 독자적인 일반적인 변수와 기능구현된 메소드를 가짐
	void f3() {
		System.out.println("dfdf");
	}
}
class SubSam1 extends Parent implements Sam1, Sam99 {
	public void f3() { //parent 크래스의 메소드 재정의  ,   추가된 이름이 단지 같은 메소드

	}
	public void f1() {  //재정의 
		System.out.println("bbb");
//		System.out.println(MAX);
	}
	public void f2() {
		System.out.println("aaaaa");
	}
	@Override
	public void f99() {
		System.out.println("f99");
		
	}

}
class SubSam2 extends Parent implements Sam1{
	public void f1() {
		System.out.println("22222");
	}
	public void f2() {
		System.out.println("22222222");
		//		MAX = 99;
	}
}
public class InterTest {

	public InterTest() {
		Sam1 subSam1 = new SubSam1();
		subSam1.f1();
		subSam1.f2();
//		subSam1.f3();
//		subSam1.f99();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
