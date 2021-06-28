import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num1;
		int num2;
		
		public Node(int num1,int num2) {
			this.num1 = num1;
			this.num2 = num2;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int num=0,size=0;
		ArrayList<Integer>[] arr1 = new ArrayList[N+1];
		int[] degree = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr1[i] = new ArrayList<Integer>();
		}
		
		int num1=0,num2=0;
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			arr1[num1].add(num2);
			degree[num2]++;
		}
		
		for(int i=1; i<N+1; i++) {
			if(degree[i] == 0) {
				pq1.offer(i);
			}
		}
		
		while(!pq1.isEmpty()) {
			num = pq1.poll();
			sb.append(num).append(" ");
			
			size = arr1[num].size();
			
			
			for(int i=0; i<size; i++) {
				degree[arr1[num].get(i)]--;
				
				if(degree[arr1[num].get(i)] == 0) {
					pq1.offer(arr1[num].get(i));
				}
			}
		}
		
		System.out.println(sb.toString());
	
		
		
	}
}