package com.ssafy.array;

import java.util.Arrays;
import java.util.Scanner;

public class IndexValueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 숫자로만 구성된 문자열을 입력 받아서 그 숫자의 입력 갯수를 구하여 출력하라.
		
		//1234565667777   7=> 4,
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char ch;
		//누적 변수 0~9까지 이기 때문에 10개 (배열)
		// A : 65  a : 97    0 :48
		int[] counts = new int[10];
		int idx;
		for(int i=0; i<input.length(); i++) {
			ch = input.charAt(i);
			System.out.println(ch);
			idx = ch -48; // 또는 ch -'0' 같은결과 '0'빼는게 가동률 면에서 좋음.
//			idx = Integer.parseInt(ch+""); //이런방식도있음. char형은 인트형 바로 못바꿔서 "" 붙혀서 스트링 변환 후 바꿈.
			counts[idx]++;
		}
		System.out.println(Arrays.toString(counts));
	
	//입력, 처리, 출력은 항상 분리하는 습관! (진짜 나중에 최적화해야하고 시간을 엄청 줄여야하면 그때는 처리와 출력 등을 같이해도 무관)
		int cnt =0;
		int[][] arr = new int[3][];
		arr[0] = new int[3];
		arr[1] = new int[5];
		arr[2] = new int[1];
		
		for(int i=0; i< arr.length;i++)
		{
			for(int j=0; j<arr[i].length;j++)
			{
				arr[i][j] = cnt;
				cnt++;
			}
		}
		
		
		
		
		
		for(int i=0; i< arr.length;i++)
		{
			for(int j=0; j<arr[i].length;j++)
			{
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		
		for(int[] temp : arr) {
			for(int data : temp) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	
	}

}
