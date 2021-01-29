package com.ssafy.day10;

public class ExceptionTest2 {

public ExceptionTest2() {
    int[] arr = {1,2,3};
    String name = null;
    
//        Exception : 새우그물   => 부하를 많이 건다
//        ArrayIndexOutOfBoundsException : 고래그물 -> 부하를 적게건다.
        try {
//            System.out.println(name.length());
            System.out.println(arr[5]);
//            상속관계가 존재하는 catch는 반드시 자식부터 catch 하여야한다.(컴파일 오류)
        }catch(Exception e) {  // 공부할때만 사용
//            catch는 실제로 발생하는 SubException만 사용하라
            //NullPointerException | ArrayIndexOutOfBoundsException
            System.out.println("오류 : " + e.getMessage());
        }
        System.out.println("end");
//        int[] arr = {1,2,3};
//        String name = null;
//        try {
////            System.out.println(name.length());
//            System.out.println(arr[5]);
////            상속관계가 존재하는 catch는 반드시 자식부터 catch 하여야한다.(컴파일 오류)
//        }catch(RuntimeException e) {
//            //NullPointerException | ArrayIndexOutOfBoundsException
//            System.out.println("오류 : " + e.getMessage());
//        }
//        System.out.println("end");


//        int[] arr = {1,2,3};
//        String name = null;
//        try {
//            System.out.println(name.length());
//            System.out.println(arr[5]);
////            상속관계가 존재하는 catch는 반드시 자식부터 catch 하여야한다.
//        }catch(ArrayIndexOutOfBoundsException e) {
////            System.out.println("배열 첨자 오류 : " + e.toString());
//            System.out.println("배열 첨자 오류 : " + e.getMessage());
//        }catch(RuntimeException e) {  //NullPointerException
//            System.out.println("오류 : " + e.getMessage());
//        }
//        System.out.println("end");
    }

public static void main(String[] args) {
    new ExceptionTest2();

}
}