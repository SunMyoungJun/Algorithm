package com.ssafy;

public class inheritanceTest {

	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.setName("Note");
		phone.setColor('B');
		
		phone.setPrice(20000);
		System.out.println(phone);
	
		FolderblePhone fPhone = new FolderblePhone();
		fPhone.setName("Galaxy Folder2");
		fPhone.setColor('A');
		fPhone.setPrice(30000);
		System.out.println(fPhone);
		
		fPhone.setWidth(500);
		fPhone.setHeight(1000);
		System.out.println(fPhone.getSmallSize());
		System.out.println(fPhone.getLargeSize());
	}

}
