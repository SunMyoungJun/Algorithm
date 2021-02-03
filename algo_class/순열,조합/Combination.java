package com.ssafy.recurive;

import java.util.Arrays;
//순서가 있다. ->순열.
//순서가 없다. ->조합.
//nCr -->조합 --> 재귀 짤때 매개변수 2개..방문체크 필요없음.  ---> 지금 이 소스는 조합!
//순열은 매개변수 1개...,방문체크 배열 필요
public class Combination {

	static int[] numbers;
	static int N=4 , R=2;
	
	public static void main(String[] args) {
		numbers = new int[R];
		
		combination(0, 1);
		
	}
	//1 2 / 1 3 1 4 / 뽑아봣으면 2 1 /3 1/ 4 1등은 안뽑아봐도됨 
	static void combination(int cnt,int start) {
		
		if(cnt ==R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		for(int i=start; i<=N;i++) { 
			numbers[cnt] = i;
			combination(cnt+1,i+1);
		}
		
	}
	

}
