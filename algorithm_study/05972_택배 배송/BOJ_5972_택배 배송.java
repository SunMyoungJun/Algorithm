import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] distance;
	static boolean[] check;
	static ArrayList<Node>[] arr1;
	static PriorityQueue<Node> pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return (o1.edge > o2.edge) ? 1: -1;
		}
	});
	static class Node {
		int s_val;
		int e_val;
		int edge;
		
		public Node(int s_val,int e_val, int edge) {
			this.s_val = s_val;
			this.e_val = e_val;
			this.edge =edge;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr1 = new ArrayList[N+1];
		distance = new int[N+1];
		check = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			arr1[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s_val = Integer.parseInt(st.nextToken());
			int e_val = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
		
			arr1[s_val].add(new Node(s_val,e_val,edge));
			arr1[e_val].add(new Node(e_val,s_val,edge));
		
		}
		
		
		int size =arr1[1].size();
		distance[1] = 0;
		for(Node e1 : arr1[1]) {
			pq1.offer(e1);
		}
		
		
		while(!pq1.isEmpty()) {
			Node e1 = pq1.poll();
			
			
			if(check[e1.e_val] == true) {
				continue;
			}
			
			if(e1.edge <distance[e1.e_val]) {
				check[e1.e_val] = true; 
				distance[e1.e_val]= e1.edge;				
				for(Node e2 : arr1[e1.e_val]) {
					pq1.offer(new Node(e2.s_val,e2.e_val,e2.edge + distance[e2.s_val]));
				}
			}
		}
		
		System.out.println(distance[N]);
		
		
	}

}
