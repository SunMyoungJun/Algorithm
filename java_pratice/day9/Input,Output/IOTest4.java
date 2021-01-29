package com.ssafy.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOTest4 {

	public IOTest4() {
		//		현재 프로젝트 폴더에 있는 IOTest1.java 파일을 C:\IOTest1.java파일로 복사

		//		java com.ssafy.day10.IOTest2 
		File source = new File("IOTest1.java"); // . 현재경로 , .. 상위경로

		String desName = "IOTest4.java";

		//		FileInput, FileOutput
		//		현재 프로젝트 폴더에 있는 IOTest1.java 파일을 C:\IOTest1.java파일로 복사


		//		필터 사용 BufferedReader == (PrintWriter) * BufferedWriter

		BufferedReader br = null;
		InputStreamReader reader = null;
		FileInputStream fis = null;

		PrintWriter pw = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(source);
			//			필터 생상자는(노드 생성자 아님) 반드시, 생성자에 다른 필터, 또는 노드를 가르켜야한다.
			reader = new InputStreamReader(fis);
			br = new BufferedReader(reader);
			fos = new FileOutputStream(desName);
			pw = new PrintWriter(fos);  // crlf 
			//			파일 마지막까지 읽을때까지 읽어서 모든 바이트를 출력 파일에 쓰기
			String data = null; //마지막 정보를 읽으면 null을 반환
			while( (data = br.readLine()) != null) {
				pw.println(data);
			}
			pw.flush();  // 습관적 실행
			//			close구문을 실행하면 자신이 내부 flush메소드를 호출하고 닫기한다.
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
			pw.close();
			try {
				if(fis != null) {
					fis.close();
				}
			}catch(IOException e) {
			}
			try {
				if(reader != null) {
					reader.close();
				}
			}catch(IOException e) {
			}
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
			}
		}

		System.out.println("end");

	}

	public static void main(String[] args) {
		new IOTest4();


	}

}
