package com.ssafy.day10;

import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionTest1 {

public ExceptionTest1() {
    System.out.println("생성자 main");
    int[] arr = {4,3,7,5,1};
    int idx = 5;
//        try 블럭은 전체 속도를 무지 느리게 만드다.
//        try 블럭은 꼭 필요한 영역만 블럭 사용
//        try 블럭은 변수의 효력에도 영향을 미친다.
        System.out.println("아무 상관없는 블럭");
        String s = null;  //얘가 초기화안되서 컴파일오류남.따라서 밑에 처럼 쓰기위해 s=null; 초기화 해줘야함.
        try {
            s = "ssafy";
            System.out.println("파일을 열었습니다.");
            System.out.println("1");
            System.out.println(arr[idx]);
//            오류가발생하면 그 이후 라인은 실행되지 않는다(블럭안의)
            System.out.println("2");

//            System.out.println("파일을 닫았습니다.");
        }catch(ArrayIndexOutOfBoundsException e ) {  //여기서 캐치문 없고 try finally만잇다면 try에서 오류가난다?
        											 // 그러면 try에서 오류난 부분까지만 실행 + finally문 실행 후 finall밑부터 출력x되고 오류남.
//            정확하게 catch 되었으면 실행됨.
            System.out.println("3");
            System.out.println(s);
//            int num = 20;
//            System.out.println(num);
//            System.out.println(e);
//            System.out.println("파일을 닫았습니다.");
        }finally {
            System.out.println("파일을 닫았습니다.");
        }

//        System.out.println("파일을 닫았습니다.");
//        아무 상관없이 실행됨
        System.out.println("4");
//        if(idx < arr.length) {
//            System.out.println(arr[idx]);
//        }
        System.out.println("생성자 end");
    }
// java ExceptionTest1  => JVM
    public static void main(String[] args) {
        System.out.println("start main");
        new ExceptionTest1();

        System.out.println("end main");
    }

}