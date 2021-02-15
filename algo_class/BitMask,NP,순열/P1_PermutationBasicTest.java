package com.ssafy.exhasutive;

import java.util.Arrays;
import java.util.Scanner;

//nPn 할거임
public class P1_PermutationBasicTest {    //순열
	static int N;
	static int[] input,numbers;  //입력받을 배열, 선택 수 관리할 배열
	static boolean[] isSelected; //해당수 사용중인지 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N;i++) {
			input[i] = sc.nextInt();
		}
		permutation(0);
	}
	
	private static void permutation(int cnt) {
		if(cnt ==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0; i<N;i++) {
			if(isSelected[i] ==true) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
			
		}
	}

}
