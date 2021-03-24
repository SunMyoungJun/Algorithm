import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] dp = new int[31][31];
		for(int i=0;i<=30;i++)
			dp[1][i] = i;
		
		for(int i=2;i<=30;i++) {
			for(int j=i;j<=30;j++)
				dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
		}		
		int n1=0,n2=0;
		while(t-- !=0) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			System.out.println(dp[n1][n2]);
		}	
	}
}