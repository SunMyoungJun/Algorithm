package com.ssafy.recurive;

import java.util.Arrays;

public class Permutation {

	
	
	static int[] numbers;
	static int N =3;
	static boolean[] isSelected;
	

	public static void main(String[] args) {
		numbers = new int[N];
		isSelected = new boolean[N+1];
		permutation(0);

	}

	
static void permutation(int cnt) {
	
	if(cnt ==N) {
		System.out.println(Arrays.toString(numbers));
		return;
	}
	
		for(int i=1;i<=N;i++)          //1,2,3 세개의 수가 있을때의 계산임 //i:시도하는 숫자  N:위에서 정한 숫자 갯수
		{
			if(isSelected[i]) continue;
			
			numbers[cnt] =i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
