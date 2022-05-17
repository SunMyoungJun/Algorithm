import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] val;
	static PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[2] == o2[2]) {
				if(o1[0]==o2[0]) {
					return o1[1] > o2[1] ? 1: -1;
				}
				return o1[0] > o2[0] ? 1: -1;
			}
			return o1[2] < o2[2] ? 1: -1;
		}
	});
	static PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[2] == o2[2]) {
				if(o1[0]==o2[0]) {
					return o1[1] > o2[1] ? 1: -1;
				}
				return o1[0] > o2[0] ? 1: -1;
			}
			return o1[2] > o2[2] ? 1: -1;
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		val = new int[2][N+1];
		
		
		for(int i=0; i<N+1; i++) {
			val[0][i]=i;
			val[1][i]=i;
		}
		
		
		int n1=0,n2=0,C=0;
		int cnt1=0,cnt2=0;
		while(M-- !=-1) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			pq1.offer(new int[] {n1,n2,C});
			pq2.offer(new int[] {n1,n2,C});
		}
		
		int[] p1;
		int result1=0,result2=0;
		while(!pq1.isEmpty()) {
			p1 = pq1.poll();
			if(union(p1[0],p1[1],0)) {
				cnt1++;
				if(p1[2] == 0) {
					result1++;
				}
				if(cnt1 == N) {
					break;
				}
			}
		}
		while(!pq2.isEmpty()) {
			p1 = pq2.poll();
			if(union(p1[0],p1[1],1)) {
				cnt2++;
				if(p1[2] == 0) {
					result2++;
				}
				if(cnt2 == N)  {
					break;
				}
			}
		}
		result1 = (int)Math.pow(result1,2);
		result2 = (int)Math.pow(result2,2);
		System.out.println(result2-result1);
	}
	
	static int findSet(int num,int idx) {
		if(val[idx][num] == num) {
			return num;
		}
		return val[idx][num] = findSet(val[idx][num],idx);
	}
	
	static boolean union(int n1,int n2,int idx) {
		n1 = findSet(n1,idx);
		n2 = findSet(n2,idx);
		if(n1 == n2) {
			return false;
		}
		val[idx][n1] = n2;
		return true;
	}
}