import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] dx = {0,1,1};
	static int[] dy = {1,1,0};
	static int[][] map,dp;
	static int M,N,max;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M+1][N+1];
		dp = new int[M+1][N+1];
		for(int i=1; i<M+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=1; i<M+1; i++) {
			for(int j=1; j<N+1;j++) {
				if(map[i][j] == 0) {
					dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
					max = Math.max(dp[i][j], max);
				}
				else {
					dp[i][j] = 0;
				}
			}
		}
		
		
		System.out.println(max);
		

	}
	

}
