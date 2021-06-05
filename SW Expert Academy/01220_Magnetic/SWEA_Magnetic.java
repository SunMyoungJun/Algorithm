import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N=0;
        for(int t=1; t<11;t++) {
            int count=0;
            N = Integer.parseInt(br.readLine());
            int[][] mat = new int[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(mat[i][j] == 1)  {  //N극의 성질일 떄
                        mat[i][j] = 3;
                        for(int k=i+1; k <N;k++) {
                            if(mat[k][j] ==3) 
                                break;
                             
                            if(mat[k][j] == 2) {
                                count++;
                                mat[k][j] = 3;   //쓸모없는 수로 초기화
                                break;
                            }
                        }
                    }
                    else if(mat[i][j] ==2) { //S극의 성질일 때
                        mat[i][j] =3;
                        for(int k=i-1; k >=0;k--) {
                            if(mat[k][j] ==3) 
                                break;
                             
                            if(mat[k][j] == 1) {
                                count++;
                                mat[k][j] =3;   //쓸모없는 수로 초기화
                                break;
                            }
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}