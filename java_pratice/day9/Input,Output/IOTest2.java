package com.ssafy.day10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest2 {

	public IOTest2() {
		//		현재 프로젝트 폴더에 있는 IOTest1.java 파일을 C:\IOTest1.java파일로 복사

//		java com.ssafy.day10.IOTest2 
		File source = new File("IOTest1.java"); // . 현재경로 , .. 상위경로
		
		String desName = "IOTest2.java";

		//		FileInput, FileOutput
		//		현재 프로젝트 폴더에 있는 IOTest1.java 파일을 C:\IOTest1.java파일로 복사
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(desName);
//			파일 마지막까지 읽을때까지 읽어서 모든 바이트를 출력 파일에 쓰기
			int data = 0;
			while(true) {
				data = fis.read();
				if(data == -1) {
					break;
				}
				fos.write(data);
			}
			System.out.println("파일 복사 성공");
		}catch(FileNotFoundException e) {
			System.out.println("파일 오류 e:" + e);
		}catch(IOException e){
			System.out.println("입출력 오류 : " + e);
		}finally {
			try {
				if(fos != null) {
					fos.close();
				}
			}catch(IOException e) {
			}
			try {
				if(fis != null) {
					fis.close();
				}
			}catch(IOException e) {
			}
		}

		System.out.println("end");

	}

	public static void main(String[] args) {
		new IOTest2();


	}

}
