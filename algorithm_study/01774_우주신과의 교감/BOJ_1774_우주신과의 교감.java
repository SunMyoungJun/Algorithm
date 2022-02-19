import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static double sum,absX,absY,absXY;
	static int[] val;
	static class Node {
		int n1;
		int n2;
		double dis;
		
		public Node(int n1,int n2,double dis) {
			this.n1 = n1;
			this.n2 = n2;
			this.dis = dis;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		val = new int[N+1];
		PriorityQueue<Node> pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (o1.dis > o2.dis) ? 1: -1;
			}
		});
		int[][] xy = new int[N+1][2];
		int n1=0,n2=0;
		for(int i=1; i<N+1; i++) {
			val[i] = i;
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			xy[i][0] = n1;
			xy[i][1] = n2;
		}
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			pq1.offer(new Node(n1,n2,0.0));
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=i+1; j<N+1; j++) {
				absX = xy[i][0] - xy[j][0];
				absY = xy[i][1] - xy[j][1];
				absXY = Math.sqrt(absX*absX +absY*absY);
				pq1.offer(new Node(i,j,absXY));
			}
		}
		
		while(!pq1.isEmpty()) {
			Node e1 = pq1.poll();
			if(union(e1.n1,e1.n2)) {
				sum += e1.dis;
			}
		}
		
		System.out.println(String.format("%.2f",sum));
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