import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
 
        for(int t=1; t<test+1; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());    
            int[][] map = new int[N+1][2];
            int[][] dp = new int[N+1][K+1];
 
            for(int i=1; i<N+1; i++) {
                st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());  //부피
                map[i][1] = Integer.parseInt(st.nextToken());  //가치
            }
 
            for(int i=1;i<N+1;i++) {
                for(int j=1;j<K+1;j++) {
                    if(map[i][0] >j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], map[i][1]+ dp[i-1][j-map[i][0]]);       
                }
            }
 
            sb.append("#").append(t).append(" ").append(dp[N][K]).append("\n");
        }
        System.out.println(sb.toString());
    }
}