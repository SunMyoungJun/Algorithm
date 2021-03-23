package day19;
import java.util.Scanner;

public class Combi_DP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		long[][] dp = new long[n+1][r+1];
//	    dp[1][0] = 1;    
//	    dp[1][1] = 1;
		int k;
	    for (int i = 0; i <= n; i++){
	        dp[i][0] = 1;
	        k = r;
	        if(i < r) {
	        	k = i;
	        }
	        for (int j = 1; j <= k; j++){
	            if(j ==0 || j == i) {
	            	dp[i][j] = 1;
	            }else {
	            	dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
	            }
	         }
	    }
	    
	    System.out.println(dp[n][r]);
	}
}
