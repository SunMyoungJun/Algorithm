import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1,int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] > o2[1] ? 1: -1;
				}
				return o1[0] > o2[0] ? 1: -1;
			}
		});
		
		PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1,int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] > o2[0] ? 1: -1;
				}
				return o1[1] > o2[1] ? 1: -1;
			}
		});
		int n0=0,n1=0,n2=0,cnt=1,max=1;

		while(N-- !=0) {
			st = new StringTokenizer(br.readLine());
			n0 = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			pq1.offer(new int[] {n1,n2});
		}
		int[] p1,p2;
		p1 = pq1.poll();
		pq2.offer(p1);
		while(!pq1.isEmpty()) {
			p1 = pq1.poll();
			p2 = pq2.peek();
			if(p1[0] < p2[1]) {
				cnt++;
				max = Math.max(max, cnt);
			}
			else {
				pq2.poll();
			}
			pq2.offer(p1);
		}
		System.out.println(max);
	}
}