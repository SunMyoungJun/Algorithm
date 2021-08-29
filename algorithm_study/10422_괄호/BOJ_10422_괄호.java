import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		int len =0;

		while(test-- !=0) {
			len = Integer.parseInt(br.readLine());
			long[] dp = new long[len*2+1];

			dp[0] =1;
			dp[2] =1;

			for(int i=2;i<= len; i++) {
				for(int j=0;j<=i-1;j++) {
					dp[i*2] = (dp[i*2] + dp[j*2] * dp[(i-1-j)*2]) %  1000000007;
				}
			}
			System.out.println(dp[len]);
		}
	}
}
