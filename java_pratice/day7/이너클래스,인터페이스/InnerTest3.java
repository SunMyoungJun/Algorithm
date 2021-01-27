package com.ssafy.day7;

//class Info{
//	void pr() {
//		System.out.println("원래 기능");
//	}
//}
interface Info{
	void pr();
}
public class InnerTest3 {
// 이름이 없는 Inner 클래스 예제
	
	Info aaaaa = new Info() {
		
		@Override
		public void pr() {
			System.out.println("dfdfdf");
			
		}
	};
//	Info aaa = new Info(){
//		public void pr() {
//			System.out.println("pr");
//		}
//	};
//	Info aaa = new SubInfo1();
//	class SubInfo1 implements Info{
//		public void pr() {
//			System.out.println("pr");
//		}
//	}
//	Info aaa2 = new SubInfo();
//	Info aaa3 = new SubInfo();
//	Info aaa4 = new SubInfo();
//	Info aaa = new Info(){
//		@Override
//		void pr() {
//			System.out.println("내가 변경한 기능 구현");
//		}
//	};
//	Info aaa = new Info(){
//		@Override
//		void pr() {
//			System.out.println("내가 변경한 기능 구현");
//		}
//	};
//	Info aaa = new SubInfo();
//	class SubInfo extends Info{
//		@Override
//		void pr() {
//			System.out.println("내가 변경한 기능 구현");
//		}
//	}
	public InnerTest3() {
//		Info aaa = new Info();
		// 이름이 없는 로컬 Inner 클래스 예제
		myAction(new Info(){
			@Override
			public void pr() {
				System.out.println("내가 변경한 기능 구현");
			}
		});
		myAction(new Info(){
			@Override
			public void pr() {
				System.out.println("내가 새롭게 변경한 기능 구현");
			}
		});
//		myAction(aaa);
//		myAction(aaa);
//		myAction(aaa);
		
		myAction(new Info() {
			
			@Override
			public void pr() {
				System.out.println("하고 싶은 일");
				
			}
		});
		
//		Info fff = new Info();
	}
//	바뀌지 않음
	void myAction(Info info) {
		info.pr();
	}
//	Thread trd = new Thread(){
//		@Override
//		public void run() {
//			System.out.println("aa");
//		}
//	};
//	Thread trd = new MyThread();
//	class MyThread extends Thread{
//		@Override
//		public void run() {
//			System.out.println("aa");
//		}
//	}
	void aaaa() {
		new Thread(){
			@Override
			public void run() {
				System.out.println("aa");
			}
		}.start();
	}

	public static void main(String[] args) {
		new InnerTest3();

	}

}
