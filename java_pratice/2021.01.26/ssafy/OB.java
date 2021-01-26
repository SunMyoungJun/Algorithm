package com.ssafy;

public class OB extends OA{
	@Override      //이거 안붙히면 OA 클래스에서 m1이 삭제되거나 어떤 매개변수 변경등이 생기면  밑에 m1은 오버라이딩이아니라 그냥 OB의
					// 메서드가 되버림 . 따라서 @Override 붙혀서 상위 클래스의 메서드가 이상이 생기면 여기서 오류가 뜸.
	void m1() { System.out.println("OB m1()");}
	
	
	void m2() { System.out.println("OB m2()");}

}
