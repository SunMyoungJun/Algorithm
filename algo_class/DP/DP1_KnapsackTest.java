package DP;

import java.util.Scanner;

public class DP1_KnapsackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();

		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		int[][] D = new int[N+1][W+1];
		for(int i =1; i<=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}

		for(int i =1 ; i<= N; i++) {  //첫 물건 부터 고려
			for(int w =1; w <= W; w++) { // 무게 1부터 고려
				if(weights[i] <= w) { // 가방에 넣을 수 있는 상황
					D[i][w] = Math.max(D[i-1][w-weights[i]] + profits[i] , D[i-1][w]);
				}
				else { // 가방에 넣지 못하는 상황
					D[i][w] = D[i-1][w];
				}
			}
		}

		System.out.println(D[N][W]);
	}

}
