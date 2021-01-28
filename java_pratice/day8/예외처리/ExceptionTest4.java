package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest4 {
public static void main(String[] args) {
		
		// Not Runtime Exception
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("hello.txt");			
		}catch(FileNotFoundException e) {
			System.out.println("Handing Exception : " + e.getMessage());
		}catch(IOException e1) {
			System.out.println("Handing Exception : " + e1.getMessage());
		}catch(Exception e2) {  //얘가 가장 상위 예외기 때문에 마지막에 쓴다.
			System.out.println("Handing Exception : " + e2.getMessage());
		}
		
		// Runtime Exception
//		try {
//			String s = null;
//			s.length();
//		}catch(RuntimeException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//		}catch(NullPointerException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//		}
	}
}
