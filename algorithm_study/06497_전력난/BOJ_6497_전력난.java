import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int m,n;
	static int[] val;
	static class Node {
		int x;
		int y;
		int distance;
		public Node(int x,int y,int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Node> pq1;
		StringBuilder sb = new StringBuilder();
		int x=0,y=0,z=0,sum=0,total=0,result=0,cnt=0;
		Node e1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			sum=0; total=0;
			result = m-1;
			cnt=0;
			if(m ==0 && n ==0) {
				break;
			}
			
			val = new int[m];
			for(int i=0; i<m; i++) {
				val[i] = i;
			}
			
			
			pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return (o1.distance > o2.distance) ? 1: -1;
				}

			});

			for(int i=0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				z = Integer.parseInt(st.nextToken());
				pq1.offer(new Node(x,y,z));
				total += z;
				
			}
			
			while(!pq1.isEmpty()) {
				e1 = pq1.poll();
				if(union(e1.x,e1.y)) {
					sum += e1.distance;
					cnt++;
					if(cnt == result) {
						break;
					}
				}
			}
			
			sb.append(total-sum).append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	static int findSet(int n) {
		if(val[n] == n) {
			return n;
		}
		return val[n] = findSet(val[n]);
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
