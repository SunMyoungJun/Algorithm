package com.ssafy.day7;

// 게임 프로그램

interface GameInfo{
	int GAME_MAX = 999;
	void attack();
	default void print() {
		System.out.println("최대점수");
	}
	static void pr() {
		System.out.println("static pr");
	}
}
class A implements GameInfo{
	//	공격
	public void attack() {
		System.out.println("A 개발자의 공격");
	}
	public void print() {
		System.out.println("A의 최대점수");
	}
}
class SuperB{
	
}
class B extends SuperB implements GameInfo{
	//	공격
	@Override
	public void attack() {
		fire();		
	}
	void fire() {
		System.out.println("B 개발자의 공격");
	}
	
	void aa() {
		fire();
	}
	void bb() {
		fire();
	}


}
class C implements GameInfo{
	void push() {
		System.out.println("C 개발자의 공격");
	}

	@Override
	public void attack() {
		push();
	}
}
public class InterTest2 {

	public InterTest2() {
		
//		GameInfo.print();
//		GameInfo.pr();
		GameInfo a = new A();
		a.print();
		GameInfo b = new B();
		b.print();
		GameInfo c = new C();
		attack(a);
		attack(b);
		attack(c);
	}
	void attack(GameInfo player) {
		player.attack();
	}


	public static void main(String[] args) {
		new InterTest2();

	}

}
