package com.ssafy.array;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		String name = "ssafy";
		f3(name);
		System.out.println("main name : " + name); 
		//String도 참조형이라서 바껴야하겟지만 String만 예외로 불변의 법칙 적용
		//배열은 참조형이라서 함수호출 후 인자로 들어가서 값이 바뀌면 해당 배열도 바뀜.
	}
	
	static void f3(String name)
	{
		name ="java";
		System.out.println("f3 : " + name);
	}

}
