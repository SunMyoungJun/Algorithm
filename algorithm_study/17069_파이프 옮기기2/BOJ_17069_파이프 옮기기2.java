import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st =null;
		long[][][] dp = new long[N+1][N+1][4];  //입력 값, 가로일때 , 대각선일때, 세로일때
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) {
				dp[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][1] =1;  //초기 파이프 가로방향 위치
		for(int i=1;i<N+1;i++) {
			for(int j=3;j<N+1;j++) {
				if(dp[i][j][0] ==1) { //벽일 때
					dp[i][j][1] =0;
					dp[i][j][2] =0;
					dp[i][j][3] = 0;
					continue;
				}
				
				dp[i][j][1] = dp[i][j-1][1]+dp[i][j-1][2];  //가로
				dp[i][j][3] = dp[i-1][j][2] + dp[i-1][j][3];  //세로
				
				if(dp[i][j-1][0] ==1 || dp[i-1][j][0] ==1) {  //대각선 땡겨올 때 옆이나 위가 1이면 못땡겨옴
					dp[i][j][2] =0;
				}
				else { // 대각선
					dp[i][j][2] = dp[i-1][j-1][1] + dp[i-1][j-1][2] + dp[i-1][j-1][3];
				}
			}
		}
		
		System.out.println(dp[N][N][1]+dp[N][N][2]+dp[N][N][3]);
	}

}
