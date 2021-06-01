import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static char[][] mat;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
         
         
        for(int t=1; t<test+1;t++) {
            int max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            mat = new char[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    mat[i][j] = st.nextToken().charAt(0);
                }
            }
            int temp=0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    temp = func(i,j);
                    max = (max > temp) ? max : temp;
                }
            }
             
            System.out.println("#"+t+" "+max);
        }
    }
     
    static int func(int r,int c) {
        int tx=0,ty=0;
        int cnt=0;
        for(int i=0;i<8;i++) {
            tx = r+dx[i];
            ty = c+dy[i];
             
            if(tx <0 || tx>=N || ty<0 ||ty >=N) {
                continue;
            }
             
            if(mat[tx][ty] == 'W') {
                cnt++;
            }
        }
         
        cnt = (cnt ==0) ? 1 : cnt;
        return cnt;
    }
 
}