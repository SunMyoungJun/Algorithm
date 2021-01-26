package com.ssafy;

public class OverridingABCDE {
	public static void main(String[] args) {    //밑에 주석한개씩 풀면서 파악하자.
		//AA x = new CC(); x.a();               
		//CC x = new EE(); x.b(3);
		//DD x = new BB(); x.b();
		//BB x = new DD(); x.a(3);
	}
}

class AA{
	void a(int i) { System.out.println("AA:a(int i)"); }
}

class BB extends AA{
	void b() { System.out.println("BB:b()"); }
}

class CC extends BB{
	void a() { System.out.println("CC:a()"); }
	void b(int i) { System.out.println("CC:b(int i)"); }
}

class DD extends CC{
	void a(int i) { System.out.println("DD:a(int i)"); }
	void b() { System.out.println("DD:b()");}
}

class EE extends DD{
	void a() { System.out.println("EE:a()"); }
	void b() { System.out.println("EE:b()"); }
}

