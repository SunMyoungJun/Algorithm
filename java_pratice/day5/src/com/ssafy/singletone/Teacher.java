package com.ssafy.singletone;



//싱글톤 디자인 패턴을 적용해보자

public class Teacher { //인스턴스는 되어야함. 즉 밑에 두개를 static으로 하지는않음.
		// 3단계 : 멤버 변수의 자신의 객체를 접근하는 변수를 생성한다.

		private static Teacher teacher =null;				//밑에처럼 바로 생성해도되는데 null주는 이유는 생성했다가 학생이 없어지면서 teacher만 남으면 java가 안쓴다고 판단하고 지워버림.. 다시 생성이안돼..
	//	private static Teacher teacher = new Teacher();      //밑에 static 메소드 getInstance 에서 return teacher 해줘야하는데 이 때 teacher가 static 이어야 리턴가능.
	String name;
	String location;
//		1단계   -  외부 생성을 막는다.

	private Teacher() {
		
	}
//	2단계 : 외부에서 현재 객체를 얻어갈 수 있는 static 메소드 만든다.
	public static Teacher getInstance() {   //static 들어가는 이유 : 위에 Teacher가 생성안되도 접근해서 Teacher얻어갈수있어야함.
		//4단계 : 객체 생성 여부를 판단해서 만들어져 있지 않으면 생성한다.
		if(teacher == null) {
			teacher = new Teacher();
		}
		
		return teacher;
	}

}
