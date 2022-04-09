import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] val;
	static Queue<Integer> q1;
	static ArrayList<Integer>[] arr1;
	static int K,M,P,A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int test = Integer.parseInt(br.readLine());
		int num=0,num2=0,size=0;
		StringBuilder sb = new StringBuilder();
		while(test-- !=0) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P= Integer.parseInt(st.nextToken());
			q1 = new LinkedList<>();
			val = new int[M+1][3];
			arr1 = new ArrayList[M+1];
			
			for(int i=1; i<M+1; i++) {
				arr1[i] = new ArrayList<>();
			}
			
			while(P-- !=0) {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken()); 
				B = Integer.parseInt(st.nextToken()); 
				arr1[A].add(B);
				val[B][0]++;
			}
			
			for(int i=1; i<M+1; i++) {
				if(val[i][0]==0) {
					val[i][1]=1;
					q1.offer(i);
				}
			}
			
			while(!q1.isEmpty()) {
				num = q1.poll();
				size = arr1[num].size();
				for(int i=0; i<size; i++) {
					num2 = arr1[num].get(i);
					val[num2][0]--;
					
					if(val[num][1] > val[num2][1]) {
						val[num2][1] = val[num][1];
						val[num2][2] = 1;
					}
					else if(val[num][1] == val[num2][1]) {
						val[num2][2]++;
					}
					
					if(val[num2][0] ==0) {
						q1.offer(num2);
						if(val[num2][2] >1) {
							val[num2][1]++;
						}
					}
				}
			}
			sb.append(K).append(" ").append(val[M][1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}