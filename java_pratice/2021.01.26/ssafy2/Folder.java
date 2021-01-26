package com.ssafy2;

public interface Folder {
	public void fold();
	public void open();
	default void powerOn() {
		System.out.println("Power On!");
	}
}
