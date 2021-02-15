package com.ssafy.exhasutive;

import java.util.Arrays;
import java.util.Scanner;

public class P3_PermutationBitMaskteacher {


	// 1,2,3
	// 3P3 = 3!
	// nPr  3P2
	static int N, R;
	static int[] input,numbers;
	static int totalCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0,0);
		System.out.println("총 경우의 수 : "+totalCount);
	}
//	1<< N => 1차는 2의 제곱근 구하기  (가장 쉬운 비트마스킹 예제)
//		  => 2차는 N+1번째의 비트값 체크용 데이터 만들기
//	 data & 1 << N  -> 체크용(해당 인덱스 사용하고잇는지여부)
//	 data | 1 << N  -> 마스킹(해당 인덱스 쓰겟다 체크)
//	 ^ -> 서로 다르면 1 아니면 0
//	 ~ -> 각 비트 전부 반대로
	private static void permutation(int cnt, int masking) {
		if(cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0; i<N; ++i) {
			if((masking & (1<<i)) != 0) continue;
			numbers[cnt] = input[i];
			permutation(cnt+1, masking | (1 << i));
		}

	}
}