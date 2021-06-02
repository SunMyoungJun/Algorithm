import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[][] arr1;
    static boolean[] check;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
         
        for(int t=1; t<test+1;t++) {
            N = Integer.parseInt(br.readLine());
            arr1 = new int[N+2][2];
            check = new boolean[N+2];
            st = new StringTokenizer(br.readLine());
            min = Integer.MAX_VALUE;
             
            for(int i=0;i<N+2;i++) {
                arr1[i][0] = Integer.parseInt(st.nextToken());
                arr1[i][1] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0,0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
     
    static void dfs(int me,int cnt,int sum) {
        if(cnt == N+1) {
            min = (min < sum) ? min : sum;   
            return;
        }
         
        if(min <sum) {
            return;
        }
         
        for(int i=1;i<N+2;i++) {
            if(i==me || check[i] == true || (i==1 &&cnt !=N))
                continue;
             
            check[i] = true;
            dfs(i,cnt+1,sum + Math.abs(arr1[me][0] - arr1[i][0]) + Math.abs(arr1[me][1] - arr1[i][1]));
            check[i] = false;
        }
    }
}