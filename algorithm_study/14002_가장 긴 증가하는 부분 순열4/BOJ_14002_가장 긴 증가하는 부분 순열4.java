import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{  

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr1 = new int[input+1];
		int[] dp = new int[input+1];

		for(int i=1;i<input+1;i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		int max = -1;
		int temp =-1;
		for(int i=1;i<input+1;i++) {
			temp = -1;
			for(int j=0;j<=i-1;j++) {
				if(arr1[i] >arr1[j] && temp < dp[j]+1) {
					dp[i] = dp[j]+1;
					temp = dp[i];
					max = (max > temp) ? max : temp;
				}
			}
		}
		
		sb.append(max).append("\n");
		int[] savenum = new int[max+1];
		for(int i = input; i>0;i--) {
			if(dp[i] == max) {
				savenum[max] = arr1[i];
				max--;
			}
		}
		
		for(int i=1;i<savenum.length;i++) {
			sb.append(savenum[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}