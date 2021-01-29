package com.ssafy.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;



public class IOTest6 {

	public IOTest6() {
		File source = new File("IOTest1.java"); // . 현재경로 , .. 상위경로

		String desName = "IOTest5.java";
		
		
//		JDK 7, AutoCloseable
		try ( BufferedReader br = new BufferedReader
				(new InputStreamReader
						(new FileInputStream(source)));
				PrintWriter pw  = new PrintWriter(new FileOutputStream(desName)); 	
			) {
			String data = null; //마지막 정보를 읽으면 null을 반환
			while( (data = br.readLine()) != null) {
				pw.println(data);
			}
			pw.flush();  // 습관적 실행
			System.out.println("파일 복사 성공");
		}catch(FileNotFoundException  | NullPointerException e) {
			System.out.println("같은 처리" + e);
		}catch(IOException e){
			System.out.println("같은 처리 " + e);
		}

		System.out.println("end");

	}

	public static void main(String[] args) {
		new IOTest6();


	}

}
