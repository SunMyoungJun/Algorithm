

// 사용 이유 : 함께 실행, 대용량작업(함께 실행) => 대기시간 축소(비동기 작업)
public class ThreadTest {
	class MyJob extends Thread{  //white Box 쓰레드 내부를 내맘대로 고칠 수 있도록 되어 있음.
		void aa() {
			yield();  //Thread는 OS의 것.
		}
		
		@Override
		public void run() {  //하고싶은일 쓰기.
			
		}
	}
	class MyJob1 implements Runnable{  //black Box 쓰레드 내부를 고칠 수 없다.    //런어블 구현은 별도의 클래스를 상속받을 수 있음.
		
		public void run( ) { //병행에 대한 작업만 정의할 수 있다. 내부에 직접 접근 불가능.
			
		}
		void aa() {
//			yield();   //이렇게 맘대로 못씀.
//			Thread.yield(); 이렇게 쓸수 있음.
		}
	}
	public ThreadTest() {
		Thread t = new MyJob();
		t.run();  //일반메소드 호출(Thread 동작 아님)
		t.start();
		System.out.println("aaa");
		
//		Thread t1 = new MyJob1(); //얘는 이렇게 못씀.
		Runnable t1 = new MyJob1();
		
		Thread t2 = new Thread(t1);
		t2.start();
//		t2.stop();  // Deprecated : 사용 안하는거 추천.
	}
	public static void main(String[] args) {
		

	}

}
