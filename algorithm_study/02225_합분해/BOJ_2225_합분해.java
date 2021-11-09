import java.util.Scanner;

public class BOJ2225합분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] num = new int[K+1][N+1];
		for(int i=0; i<N+1; i++) {
			num[1][i] = 1;
		}
		for(int i=2; i<=K; i++) {
			for(int j=0; j<=N; j++) {
				int sum=0;
				for(int z=0; z<=j; z++) {
					sum =(sum + num[i-1][j-z]) %1000000000;
				}
				num[i][j] = sum;
			}
		}
		
		System.out.println(num[K][N]);
		
	}

}
