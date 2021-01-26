package com.ssafy.day6;

//우리업무에서 삼각형, 사각형, 원을 관리하자 ==>도형(실제 없는 => 추상화)
abstract class Shape{ //도형은 딱1개임 도형이 여러개다? 말이안됨. 사람을 만들순없다 의사,변호사는 만들수잇어도 
						//그럴 때 abstract 쓰면 밑에서 생성할때 Shape shape = new Shape()를 막음!!
	int x,y;
	
	//메소드 추상화 / 추상 메소드 앞엔 abstract가 와야한
		abstract void print();  //자식이 재정의만 하면되서 이렇게 만듬.
}
class Rect extends Shape{  //사각형
	//하나의 정점과 , width, height로 관리
//	int x, y;
	int width, height;
	void print() {
		System.out.println("사각형 출력");
	}
	
}   
class Tri extends Shape{  //삼각형
	//3정점으로 관리
//	int x,y;
	int x1, y1;
	int x2, y2;
	void print() {
		System.out.println("삼각형 출력");
	}
}  
class Circle extends Shape{ //원
	//하나의 정점과 반지름으로 관리 
//	int x,y;
	int round; //반지름
	void print() {
		System.out.println("원 출력");
	}
} 



public class AbstractTest {

	public AbstractTest() {
		Rect rect = new Rect();
		rect.width =300;
		Tri tri = new Tri();
		Circle circle = new Circle();
		circle.round = 100;
//		각각의 도형을  전달해서 확인하는 메소드를 만들어라.(상속의 필요성)
		print(rect);
		print(tri);
		print(circle);
		//부모 변수 = new 자식
		
//		Shape shape = new Shape(); 이건 오류!
//		Shape shape =null;   //이렇게는 씀.
		
		
		
	}
	
	void print(Shape shape) {
		shape.print();
		
//		원이 들어오면 반지름을 출력해보자.
//		shape.round ->는 못씀. 왜냐면 부모인 shape에는 round변수가 없기때문.
		
//		클래스 형변환
//		사각형의 넓이를 찍어라.
//		Rect rect = (Rect)shape; //상속관계가 있으면 자식으로 형변환 가능.
//		System.out.println(rect.width);
//		
		if(shape instanceof Rect) {    //instanceof안오면 Tri형이 들어올때 Rect으로 캐스팅해버리면서 오류!
			Rect rect = (Rect)shape; //상속관계가 있으면 자식으로 형변환 가능.
			System.out.println(rect.width);
		}else if(shape instanceof Circle) {
			Circle circle = (Circle)shape;
			System.out.println("반지름 : " + circle.round);
		}else if(shape instanceof Tri) {
			Tri tri = (Tri)shape;
		}
		
		
	}
	
//	void print(Rect rect) {  이렇게 쓰지말고 추상화를 통해 한방에!
//		System.out.println("사각형 확인");
//	}
//	void print(Tri Tri) {
//		System.out.println("삼각형 확인");
//	}
//	void print(Circle circle) {
//		System.out.println("원 확인");
//	}
//	

	public static void main(String[] args) {
		new AbstractTest();
	}

}
