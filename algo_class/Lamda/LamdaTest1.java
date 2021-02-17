package day10;



//람다 가능한 interface -> """""""""""""1개의 추상 메소드만 가지고 있는 인터페이스"""""""""""""""""""""

//@FunctionalInterface ->컴파일러에게 1개의 추상 메소드만 가지는지 여부를 전달 ->2개이상 가지면 Sub1 빨간줄뜸.
interface Sub1 {
//	void aa();
	void call(String msg);
//	default void cc() {
//	}
}
interface Sub2 {

	int call(String msg);		

}

public class LamdaTest1 {
//
//	MySub1 sub = new MySub1();           //이거랑 밑에 클래스 합친게 밑에 2222222222222 부분
//	class MySub1 implements Sub1 {
//
//		@Override
//		public void call(String s) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
	public static void main(String[] args) {
		
		//반환되는 type이 있는경우 +명령문이 하나인경우 return을 삭제하여야한다.
		Sub2 subb2 = msg ->  msg.equals("A") ? 1: 10;

		
//		Sub2 subb2 = (String msg) -> {
//			return msg.equals("A") ? 1: 10;
//		};	
		
//		Sub2 subb2 = new Sub2() {
//			
//			@Override
//			public int call(String msg) {
//				return 0;
//			}
//		};
		
		
		int res = subb2.call("A");
		System.out.println(res);
		
		
		
		
		
		
		
		
		
		
//		실행되는 명령문이 1개인 경우 {}을 생략할 수 있다.(꼭해야하는거아님)
		
		Sub1 sub1 = msg ->System.out.println("저장" + msg); ////5555 3차 축약된 람다식.(2)
		Sub1 sub2 = msg ->System.out.println("설정" + msg); ////5555 3차 축약된 람다식.(2)
		Sub1 sub3 = msg ->System.out.println("종료" + msg); ////5555 3차 축약된 람다식.(2)
		
		
		sub1.call(" 프로젝트");
		sub2.call(" 프로젝트");
		sub3.call(" 프로젝트");
		
		
//		만약에 매개변수가 1개면 괄호를 생략할 수 있다.(꼭해야하는거아님)
//		0개 이거나 두개 이상이면 생략하면 안된다.
//		Sub1 sub1 = msg -> {    ////5555 3차 축약된 람다식.
//			System.out.println("a");
//			System.out.println("hello" + msg);
//		};
//		
		
		
//		매개변수의 타입을 생략이 가능하다.
//		Sub1 sub1 =(msg) -> {    ////444444 2차 축약된 람다식.
//			System.out.println("a");
//			System.out.println("hello" + msg);
//		};
		
		
		
		
//		Sub1 sub1 =(String msg) -> { ///////////3333333 1차축약된 람다식.
//				System.out.println("a");
//				System.out.println("hello" + msg);
//			};
//		
	
	
	
//		Sub1 sub2 = new Sub1() {   //////////////222222222222222222 이걸 람다식으로 고친게 33333333
//			@Override       
//			public void call(String msg) {
//				System.out.println("b");
//				System.out.println("goodboye" + msg);
//				
//			}
//		};
//	
//		sub1.call("ssafy");
//		sub1.call("java");
		
//		sub2.call("ssafy");
//		sub2.call("java");
		
	}

}
