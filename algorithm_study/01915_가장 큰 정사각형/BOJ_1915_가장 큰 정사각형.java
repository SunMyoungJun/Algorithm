import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] mat = new int[n][m];
		int[][] dp = new int[n][m];
		int temp =0,max=0;
		String s;
		for(int i=0;i<n;i++) {
			s = br.readLine();
			for(int j=0;j<m;j++){
				mat[i][j] = s.charAt(j) -48;
				if(i==0)
					dp[i][j] = mat[i][j];
				if(j==0)
					dp[i][j] = mat[i][j];
				
				if(mat[i][j] ==1)
					max =1;
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				if(mat[i][j] ==1) {
					temp =0;
					temp = Math.min(dp[i][j-1],dp[i-1][j]); //왼쪽과 위쪽 
					temp = Math.min(dp[i-1][j-1],temp); //(왼쪽과 위쪽) 과  왼 위 쪽
					dp[i][j] = temp+1; 				//구한 최소값에 +1 해준 값 저장.
					max = (max > dp[i][j]) ? max : dp[i][j];
				}
			}
		}
		System.out.println(max*max);
	}
}