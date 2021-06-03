import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt =0;
        int test = Integer.parseInt(br.readLine());
        int p=0,q=0;
        int r1=0,r2=0,c1=0,c2=0;
        int tf=0;
        int R=0,C=0;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<test+1; t++) {
            st =  new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            cnt=0; tf=0;
             
            int n1=1,n2=1;
            aaa:for(int i=1; ;i++) {
                n1 =i;
                n2=1;
                for(int j=1; j<=i; j++) {
                    cnt++;
                    if(cnt == p) {
                        tf++;
                        r1 = n1;
                        c1 = n2;
                        if(tf==2)
                            break aaa;
                    }
                     
                    if(cnt ==q) {
                        tf++;
                        r2 = n1;
                        c2 = n2;
                        if(tf==2)
                            break aaa;
                    }
                    n1 --;
                    n2 ++;
                }
            }
             
             
            R = r1+r2;
            C = c1+c2;
     
            cnt=0;
            bbb:for(int i=1; ;i++) {
                n1 =i;
                n2=1;
                for(int j=1; j<=i;j++) {
                    cnt++;
                    if(R == n1 && C == n2) {
                        break bbb;
                    }
                    n1 --;
                    n2 ++;
 
                }
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}