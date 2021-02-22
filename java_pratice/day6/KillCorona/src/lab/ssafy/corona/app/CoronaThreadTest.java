package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.CoronaRunnable;
import lab.ssafy.corona.virus.CoronaThread;

public class CoronaThreadTest {

	public static void main(String[] args) {

		//		for( int t=0; t<1000; t++ ) {
		//
		//			CoronaRunnable cr = new CoronaRunnable(t);
		//			Thread thread = new Thread(cr);
		//			thread.start();
		//		}
		//		
		//		for( int t=0; t<1000; t++ ) {
		//			CoronaThread thread = new CoronaThread(t);
		//			thread.start();
		//		}
		//		
		/////////////////////////////////////
		//		System.out.println("before Thread.sleep()");
		//		try {
		//			Thread.sleep(3000);  //3초 동안 멈춤.
		//		} catch (InterruptedException e) { // 나는 sleep하는데 다른 녀석이 날 꺠울때 발생.( 3초만큼 sleep하지못하고 꺠어날떄)
		//			e.printStackTrace();
		//		}
		//		System.out.println("after Thread.sleep()");
		////////////////////////////////////////////


		//		for( int t=0; t<1000; t++ ) {
		//			
		//			CoronaThread thread = new CoronaThread(t);
		//			thread.start();
		//			
		//		}
///////////////////////////////////////////////////////////

		System.out.println("Main Thread Start!!");

		CoronaThread thread = new CoronaThread(2020);
		thread.start();

		try {
			thread.join();   //이 라인을 호출한 메인 쓰레드가 corona thread에 올라타서 corona thread가 끝날동안 멈춰있음.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
									//이 try catch 없으면 start end 2020 출력 
									// 있으면 start 2020 end 출력
		System.out.println("Main Thread End!!");

/////////////////////////////////////////////////////////////
	}
}