
public class ThreadTest2 {

	class MyJob extends Thread {
		public void run() {
//			작업 , 병행 , 오랜시간 작업
//			aa();
			
//			병행의 반복작업	
			int num =0;
			while(true){
//			작업1 반복작업
				aa(); //CPU 점유
				yield();     //sleep보단 이거 권장  -> 양보
				try {
					Thread.sleep(0,1);  // 밀리초  , 나노초
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(num >=110) {
					break;
				}
			}
		}
		void aa() {
//			오랜작업
		}
	}
	ThreadTest2() {
		MyJob t = new MyJob();
		t.start();
		System.out.println("t와 상관없이 할일");
		
//		합을 구하는 쓰레드
//		1반 합, 2반 합, 3반 합    // 합쓰레드 : 인자로 반 점수
//		합을 구하는 쓰레드.join();
//		평균을 구하는 쓰레드 (합을 구하고 평균을 구해야하므로 join을 사용)
		
	}
	public static void main(String[] args) {
		new ThreadTest2();
	}

}
