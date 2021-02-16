package com.ssafy.exhasutive;

import java.util.Arrays;
import java.util.Scanner;
////////////////////////////////////////////////////////Next Permutation 방법.(조금 더 빠름)
// NextPermutation : 현순열에서 '사전'순으로 다음 순열 생성.
//NP는 시작할 때 숫자배열을 오름차순으로 정렬하여 가장 작은 순열로 만들어놓고 시작.
//NP는 현재 상태에 기반해서 다음순열 생성함.
public class P4_PermutationNPTest {    //순열
	static int N;
	static int[] input;  //입력받을 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for(int i=0; i<N;i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);  //오름차순 정렬하여 가장 작은 순열의 상태로 만듬.
		
		do {
			System.out.println(Arrays.toString(input));
		}while(np());
		
	}

	public static boolean np() {
		int i= N-1;

		while(i>0 && input[i-1] >=input[i]) { //제일꼭대기를 찾아야 swap하면서 다음으로 큰 오름차순의 순열을 찾을수있음.
			i--;  //i가 0보다 큰상황 만족할떄까지 제일 꼭대기를 찾음.
		}	
		//제일 끝부터 시작지점까지 모두 탐색햇는데 더이상 앞자리가 없다! 그러면 현 순열의 상태가 가장 큰 순열의 상태임.(마지막순열)
		if(i==0)  {
			return false; //더 이상 다음 순열 없다.
		}

		
		int j = N-1;
		while(input[i-1] >=input[j])   // i가 위에서 찾은 제일꼭대기. 따라서 i-1번째랑 바꿔주는 작업.
			j--;
		
		swap(i-1,j);   //이거하고나면 다음 오름차순 순열이 아니라 그 바꾼상태에서의 최고 큰 순열의 상태로 되므로 바꾼 i-1 다음부터 오름차순 해줘야함.
						//3 4 5 9 8 2 -> 3 4 8 9 5 2
		int k = N-1;
		
		while(i<k) {   //내림차순이엿던 상태가 오름차순으로 되면서 다음순열로 된거임. 3 4 8 9 5 2 -> 3 4 8 2 5 9 로변경하자    
			swap(i++,k--);
		}
		return true;	//아직 사전순 오름차순기준으로 다음 순열 있다.
	}
	private static void swap(int i,int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;	
	}	
}
