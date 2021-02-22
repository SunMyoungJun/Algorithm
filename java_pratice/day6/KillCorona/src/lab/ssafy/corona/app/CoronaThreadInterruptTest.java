package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.CoronaThread;

public class CoronaThreadInterruptTest {

	public static void main(String[] args) {
		CoronaThread t = new CoronaThread(2020);
		t.start();
		t.interrupt();   //얘가 없으면 메인 쓰레드는 3초 자고 corona thread는 5초 자서 메인이 먼저 끝나고 corona thread 가 끝남.
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Thread End!!");
	}

}
