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
	static ArrayList<Node>[] arr1;
	static PriorityQueue<Node> pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return (o1.edge > o2.edge) ? 1: -1;
		}
	});
	static class Node {
		int n1;
		int n2;
		int edge;
		public Node(int n1,int n2,int edge) {
			this.n1 = n1;
			this.n2= n2;
			this.edge= edge;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int n1=0,n2=0,edge=0,size=0,cnt=0;
		StringBuilder sb = new StringBuilder();
		distance = new int[N+1];
		arr1 = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			arr1[i] = new ArrayList<Node>();
			distance[i] = Integer.MAX_VALUE;
		}
		distance[1] = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			arr1[n1].add(new Node(n1,n2,edge));
			arr1[n2].add(new Node(n2,n1,edge));
		}
		size = arr1[1].size();
		for(int i=0; i<size; i++) {
			pq1.offer(arr1[1].get(i));
		}
		Node e1,e2;
		while(!pq1.isEmpty()) {
			e1 = pq1.poll();
			
			if(e1.edge < distance[e1.n2]) {
				distance[e1.n2]= e1.edge; 
				cnt++;
				sb.append(e1.n1).append(" ").append(e1.n2).append("\n");
				size = arr1[e1.n2].size();
				
				for(int i=0; i<size; i++) {
					e2 = arr1[e1.n2].get(i);
					pq1.offer(new Node(e2.n1,e2.n2,distance[e2.n1]+e2.edge));
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}