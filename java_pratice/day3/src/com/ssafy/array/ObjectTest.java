package com.ssafy.array;

import java.util.Arrays;

public class ObjectTest {

	public static void main(String[] args) {
		//배열을 만들면 각 항목마다 초기값이 할당된다.
//		기본형 => 기본값, 객체는 null값이 초기화 된다.
		String[] arr = new String[5];
		Data[] drr = new Data[5]; //참조하는 변수만 만들어진거 . 아직 arr자체가 만들어진거아님
		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = "ssafy" +i;  //이거는 오류안남. 왜냐면 new String("ssafy"+i) 라고생각하면됨 스트링만예외!
		}
		
		
		for(int i=0; i<drr.length; i++ ) {
//			drr[i].num = i; -->컴파일 하면 오류남 왜냐면 아직 arr는 만들어진게아님
			drr[i] = new Data();  // 이렇게 하고 밑에 찍으면 오류안남. 여기서 생성됨.
			drr[i].num =i;
		}
		
		for(Data d : drr) {  //참조형 타입 이므로 실제 drr안의 num값들이 4로 전부바뀜.
			d.num =4;
		}
		
		for(Data d : drr)
			System.out.println(d.num);
		
		
		///////////////////////////////////////
		// swap , 최대값 , 최소값 알고리즘 알기
		
//		swap 하는법
//		1. 저장할 임시변수 선언
//		2. a값을 임시 변수에 넣기
//		3. b값을 a에 넣기
//		4/ 임시변수 값을 b에 넣기
		
		
//		(example)
		int a =10, b=20, temp;
		temp = a;
		a =b;
		b=temp;
		
//		배열(Collection)에서 최대값 구하기
//		1.최대값을 구하는 곳에 얻을 수 있는 최소값을 넣어라.(max =-10000 이런식 또는 int max = Integer.MIN_VALUE;) 
//		2.반복하면서 배열의 항목값과 최대값 저장된 값을 비교해서
//		     최대값 보다 항목값이 더 크면, 최대값 변수에 항목값을 넣는다.
//		3. 2번을 배열의 개수만큼 반복한다.
		
//		(example)
		int[] srr = {1,2,6,8,3};
		int max = Integer.MIN_VALUE; //또는 0  등등
		
		for(int num : srr) {
			
//			if(max < num) {
//				max =num;
//			}
			max = Math.max(max, num);  //이게 더 좋음 . 위에껀 부등호 방향 등등 실수 있을수도
		}
		System.out.println(max);
		
		int[] trr = {5,2,7,3,1};
		Arrays.sort(trr);
		System.out.println(Arrays.toString(trr));
		
		int[] zrr = new int[4];
		//System.arraycopy();
//		zrr의 배열의 1~2번째까지의 내용을 trr의 3~4번째 정보로 채워주세요.
		
//		(example)
//		for(int i=1; i<=2; i++) {
//			zrr[i] = trr[i+2];
//		}
		System.arraycopy(trr, 3, zrr, 1, 2);
		System.out.println(Arrays.toString(trr));
		System.out.println(Arrays.toString(zrr));
		
	}

	static class Data{
		int num=30;
	}
}
