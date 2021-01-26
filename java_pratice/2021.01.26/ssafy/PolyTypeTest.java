package com.ssafy;

public class PolyTypeTest {

	public static void main(String[] args) {
//		 Object o = new Phone();
//		 Phone p = new Phone();
//		 FolderblePhone fp = new Phone();   //얘는 안됨 . 왼쪽이 하위 클래스 오른쪽이 상위클래스라서 안돼!!
		 Phone p = new FolderblePhone();
//		 Object o = new Object();
		 Object o = new FolderblePhone();
	}

}