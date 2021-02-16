package com.ssafy.exhasutive;

import java.util.Scanner;

///조합 NP  -->조합은 오름차순이런거 중요하지않아서 거꾸로 나와도 상관없음.  이소스처럼
public class C2_NextPermutationTest {
	static int N,R;
	static  int[] input;
	static  int[] P;  //N크기의 flag 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		input = new int[N];
		P = new int[N];

		for(int i=0; i<N;i++) {
			input[i] = sc.nextInt();
		}
		
		
		int cnt =0;
		while(++cnt <=R) 
			P[N-cnt] =1;    //뒤에부터 R만큼 1로 채움
		
		do {
			for(int i=0; i<N;i++) {
				if(P[i] ==1) System.out.print(input[i]+" ");
			}
			System.out.println();
		
		}while(np());
	}

	public static boolean np() {
		int i= N-1;

		while(i>0 && P[i-1] >=P[i]) { //제일꼭대기를 찾아야 swap하면서 다음으로 큰 오름차순의 순열을 찾을수있음.
			i--;  //i가 0보다 큰상황 만족할떄까지 제일 꼭대기를 찾음.
		}	
		//제일 끝부터 시작지점까지 모두 탐색햇는데 더이상 앞자리가 없다! 그러면 현 순열의 상태가 가장 큰 순열의 상태임.(마지막순열)
		if(i==0)  {
			return false; //더 이상 다음 순열 없다.
		}


		int j = N-1;
		while(P[i-1] >=P[j])   // i가 위에서 찾은 제일꼭대기. 따라서 i-1번째랑 바꿔주는 작업.
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
		int temp = P[i];
		P[i] = P[j];
		P[j] = temp;	
	}	
}
