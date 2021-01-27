package com.ssafy.day6;

public class InherTest {
	int a;
	 public InherTest(){
	        Student d1 = new Student();
//	        Student d2 = new Student();
	        Student d2 = getStudent(56789);
	        
	        d1.num = 56789;
//	        d2.num = 56789;
	        System.out.println(d1.num);
	        System.out.println(d2.num);
	        System.out.println("== 결과 => " + (d1 == d2));
	        System.out.println("equals 결과 => " + d1.equals(d2));
	        System.out.println(d1.toString());
	        System.out.println(d2.toString());
//	        a = 10;
//	        System.out.println("end");
	        
	        
	        Student ss = new Student();
	        ss.num = 99;
	        Object obj = new Student();
	        ((Student)obj).num = 0;
	    }
	    public Student getStudent(int num) {
	        Student s = new Student();
	        s.num = num;
	        return s;
	    }
	    public static void main(String[] args) {
//	        a = 10;
	        new InherTest();  //이름이 없는 객체 생성
	    }
	}
	class Student extends Object{
	    int num; //학번
	    
//	    부모 변수는 자신의 추가된 변수를 접근할 수 없다.
	    @Override
	    public boolean equals(Object obj) {
	        return this.num == ((Student)obj).num;
//	        return this.hashCode() == obj.hashCode();
	    }
	}
