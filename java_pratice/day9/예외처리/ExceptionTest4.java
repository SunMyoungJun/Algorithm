package com.ssafy.day10;

import java.util.ArrayList;

class Student{
	String name;
	int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}
class AgeIndexOutOfBoundException extends Exception{ //CheckedException //Exception 상속 꼭받아야함.

	public AgeIndexOutOfBoundException(String message) {
		super(message);    //Exception 의 생성자로 들어감.

	}

}

// 메소드 재정의시 Exception은 부모보다 자식개념이 되어야한다. 
class MySuper{
	void pr() throws IndexOutOfBoundsException{
		
	}
	void aa() {}
}

class MySub extends MySuper{
	void pr() throws IndexOutOfBoundsException{ //메소드 앞private은안됨 부모보다 넓어야함. 따라서 protected나 public 가능
					//throws Exception은안됨 . 오버라이딩인데 부모꺼인 IndexOutOfBoundsException 보다 넓으면안대!!
	}
	void aa() {}
	
}
//class AgeIndexOutOfBoundException extends Exception{ //CheckedException //Exception 상속 꼭받아야함.
//	String title;
//
//	public AgeIndexOutOfBoundException(String title) {
//		this.title = title;
//	}
//	String getTitle() {
//		return title;
//	}
//}



public class ExceptionTest4 {
	ArrayList<Student> list = new ArrayList<>();
	public ExceptionTest4() {
		Student student = new Student("김싸피",33);
		try {
			addStudent(student);
		}catch(AgeIndexOutOfBoundException e) {
//			System.out.println("뭐가 문제있나1"+e.getTitle());
			System.out.println("뭐가 문제있나1"+e.getMessage());
		}
		student = new Student("이싸피",-33);
		try {
			addStudent(student);
		}catch(AgeIndexOutOfBoundException e) {
//			System.out.println("뭐가 문제있나2 : "+e.getTitle());
			System.out.println("뭐가 문제있나2 : "+e.getMessage());
		}

		
		for(Student s : list)
		{
			System.out.println(s);
		}
			
	}
	
	void addStudent(Student student) throws AgeIndexOutOfBoundException{
		if(student.age <1 || student.age >100) {
			
//			AgeIndexOutOfBoundException e = new AgeIndexOutOfBoundException("나이 오류");
//			throw e;        //위에 Exception(checkedException)이므로 트라이 캐치든 throws 를 하든 해야함.
//							//그러나 만약에 RunTimeException(Unchecked)라면 오류안뜸.
		
			throw new AgeIndexOutOfBoundException("나이 오류 : " +student.age); // 위에 주석 되잇는거합쳐서 한줄로. new 안뺴먹게 조심.
		
		}
		
		else {
		list.add(student);
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new ExceptionTest4();
	}

}
