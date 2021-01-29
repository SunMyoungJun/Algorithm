package com.ssafy.day10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest1 {

	/* Stream : 입출력 흐름  
	 * Input 전용 , Output 전용    * 예외 RandomAccessFile: 겸용
	 * I/O 중심은 Java
	 * Node :(키보드,모니터)==표준IO, 파일IO, 네트워크IO  터미널, Node
	 * Filter : 버퍼, Data, byte=>charater
	 * Byte단위 입출력  ~~~Steram
	 * Character 단위 입출력  ~~~Reader,  ~~~Writer
	 * ex1: DataInputStream :입력용,, byte, 필터
	 * ex2: FileWriter : 출력용, 글자단위, Node
	 * 
	 * IO를 대표하는 추상클래스
	 * InputStream, OutputStream
	 * Reader, Writer
	 * 파일 및 디렉토리(폴더)를 관리하는 클래스 : File
	 */
	public IOTest1() {
		//        현재 프로젝트 폴더에 있는 IOTest1.java 파일을 C:\IOTest1.java파일로 복사

		File source = null;

		source = new File("."); // . 현재경로 , .. 상위경로
		System.out.println(source.isDirectory());
		System.out.println(source.getName());
		System.out.println(source.getAbsolutePath());

		source = new File(source, "IOTest1.java");
		System.out.println("**********************");
		System.out.println(source.isDirectory());
		System.out.println(source.getName());
		System.out.println(source.getAbsolutePath());

		System.out.println("존재여부 : " + source.exists());
		System.out.println(source.length() + "byte");
		//        System.out.println(source.delete());
		//        이름 변경 
		//        File newName = new File(".", "new.txt");
		//        source.renameTo(newName);


		//         window : \   unix : /
		String desName = "C:"+File.separator+"IOTest1.java";

		//        FileInput, FileOutput
		//        현재 프로젝트 폴더에 있는 IOTest1.java 파일을 C:\IOTest1.java파일로 복사
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			//            open하면 항상 close한다
			//            file은 open이 없고 생성이 open을 대신한다.
			fis = new FileInputStream(source);
			fos = new FileOutputStream(desName);


			//            오류가 나면 아래구문 실행 안됨.
			System.out.println("테스트");
		}catch(FileNotFoundException e) {
			System.out.println("파일 오류 e:" + e);
		}catch(IOException e) {
			System.out.println("입출력 오류 e:" + e);
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
			new IOTest1();


		}
	}