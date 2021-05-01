import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N,M,C,MAX,MAX1,MAX2;
    static int[][] map;
    static int[] person1;
    static int[] person2;
    static int[] sum1;
    static int[] sum2;
    static int temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<test+1; t++) {
            MAX=0; MAX1=0; MAX2=0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            person1 = new int[M];
            person2 = new int[M];
            sum1 = new int[M];
            sum2 = new int[M];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()); 
                }
            }
 
 
            dfs(0,0,0);
//          System.out.println(MAX);
            sb.append("#").append(t).append(" ").append(MAX).append("\n");
        }
        System.out.println(sb.toString());
 
    }
 
 
 
 
 
    static void dfs2(int idx,int cnt,int sum) {
 
        if(sum >C) {
            return;
        }
 
        if(idx == M) {
            temp = 0;
            for(int i=0;i<cnt;i++) {
                temp = temp + sum1[i] * sum1[i];
            }
            MAX1 = (MAX1 > temp) ? MAX1 : temp;
            return;
        }
 
 
        sum1[cnt] = person1[idx];
 
        dfs2(idx+1,cnt+1,sum+person1[idx]);
        sum1[cnt] = 0;
        dfs2(idx+1,cnt,sum);
 
 
    }
 
    static void dfs3(int idx,int cnt,int sum) {
 
        if(sum >C) {
            return;
        }
 
        if(idx == M) {
            temp = 0;
            for(int i=0;i<cnt;i++) {
                temp = temp + sum2[i] * sum2[i];
            }
            MAX2 = (MAX2 > temp) ? MAX2 : temp;
            return;
        }
 
 
        sum2[cnt] = person2[idx];
 
        dfs3(idx+1,cnt+1,sum+person2[idx]);
        sum2[cnt] = 0;
        dfs3(idx+1,cnt,sum);
 
 
    }
 
 
 
 
 
    static void dfs(int row,int col,int cnt) {
        if(cnt == 2) { //기저 조건
         
            dfs2(0,0,0);
            dfs3(0,0,0);
            MAX = (MAX > (MAX1+MAX2)) ? MAX : MAX1+MAX2;
             
            MAX1=0; MAX2=0;
            return;
        }
 
 
 
        for(int i=row; i<N;i++) {
            for(int j=0; j<N;j++) {
                if(i == row && j <col)
                    continue;
 
                if(j+M-1 <N) {
                    if(cnt ==0) {
                        for(int k=0;k<M;k++)
                            person1[k] = map[i][j+k];
                    }
                    else {
                        for(int k=0;k<M;k++)
                            person2[k] = map[i][j+k];
                    }
                    dfs(i,j+M,cnt+1);
                }
            }
        }
 
 
 
 
 
 
 
    }
 
}