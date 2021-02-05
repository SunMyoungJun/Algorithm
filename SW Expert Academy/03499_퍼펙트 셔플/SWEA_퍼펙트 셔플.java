import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        StringBuilder sb= new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        for(int t=1;t<test+1;t++) {
            sb.append("#").append(t).append(" ");
            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
 
            for(int i=0;i<num;i++) {
                if(i <num/2 + num%2) {
                    q1.offer(st.nextToken());
                }
                else
                    q2.offer(st.nextToken());
            }
            while(!q1.isEmpty() || !q2.isEmpty()) {
                if(!q1.isEmpty()) 
                    sb.append(q1.poll()).append(" ");
                if(!q2.isEmpty())
                    sb.append(q2.poll()).append(" ");
            }
            q1.clear();
            q2.clear();
            sb.append("\n");
             
        }
        System.out.println(sb.toString());
    }
 
}