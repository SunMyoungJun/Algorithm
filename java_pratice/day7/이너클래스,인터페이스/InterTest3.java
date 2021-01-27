package com.ssafy.day7;


interface MouseListener{
	void click();
	void dbClick();
	void pressed();
	void released();
	void mouseOver();
	void mouseOut();
}
abstract class MouseAdapter implements MouseListener{
	public void click() {}
	public void dbClick() {}
	public void pressed() {}
	public void released() {}
	public void mouseOver() {}
	public void mouseOut() {}
}

class MyMouseAction extends MouseAdapter{// 특별한 클래스를 상속하지 않고 있어
//	click 에 대해서 동작 구현
	@Override
	public void click() {
		System.out.println("나의 액션 작업");
	}

	

}
//class MyMouseAction implements MouseListener{// 특별한 클래스를 상속하지 않고 있어
////	click 에 대해서 동작 구현
//	@Override
//	public void click() {
//		System.out.println("나의 클릭 업무 구현");
//		
//	}
//
//	@Override
//	public void dbClick() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void pressed() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void released() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseOver() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseOut() {
//		// TODO Auto-generated method stub
//		
//	}   
//
//}
public class InterTest3 {

	public InterTest3() {
//		 TODO Auto-generated constructor stub
		int[] arr = new int[5];
		System.out.println(arr instanceof int[]);
		System.out.println(arr instanceof Object);
	}

	public static void main(String[] args) {
		new InterTest3();

	}

}
