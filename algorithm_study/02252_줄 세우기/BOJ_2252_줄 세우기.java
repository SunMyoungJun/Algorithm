import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer>[] arr1;
	static int[] check;
	static StringBuilder sb;
	static Queue<Integer> q1 = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr1 = new ArrayList[N+1];
		check = new int[N+1];
		for(int i=0; i<N+1;i++) {
			arr1[i] = new ArrayList<Integer>();
		}
		
		int v1=0,v2=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			arr1[v1].add(v2);
			check[v2]++;
		}
		
		for(int i=1; i<N+1; i++) {
			if(check[i] ==0) {
				check[i] = -1;
				q1.offer(i);
				sb.append(i).append(" ");
			}
		}
		
		int val1=0,val2=0,size=0;
		while(!q1.isEmpty()) {
			val1 = q1.poll();
			
			size = arr1[val1].size();
			
			for(int i=0; i<size; i++) {
				val2 = arr1[val1].get(i);
				check[val2]--;
				
				if(check[val2] ==0) {
					check[val2] = -1;
					q1.offer(val2);
					sb.append(val2).append(" ");
				}
			}
		}
		System.out.println(sb.toString());
	}
}