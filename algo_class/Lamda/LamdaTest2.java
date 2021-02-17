package day10;

public class LamdaTest2 {

//	Thread클래스 Runnable 인터페이스 Thread
	
//	MyRunnable runnable = new MyRunnable();
//	class MyRunnable implements Runnable {
//
//		@Override
//		public void run() {
//			System.out.println("runn!");
//		}
//	}
	
	void toDO() {
//		뭔가 무지막지한 일하기
//		100라인 짜리
	}
	
	public LamdaTest2() {
//		Runnable runnable = new Runnable() {   1. 어노미어스이너클래스
//			@Override
//			public void run() {
//				System.out.println("runn!");
//			}
//		};
		
//		Runnable runnable = () -> {     2.람다식 축약
//				System.out.println("runn!");
//		};
		
//		Runnable runnable = () -> System.out.println("runn!");  //람다식 축약+ 중괄호 삭제
//		Thread t = new Thread(runnable);   //여기 괄호안에 바로 넣어버리면 밑 밑줄처럼 들어감.
//		t.start();
		
//		Thread t = new Thread(() -> System.out.println("runn!"));
//		Thread t = new Thread(() -> toDO());
//		t.start();

		Thread t = new Thread(() -> toDO());
//		t.start();  // t에 바로 윗줄 대입.
		new Thread(() -> toDO()).start();
		
	}

	public static void main(String[] args) {
		new LamdaTest2();

	}

}
