import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[][] dp = new long[N+1][10001];
		int[] m = new int[N+1];
		int[] c = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i< N+1; i++) {
			if(c[i] == 0) {
				Math.max(dp[i-1][0], m[i]);
			}
			else {
				dp[i][0] = dp[i-1][0];
			}
		}
		
		for(int i=1;i<10001;i++) {
			for(int j=1;j<N+1;j++) {
				if(i < c[j]) {
					dp[j][i] = dp[j-1][i];
				}
				else {
					dp[j][i] = Math.max(dp[j][i-1],Math.max(dp[j-1][i],m[j]+dp[j-1][i-c[j]]));
				}
				if(dp[j][i] >= M) {
					System.out.println(i);
					return;
				}
			}
		}
	}
}