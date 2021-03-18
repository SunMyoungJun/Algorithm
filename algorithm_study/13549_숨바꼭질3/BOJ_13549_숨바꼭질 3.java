import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int N,K;
	static int[] check;
	static PriorityQueue<int[]> q1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];  //시간 작은거부터
			
			
		}
	});
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int temp = (N > K) ? N : K;
		check = new int[temp*2+1]; 
	
		for(int i=0;i<check.length;i++) {
			check[i] = 100000;
		}
		
		check[N] = 0;
		
		q1.offer(new int[] {N,0});
		bfs();
	}
	
	
	static void bfs() {
		int size=0;
		int[] p1;
		int temp=0;
		
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			
			if(p1[0] ==K) {
				System.out.println(p1[1]);
				return;
			}
			
			
			if(p1[0] *2 < check.length && (check[p1[0]*2]==100000 || check[p1[0]*2]>p1[1])) {
				check[p1[0]*2] = p1[1];
				q1.offer(new int[] {p1[0]*2,p1[1]});
			}
			
			
			if(p1[0]+1 < check.length && check[p1[0]+1] ==100000) {
				check[p1[0]+1] = p1[1]+1;
				q1.offer(new int[] {p1[0]+1,p1[1]+1});
			}
			
			if(p1[0]-1 >=0 && check[p1[0]-1] ==100000) {
				check[p1[0]-1] = p1[1]+1;
				q1.offer(new int[] {p1[0]-1,p1[1]+1});
			}
			
		}
		
		
	}

}
