import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int T=0,P=0,result=0,max=0;
		int[][] map = new int[N][2];
		int[][] dp = new int[N][N];
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		if(map[0][0] <=N) {
			for(int i=0; i<N;i++) {
				dp[0][i] = map[0][1];
			}
			result = map[0][1];
		}
		
		for(int i=1; i<N; i++) {
			T = map[i][0];
			P = map[i][1];
			max=0;
			if(i+T >N) {
				continue;
			}
			
			for(int j=i-1; j>=0; j--) {
				if(j+map[j][0] <=i) {
					max = Math.max(max, dp[j][i]);
				}
			}
			for(int j=i; j<N; j++) {
				dp[i][j] = max + map[i][1];
			}	
			result = Math.max(result, max+map[i][1]);
		}
		System.out.println(result);
	}
}