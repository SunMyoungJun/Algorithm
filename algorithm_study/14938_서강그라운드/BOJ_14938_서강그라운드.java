import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int n,m,r;
	static int[] valValue;
	static List<Node>[] arr1;
	static int[][] distance;
	static PriorityQueue<Node> q1;
	static class Node{
		int s_val;
		int e_val;
		int edge;
		
		public Node(int s_val, int e_val, int edge) {
			this.s_val = s_val;
			this.e_val = e_val;
			this.edge = edge;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr1 = new ArrayList[n+1];
		distance = new int[n+1][n+1];
		valValue = new int[n+1];
		q1 = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (o1.edge > o2.edge) ? 1: -1;
			}
		});
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<n+1; i++) {
			valValue[i] = Integer.parseInt(st.nextToken());
			arr1[i] = new ArrayList<Node>();
			
			for(int j=1; j<n+1; j++) {
				if(i==j) {
					continue;
				}
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int v1=0,v2=0,edge=0;
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
		
			arr1[v1].add(new Node(v1,v2,edge));
			arr1[v2].add(new Node(v2,v1,edge));
		}
		
		Node e1;
		int size=0;
		for(int i=1; i<n+1; i++) {
			size = arr1[i].size();
			for(int j=0; j<size; j++) {
				e1 = arr1[i].get(j);
				
				if(e1.edge > m) {
					continue;
				}
				distance[i][e1.e_val]= e1.edge;
				q1.offer(e1);
				dijkstra(i);
			}
		}
		
		int sum=0;
		int MAX = Integer.MIN_VALUE;
		for(int i=1; i<n+1; i++) {
			sum=valValue[i];
			for(int j=1; j<n+1; j++) {
				if(i==j || distance[i][j] == Integer.MAX_VALUE) {
					continue;
				}
				sum += valValue[j];
			}
			MAX = Math.max(MAX,sum);
		}
		
		System.out.println(MAX);
	}
	
	static void dijkstra(int start) {
		
		Node e1,e2;
		int dist =0,size=0;
		while(!q1.isEmpty()) {
			e1 = q1.poll();
			
			size = arr1[e1.e_val].size();
			
			for(int i=0; i<size; i++) {
				e2 = arr1[e1.e_val].get(i);
				
				dist = distance[start][e1.e_val] + e2.edge;
				
				if(dist > distance[start][e2.e_val] || dist >m) {
					continue;
				}
				
				distance[start][e2.e_val] = dist;
				q1.offer(new Node(e2.s_val,e2.e_val,dist));
			}
		}
		
	}

}
