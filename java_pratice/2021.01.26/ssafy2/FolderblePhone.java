package com.ssafy2;

public class FolderblePhone extends Phone implements Folder {

	@Override
	public void fold() {
		System.out.println("fold");
	}

	@Override
	public void open() {
		System.out.println("open");
		
	}

}
