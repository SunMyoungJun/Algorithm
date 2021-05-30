import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[] parents;
    static Node[] nodeList;
    static class Node implements Comparable<Node> {
        int sval,eval;
        long edge;
 
        public Node(int sval, int eval, long edge) {
            this.sval = sval;
            this.eval = eval;
            this.edge = edge;
        }
    @Override
    public int compareTo(Node o) {
        return (this.edge >= o.edge) ? 1: -1;
    }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        for(int t=1; t<test+1; t++) {
            N = Integer.parseInt(br.readLine());
            int[] row = new int[N];
            int[] col = new int[N];
            parents = new int[N];
            nodeList = new Node[(N*(N-1))/2];
            for(int i=0;i<N;i++) {
                parents[i] = i;
            }
 
            st = new StringTokenizer(br.readLine());
 
            for(int i=0;i<N;i++) {
                row[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                col[i] = Integer.parseInt(st.nextToken());
            }
            double hanul = Double.parseDouble(br.readLine());
            int cnt =0;
            long distance=0;
            for(int i=0;i<N-1;i++){
                for(int j=i+1;j<N;j++){
                    distance = (long) (Math.pow(Math.abs(row[i] - row[j]), 2) + Math.pow(Math.abs(col[i] - col[j]), 2));
                    nodeList[cnt] = new Node(i,j,distance);
                    cnt++;
                }
            }
            Arrays.sort(nodeList);
             
            double sum=0,count=0;
            for(Node n : nodeList) {
                if(union(n.sval , n.eval)) {
                    sum += n.edge;
                    count++;
                    if(count == N-1) {
                        break;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(Math.round(sum * hanul)).append("\n");  
        }
        System.out.println(sb.toString());
    }
     
    private static boolean union(int sval, int eval) {
        int num1 = findSet(sval);
        int num2 = findSet(eval);
        if(num1 == num2) {
            return false;
        }
        parents[num2] = num1;
        return true;
    }
    private static int findSet(int num) {
         
        if(parents[num] ==num) {
            return num;
        }
        return parents[num] = findSet(parents[num]);
    }
}