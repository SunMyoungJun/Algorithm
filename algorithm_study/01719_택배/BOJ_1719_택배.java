import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static ArrayList<Node>[] arr1;
	static PriorityQueue<Node> pq1;
	static int[][] distance;
	static String[][] val;
	
	
	static class Node {
		int n1;
		int n2;
		int first;
		int cnt;
		int edge;
		public Node(int n1,int n2,int first,int cnt,int edge) {
			this.n1 = n1;
			this.n2 = n2;
			this.first = first;
			this.cnt = cnt;
			this.edge= edge;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1=0,n2=0,edge=0,size=0;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr1 = new ArrayList[n+1];
		distance = new int[n+1][n+1];
		val = new String[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			arr1[i] = new ArrayList<Node>();
			for(int j=1; j<n+1; j++) {
				if(i==j) {
					distance[i][j] =0;
					val[i][j] = "-";
				}
				else {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		while(m-- !=0) {
			st = new StringTokenizer(br.readLine());
			
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			arr1[n1].add(new Node(n1,n2,n2,0,edge));
			arr1[n2].add(new Node(n2,n1,n1,0,edge));
		}
		
		
		for(int i=1; i<n+1; i++) {
			int stop=0;
			pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if(o1.edge == o2.edge) {
						return o1.cnt > o2.cnt ? 1: -1;
					}
					return o1.edge > o2.edge ? 1: -1;
				}
			});
			
			
			size = arr1[i].size();
			
			for(int j=0; j<size; j++) {
				pq1.offer(arr1[i].get(j));
			}
			
			
			while(!pq1.isEmpty()) {
				Node e1 = pq1.poll();
				
				if(distance[i][e1.n2] > e1.edge) {
					distance[i][e1.n2]= e1.edge;
					size = arr1[e1.n2].size();
					val[i][e1.n2]= Integer.toString(e1.first); 
					stop++;
					if(stop == n-1) {
						break;
					}
					for(int j=0; j<size; j++) {
						Node e2 = arr1[e1.n2].get(j);
						pq1.offer(new Node(e2.n1,e2.n2,e1.first,e2.cnt+1,e2.edge+distance[i][e1.n2]));
					}
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				sb.append(val[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		
		
		

	}

}
