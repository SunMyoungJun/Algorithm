import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] gyu = new int[9]; //규영
    static int[] in = new int[9];  //인영
    static int[] tempin = new int[9];  //인영
    static boolean[] check = new boolean[9];
    static int sum1,sum2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        for(int t=1;t<test+1;t++) {
            sum1=0; sum2=0;
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<9;i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
            }
             
            int cnt =0;
            boolean tf=false;
            for(int i=1;i<19;i++) {
                for(int j=0;j<9;j++) {
                    if(gyu[j] == i) {
                        tf =true;
                        break;
                    }
                }
                if(tf ==true) {
                    tf =false;
                    continue;
                }
                in[cnt] = i;
                cnt++;
            }
         
            dfs(0);
            sb.append(sum1).append(" ").append(sum2).append("\n");
             
        }
        System.out.println(sb.toString());
         
 
    }
     
    static void dfs(int cnt) {
        if(cnt ==9) {
            int t1=0,t2=0;
             
            for(int i=0; i<9;i++) {
                if(gyu[i] > tempin[i]) 
                    t1 = t1+ gyu[i] +tempin[i];
                else
                    t2 = t2 + gyu[i] + tempin[i];
            }
             
            if(t1>t2)
                sum1++;
            else
                sum2++;
 
             
            return;
        }
         
        for(int i=0;i<9;i++) {
            if(check[i] == true)
                continue;
             
            tempin[cnt] = in[i];
            check[i] = true;
            dfs(cnt+1);
            check[i] = false;
             
        }
    }
}