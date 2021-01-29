package com.ssafy.day10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{

	private static final long serialVersionUID = -3539476484067494349L;
// 반드시 serivUID 값 랜덤생성
	
	String name;
	volatile int age; // 
	transient int privateNumber; //휘발성 메모리 IO대상에서 제거
	int level;
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", privateNumber=" + privateNumber + ", level=" + level + "]";
	}


}
public class SerialTest {

	public SerialTest() throws Exception {
		Person person = new Person();
		person.age  = 27;
		person.name = "김길동";
		person.privateNumber = 5642;
//		메모리 상에서만 저장된 것
//		Output을 이용해서 출력
//		모니터(표준), 파일, 네트워크
//		person 객체를 파일에 저장
//		Stream은 모든 정보를 byte[] 배열로 전송
//		객체 입출력에 사용되는 입출력 객체가 바로 ObjectInput(Output)Stream
//		현재폴더에 sam.dat에 보관
//		ObjectOutputStream oos = null;
//		
//		oos = new ObjectOutputStream(new FileOutputStream("sam.dat"));
////		ObjectOutputStream 메소드에서 writeObject 사용하세요(못본척)
//		oos.writeObject(person);
		
		ObjectInputStream ois =
				new ObjectInputStream(new FileInputStream("sam.dat"));
		
		Person newPerson = (Person)ois.readObject();
		System.out.println(newPerson);
		
		
		System.out.println("end1");
	}

	public static void main(String[] args) throws Exception{
		new SerialTest();

	}

}
