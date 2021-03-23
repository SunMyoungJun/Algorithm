package day19;

import java.util.Scanner;


public class DP1_MinCoinTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] dp = new int[money+1];
		dp[0] = 0; //생략이 가능 0원에 대한 동전의 최소갯수
		int min;
		for(int i=1; i<=money; ++i) {
			min = Integer.MAX_VALUE;
			if(dp[i-1]+1<min) min = dp[i-1]+1;
			if(i>=4 && dp[i-4]+1<min) min = dp[i-4]+1;
			if(i>=6 &&dp[i-6]+1<min) min = dp[i-6]+1;
			dp[i] = min;
		}
		System.out.println(dp[money]);
	}

}
