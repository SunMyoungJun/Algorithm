package DP;

import java.util.Scanner;
/* 
6
3 2 6 4 5 1
==>3

10
8 2 4 3 6 11 7 10 14 5
==>6
 */
public class DP2_ListTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] map = new int[N];
		int[] LIS = new int[N]; // 각 원소를 끝으로 세웠을 때  최장길이
		
		for (int i = 0; i < N; i++) {
			map[i] = s.nextInt();
		}
		
		int max = 0;
		for(int i=1; i<N; ++i) { // 기존 증가수열에 덧붙일 대상
			LIS[i] = 1; // 자기 혼자 수만 수열에 넣었을때 길이로 초기화.
			for(int j=0; j < i; ++j) { // 맨앞부터 자신의 직전의 원소들과 비교
				if(map[j] <map[i] && LIS[i] < LIS[j]+1) {  // 최대값 갱신 
					LIS[i] = LIS[j]+1;
				}
			}// 결국, LIS[i]에는 자신을 끝으로 하는 최대값이 저장되어 있음
			
			// 전체 결과 중 최장길이최대값 갱신 
			if(max<LIS[i]) max = LIS[i];
		}

		System.out.println(max);
	}
}
