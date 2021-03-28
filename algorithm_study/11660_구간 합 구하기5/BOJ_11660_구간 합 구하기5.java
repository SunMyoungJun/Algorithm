import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		int[][] table = new int [N+1][N+1];
		int[][] dp = new int [N+1][N+1];
		int num =0;
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) {
				num = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i-1][j]+dp[i][j-1] - dp[i-1][j-1] + num;
			}
		}
		int r1=0,r2=0,c1=0,c2=0,sum=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
		
		
			sum = dp[r2][c2] - dp[r2][c1-1] - dp[r1-1][c2] + dp[r1-1][c1-1];
			System.out.println(sum);
			
			
			
			
		}
		
		
	}

}
