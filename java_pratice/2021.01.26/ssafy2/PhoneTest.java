package com.ssafy2;

public class PhoneTest {

	public static void main(String[] args) {
		

		Folder folder = new FolderblePhone();
		
		folder.powerOn();
		folder.open();
		folder.fold();
		
		OuterPhone op = new OuterPhone("12345");
		System.out.println(op.ic.serialNo);
	
	}

}
