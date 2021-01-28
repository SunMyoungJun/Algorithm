package com.ssafy;

public class ExceptionTest3 {
public static void main(String[] args) {
		
		ControllerRunEx ec = new ControllerRunEx();
		//ec.m1();

//		try {
//			ec.m1();
//		}catch(NullPointerException e) {
//			;;
//		}
	}

}

class ControllerRunEx{
	public void m1() throws NullPointerException {
		String s = null;
		s.length();		
	}
}