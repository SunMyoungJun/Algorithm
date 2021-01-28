package com.ssafy;

import java.io.IOException;

public class ExceptionTest2 {
	public static void main(String[] args) {
		// #0 Call Chain
				ControllerEx ec = new ControllerEx();
				ec.m();
	}
}

class ControllerEx {
	public void m() {
		ServiceEx se = new ServiceEx();
		try {
			se.m();   //밑에서 계속 올라오던 throw 예외가 여기서 try catch로 해결한것. 이러면 더이상 위로 부담 안감.	
		}
		catch(IOException e) {
			
		}
	}
}
class ServiceEx {
	public void m()throws IOException {
		DaoEx de = new DaoEx();
		de.m();
	}
}

//throws IOException 없을 때와 있을 때
class DaoEx{
	public void m() throws IOException {} //여기서 throws하면 그 부담이 호출된 ServiceEx의 de.m() 메소드로 감. 
}
