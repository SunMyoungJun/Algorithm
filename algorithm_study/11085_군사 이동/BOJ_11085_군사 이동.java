import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int p,w,c,v;
	static int[] val;
	static int min =Integer.MAX_VALUE;
	static PriorityQueue<Node> pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
		@Override
		public int compare(Node e1, Node e2) {
			if(e1.edge == e2.edge) {
				return -1;
			}
			else {
				return e1.edge < e2.edge ? 1: -1;
			}
		}
	});
	
	static class Node {
		int n1;
		int n2;
		int edge;
		
		public Node(int n1,int n2,int edge) {
			this.n1 = n1;
			this.n2 = n2;
			this.edge = edge;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		val = new int[p];
		
		for(int i=0; i<p;i++) {
			val[i] = i;
		}
		int n1=0,n2=0,edge=0;
		
		while(w-- !=0) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			pq1.offer(new Node(n1,n2,edge));
		}
		Node e1;
		while(!pq1.isEmpty()) {
			e1 = pq1.poll();
			if(union(e1.n1,e1.n2)) {
				min = min > e1.edge ? e1.edge : min;
				
				if(findSet(c) == findSet(v)) {
					break;
				}
			}
		}
		System.out.println(min);
	}

	static int findSet(int num) {
		if(val[num] == num) {
			return num;
		}
		return val[num] = findSet(val[num]);
	}
	
	static boolean union(int n1, int n2) {
		n1 = findSet(n1);
		n2 = findSet(n2);
		if(n1 == n2) {
			return false;
		}
		val[n1] = n2;
		return true;
	}
}