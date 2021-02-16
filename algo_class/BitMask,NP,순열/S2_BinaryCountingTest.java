package com.ssafy.exhasutive;

import java.util.Scanner;
//입력받은 수들로 가능한 부분집합 구성 : 경우의 수의 비트마스킹 활용
public class S2_BinaryCountingTest꼭보자 {
	static int N;
	static int[] input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		int caseCount = 1<<N;// 1을 N번 시프트하면 2^N 구하는거임. 직접계산해도 상관없음.  -1번방법
		int num = (int)Math.pow(2, N); //아주 큰수는 오류발생.
		generateSubset(caseCount);  
	}
	
	
	// n:3일 경우의 총 부분집합의 경우의수 ==>8
	// 경우의수 8을 이용하여 0-7까지의 값을 비트마스킹으로 사용
	// 000 001 010 011 100 101 110 111
	// 위 3자리의 비트를 아래처럼 인식하여 처리한다.
	// 2인덱스원소 1인덱스원소 0인덱스원소 (각 비트가 1인 경우 : 해당원소 부분집합에 포함)
	private static void generateSubset(int caseCount) { //원소 3개면caseCount:8 - 0~7 사용. 4개면  caseCount:16 - 0~15사용
		for(int flag=0; flag<caseCount; flag++) { // flag :비트마스크가 되어있는 수라고 보면됨.
			for (int j = 0; j < N; j++) {  // 맨뒤부터 N개의 비트열을 확인.
				if((flag & 1 <<j) !=0) {
					System.out.print(input[j]+" ");
				}else {
					System.out.print("X ");
				}				
			}
			System.out.println();
		}
	}

}
