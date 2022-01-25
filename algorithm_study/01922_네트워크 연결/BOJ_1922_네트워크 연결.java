import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int[] val;
	static class Node {
		int n1;
		int n2;
		int edge;
		
		public Node(int n1,int n2,int edge) {
			this.n1= n1;
			this.n2 = n2;
			this.edge= edge;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		val = new int[N+1];
		for(int i=1; i<N+1; i++) {
			val[i] =i;
		}
		
		PriorityQueue<Node> pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1,Node o2) {
				return (o1.edge > o2.edge) ? 1: -1;
			}
		});
		
		
		int num1=0,num2=0,edge=0,cnt=0,sum=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			
			pq1.offer(new Node(num1,num2,edge));
			
		}
		Node e1;
		while(!pq1.isEmpty()) {
			e1 = pq1.poll();
			
			if(union(e1.n1,e1.n2)) {
				sum += e1.edge;
				cnt++;
				if(cnt == N-1) {
					System.out.println(sum);
					return;
				}
			}
		}
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
		
		if(n1 ==n2) {
			return false;
		}
		
		val[n1] = n2;
		return true;
		
	}
	

}
