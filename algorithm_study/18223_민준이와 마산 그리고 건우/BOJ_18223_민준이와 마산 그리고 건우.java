import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] arr1;
	static PriorityQueue<Node> pq1 = new PriorityQueue<>(new Comparator<Node>() {
		
		@Override
		public int compare(Node o1,Node o2) {
			return (o1.edge > o2.edge) ? 1: -1;
		}
	});
	static class Node{
		int s_val;
		int e_val;
		int edge;
		
		public Node(int s_val,int e_val,int edge) {
			this.s_val = s_val;
			this.e_val = e_val;
			this.edge = edge;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int P  = Integer.parseInt(st.nextToken());
		
		arr1 = new ArrayList[V+1];
		int[][] instance = new int[2][V+1];
		
		
		for(int i=1; i<V+1;i++) {
			arr1[i] = new ArrayList<Node>();
			instance[0][i] = Integer.MAX_VALUE;
			instance[1][i] = Integer.MAX_VALUE;
		}
		
		instance[0][1] = 0; // 1번 출발시(1번  ~ V번)
		instance[1][P] = 0; // p지점 출발 시 (P번 ~ V번)
		
		int a=0,b=0,c=0;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr1[a].add(new Node(a,b,c));
			arr1[b].add(new Node(b,a,c));
		}
		
		int size = arr1[1].size();
		for(int i=0; i<size; i++) {
			pq1.offer(arr1[1].get(i));
		}
		
		while(!pq1.isEmpty()) {
			Node e1 = pq1.poll();
			
			if(e1.edge < instance[0][e1.e_val]) {
				instance[0][e1.e_val] = e1.edge;
				
				size = arr1[e1.e_val].size();
				
				for(int i=0; i<size; i++) {
					int num = arr1[e1.e_val].get(i).edge + instance[0][e1.e_val];
					pq1.offer(new Node(e1.e_val,arr1[e1.e_val].get(i).e_val,num));
				}
			}	
		}
		
		size = arr1[P].size();
		for(int i=0; i<size; i++) {
			pq1.offer(arr1[P].get(i));
		}
		
		while(!pq1.isEmpty()) {
			Node e1 = pq1.poll();
			
			if(e1.edge < instance[1][e1.e_val]) {
				instance[1][e1.e_val] = e1.edge;
				
				size = arr1[e1.e_val].size();
				
				for(int i=0; i<size; i++) {
					int num = arr1[e1.e_val].get(i).edge + instance[1][e1.e_val];
					pq1.offer(new Node(e1.e_val,arr1[e1.e_val].get(i).e_val,num));
				}
			}	
		}
		
		int num1 = instance[0][V];
		int num2 = instance[0][P] + instance[1][V];
		
		if(num1 >= num2) {
			System.out.println("SAVE HIM");
		}
		else {
			System.out.println("GOOD BYE");
		}
		
	}

}
