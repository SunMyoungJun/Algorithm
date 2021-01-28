package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest1 {
public static void main(String[] args) throws IOException{
		
		// Code We Need
//		FileInputStream fins = new FileInputStream("hello.txt"); //이건 주석 풀면 오류!
		
		// #1 try-catch-finally
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("hello.txt");			
//		}catch(FileNotFoundException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//			e.printStackTrace();
//		}finally {
//			try {
//				fis.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
//		 #2 throws
//		 public static void main(String[] args) throws FileNotFoundException {
//		 FileInputStream fins = new FileInputStream("hello.txt");
//		
//		// #3 throw e
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("hello.txt");			
//		}catch(FileNotFoundException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//			e.printStackTrace();
//			
//			throw new IOException(); // throw IOException 객체 to main()
//			
//		}finally {
//			try {
//				fis.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		// #4 use AutoCloseable
//		try( FileInputStream fis  = new FileInputStream("hello.txt"); ) { //try(안)에 넣으면 자원을 오토로 자동 닫음.
//																	      //따로 finally에 닫는거 명시안해도됨.
//			// fis code
//		}catch(IOException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//			e.printStackTrace();
//		}	

	}

}
