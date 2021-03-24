import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s2 = br.readLine();
		String s1 = br.readLine();
		int[][] dp = new int[s1.length()][s2.length()];
		
		int flag =0;
		for(int i=0;i<s2.length();i++) {
			 if(s2.charAt(i) == s1.charAt(0))
				 flag =1;
			 if(flag ==1)
				 dp[0][i] = 1;
		}
		
		flag =0;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i) == s2.charAt(0))
				flag =1;
			if(flag ==1)
				dp[i][0] = 1;
		}
		
		for(int i=1;i<s1.length();i++) {
			for(int j=1;j<s2.length();j++) {
				if(s1.charAt(i) == s2.charAt(j))
					dp[i][j] = dp[i-1][j-1]+1;
				else 
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println(dp[s1.length()-1][s2.length()-1]);
	}
}