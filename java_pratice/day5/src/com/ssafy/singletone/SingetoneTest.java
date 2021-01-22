package com.ssafy.singletone;

public class SingetoneTest {

	public static void main(String[] args) {
		
		Teacher teacher1 = Teacher.getInstance();
		
			
//		teacher1= new Teacher(); //생성안함 .. 선생님은 1명인데 계속 만드면 안대
		teacher1.name = "김재웅";
		teacher1.location ="구미";
//		
//		
		Student student1 = new Student();
		student1.name = "남상윤";
		student1.age =26;
		student1.teacher = teacher1;

		Teacher teacher2 = Teacher.getInstance();
		teacher2.name = "박박박재용";
		teacher2.location ="구미";
//		
		Student student2 = new Student();
		student2.name = "강민주";
		student2.age =25;
		student2.teacher = teacher2;
//		
//		System.out.println(student1.teacher == student2.teacher);

			System.out.println(teacher1.name); 
			
		
	}

}
