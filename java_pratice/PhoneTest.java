package com.ssafy;

public class PhoneTest {

	public static void main(String[] args) {

//		Phone phone = new Phone();
//		phone.name = "S21";
//		phone.color = 'B';
//		phone.price = 1000000;
//		
//		
//		int w = phone.getRealDebt();
//		System.out.println(w);
//		
//		Phone phone2 = new Phone();
//		phone2.name = "S22";
//		phone2.color = 'R';
//		phone2.price = 15000;
//		int ww = phone2.getRealDebt();
//		System.out.println(ww);
///////////////////////////////////////////
//		Phone phone = new Phone("S21");  //Phone클래스의 첫번쨰 생성자 호출.
//		Phone phone2 = new Phone(); //Phone클래스의 두번쨰 기본생성자 호출.
		
		/////////////////////////////////
		
//		Phone phone = new Phone("S21");
//		System.out.println(phone.getName());
		//////////////////////////////////////////
//		Phone phone = new Phone();
//		phone.setName("Galaxy Note");
//		phone.setColor('B');
//		phone.setPrice(10000);
//		System.out.println(phone.getSalePrice());
////////////////////////////////////////////////////////////
		Phone[] phoneArray = new Phone[5]; //객체 생성된거 아님. 변수만 생성
		
		for(int i=0;i<phoneArray.length;i++)
		{
			phoneArray[i] = new Phone();
			phoneArray[i].setPrice(i*2000);
			
		}
		
		for(Phone a : phoneArray)
			System.out.println(a.getPrice());
	}

}
