package com.ssafy.exhasutive;

import java.util.Arrays;
import java.util.Scanner;
/**

@author THKim
 */
public class P4_PermutationNPTteacher {  
	static int N;
	static int[] input;
	static int totalCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input); //정렬이 필수(오름차순) 작은 순열먼저 발생해야하는 경우 좋음
		do {
			System.out.println(Arrays.toString(input));
		}while(np());

		System.out.println("총 경우의 수 : "+totalCount);
	}  
	private static boolean np() {
		totalCount++;
		int i=N-1;
		while(i>0 && input[i-1]>=input[i]) --i;

		//        더이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰순열(마지막 순열)
		if(i==0) return false;

		//        다시 j도 마지막에서 찾기 시작
		int j=N-1;
		while(input[i-1]>=input[j])    --j;
		swap(i-1,j);

		//        나머지 내림차순을 다시 오름차순으로 변경(정렬대신 맨앞과 맨뒤를 1/2 만큼 교환)
		int k = N-1;
		while(i<k) {
			swap(i++,k--);            
		}
		return true;
	}

	private static void swap(int i,int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}