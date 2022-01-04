import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static PriorityQueue<Node> pq1;
	static int[] val;
	static class Node {
		int n1;
		int n2;
		double dis;
		
		public Node(int n1, int n2, double dis) {
			this.n1 = n1;
			this.n2 = n2;
			this.dis = dis;
		}
	}
	public static void main(String[] args) throws IOException {
//		System.out.println(Math.sqrt(2));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		val = new int[n];
		double[][] in = new double[n][2];
		for(int i=0; i<n; i++) {
			val[i] = i;
			st = new StringTokenizer(br.readLine());
			in[i][0] = Double.parseDouble(st.nextToken());
			in[i][1] = Double.parseDouble(st.nextToken());
		}
		
		pq1 = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (o1.dis > o2.dis) ? 1: -1;
			}
		});
		
		double x1=0,x2=0,y1=0,y2=0;
		double r1=0,r2=0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				x1 = in[i][0];
				y1 = in[i][1];
				x2 = in[j][0];
				y2 = in[j][1];
				
				r1 = Math.abs(x1-x2);
				r2 = Math.abs(y1-y2);
				pq1.offer(new Node(i,j,Math.sqrt(r1*r1 + r2*r2)));
			}
		}
		
		double sum=0;
		
		
		while(!pq1.isEmpty()) {
			Node e1 = pq1.poll();
			
			
			
			if(union(e1.n1,e1.n2)) {
				sum +=e1.dis;
			}
			
		}
		
		System.out.printf("%.2f",sum);
	
	
	}
	
	static int findSet(int num) {
		
		if(val[num] == num) {
			return num;
		}
		
		return val[num] = findSet(val[num]);
		
		
	}
	
	
	
	static boolean union(int n1,int n2) {
		n1 = findSet(n1);
		n2 = findSet(n2);
		
		if(n1 == n2) {
			return false;
		}
		
		val[n1] = n2;
		return true;
		
		
	}
	
	

}
