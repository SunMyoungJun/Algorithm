package com.ssafy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;






public class CompareTest3 {
	class Student implements Comparable<Student>{
		String name;
		int age;
		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}
		@Override
		public int compareTo(Student o) {
			return this.age - o.age;
		}
	
	
	}
	public CompareTest3() {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("kim1",30));
		list.add(new Student("kim4",32));
		list.add(new Student("kim2",36));
		list.add(new Student("kim5",34));
		list.add(new Student("kim3",33));
	
		for(Student s : list)
			System.out.println(s.toString());
		System.out.println("--------------------");
		Collections.sort(list);
		for(Student s : list)
			System.out.println(s.toString());
	
		System.out.println("-----------시작나중에-------"); //나중에 이름순으로 비교하는 그 순간에만.. 처음ㅇ부터 정렬 필요없을때 ㅇㅇ
		Collections.sort(list,new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name); // 이름으로 비교해서 오름차순 내림차순 정함.
			}
		});
		for(Student s : list)
			System.out.println(s.toString());
		System.out.println("--------------------");
	}

	public static void main(String[] args) {
		new CompareTest3();
	}

}
