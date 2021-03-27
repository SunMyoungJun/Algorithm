import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st= null;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<test+1; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr1 = new int[N];
			int[] dp = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			
			int MAX = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				dp[i] =1;
				for(int j=0;j<i;j++) {
					if(arr1[i] > arr1[j] && dp[i] < dp[j]+1) {
						dp[i] = dp[j]+1;
					}
				}
				MAX = (MAX > dp[i]) ? MAX : dp[i];
			}
			
			sb.append("#").append(t).append(" ").append(MAX).append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
