package com.ssafy.test;

public class StaticTest22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aa(); //aa함수 앞에static이없다면 오류! main이 static이기떄문
		InnerClass ic = new InnerClass();
	
	}
	static void aa() {   
		
	}
	static class InnerClass{         //알고리즘할 때 inner로 많이 씀.
		
	}
}
