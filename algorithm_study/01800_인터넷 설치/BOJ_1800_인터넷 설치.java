import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int N,P,K;
	static ArrayList<Node>[] arr1;
	static int[] distance;
	static PriorityQueue<Node> pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
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
		
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		
		arr1 = new ArrayList[N+1];
		distance = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr1[i] = new ArrayList<Node>();
		}
		int v1=0,v2=0,edge=0,start=0,end=0,mid=0;
		for(int i=0; i<P; i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			end = (edge > end) ? edge : end;
			arr1[v1].add(new Node(v1,v2,edge));
			arr1[v2].add(new Node(v2,v1,edge));
		}
		int result=-1,size=arr1[1].size();
		Node e1;
		while(start <= end) {
			pq1.clear();
			mid = (start+end) /2;
			
			for(int i=0; i<size;i++) {
				e1 = arr1[1].get(i);
//				pq1.offer(new Node(1,e1.e_val, (e1.edge > mid) ? 1:0));
				pq1.offer(e1);
			}
			for(int i=2; i<N+1; i++) {
				distance[i] = Integer.MAX_VALUE;
			}
			
			
			
			if(dijk(mid)) {
				result = mid;
				end = mid-1;
			}
			else {
				start=mid+1;
			}
		}
		
		System.out.println(result);
		
		
	}
	
	static boolean dijk(int num) {
		Node e1;
		int dist=0,size=0;
		while(!pq1.isEmpty()) {
			e1 = pq1.poll();
			dist = (e1.edge >num) ? 1 : 0;
			
			if(distance[e1.s_val] + dist < distance[e1.e_val]) {
				distance[e1.e_val] = distance[e1.s_val] + dist;
				size = arr1[e1.e_val].size();
				for(int i=0; i<size; i++) {
					pq1.offer(arr1[e1.e_val].get(i));
				}
			}
			
		}
		return (distance[N] > K) ? false : true;
	}
}
