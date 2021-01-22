package com.ssafy.classsam;

public class ObjectTest {

	public static void main(String[] args) {
//		휴대폰(Object = 사물)
//		명사 : 이름,색상,제조사,가격  등등등  많은것중에 몇개만 뽑아낸것 -> 추상화  / 몇개의 사물들에서 공통된 몇개를 뽑아내는것 ->일반화       
//		동사 : 켜다(),크다(),할부원금() +set.getter  메소드 + 생성자
		
		Phone phone = new Phone(); //인스턴스화 과정
		Phone phone1 = new Phone(); //인스턴스화 과정
//		위 두개의 인스턴스는 다른거임.
//		각각의 인스턴스의 접근은 . 으로 함 ex) phone.name = "gg" / phone1.name ="gf" 이런식
	
	}

}



class Phone{
	String name;
	String color;
	String maker;
	int price;
	
	void on() {}
	void off() {}
	
	
}