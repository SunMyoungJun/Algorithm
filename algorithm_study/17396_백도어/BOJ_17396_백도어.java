import java.util.*;
import java.io.*;
public class Main {
	static int N,M;
	static boolean[] check;
	static long[] distance;
	static boolean[] visited;
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
		long edge;
		
		public Node(int s_val,int e_val, long edge) {
			this.s_val = s_val;
			this.e_val = e_val;
			this.edge = edge;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean[N];
		arr1 = new ArrayList[N];
		distance = new long[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		int nn1=0;
		for(int i=0; i<N; i++) {
			nn1 = Integer.parseInt(st.nextToken());
			check[i] = (nn1 ==0) ? true : false;
			arr1[i] = new ArrayList<>();
			distance[i] = Long.MAX_VALUE;
		}
		
		visited[0] = true;
		
		int n1=0,n2=0;
		long edge=0;
	
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			
			arr1[n1].add(new Node(n1,n2,edge));
			arr1[n2].add(new Node(n2,n1,edge));
		}
		
		
		
		distance[0] =0;
		check[N-1] = true;
		
		int startsize = arr1[0].size();
		
		
		for(int i=0; i<startsize; i++) {
			Node e1 = arr1[0].get(i);
			pq1.offer(new Node(e1.s_val,e1.e_val,e1.edge));
		}
		
		int size=0;
		
		while(!pq1.isEmpty()) {
			Node e1 = pq1.poll();
			
			if(check[e1.e_val] == false) {
				continue;
			}
			
//			if(distance[e1.e_val] != Long.MAX_VALUE) {
//				continue;
//			}
//			
			if(visited[e1.e_val] == true) {
				continue;
			}
			
			
			if(e1.edge < distance[e1.e_val]) {
				distance[e1.e_val] = e1.edge;
				check[e1.e_val]= true; 
				size = arr1[e1.e_val].size();
				for(int i=0; i<size; i++) {
					Node e2 = arr1[e1.e_val].get(i);
					pq1.offer(new Node(e2.s_val,e2.e_val,e2.edge + distance[e2.s_val]));
				}
			}
		}
		
		
		if(distance[N-1] == Long.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(distance[N-1]);
		}
		

	}

}
