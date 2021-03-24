import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][] dp = new int[n][n];
		StringTokenizer st = null;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int idx =0;
			while(st.hasMoreTokens()) {
				map[i][idx] = Integer.parseInt(st.nextToken());
				idx++;
			}
		}
		
		dp[0][0] = map[0][0];
		int max =0;
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j ==0) {
					dp[i][j] = map[i][j] + dp[i-1][j];
				}
				else if(j == n-1) {
					dp[i][j] = map[i][j] + dp[i-1][j-1];
				}
				else {
					max = (dp[i-1][j-1] > dp[i-1][j]) ? dp[i-1][j-1] : dp[i-1][j];
					dp[i][j] = map[i][j]+max;
				}
			}
		}
		
		int MAX=0;
		for(int i=0; i<n;i++) {
			MAX = (MAX > dp[n-1][i]) ? MAX : dp[n-1][i];
		}		
		System.out.println(MAX);
	}
}