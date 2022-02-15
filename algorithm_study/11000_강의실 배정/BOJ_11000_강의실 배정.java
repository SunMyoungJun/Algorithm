import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000강의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int s=0,t=0,cnt=0,size=0,start=0,end=0;
		int[] num;

		PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return (o1[1] > o2[1]) ? 1: -1;
				}
				return (o1[0] > o2[0]) ? 1: -1;
			}
		});
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			pq1.offer(new int[] {s,t});
		}
		
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();
		
		pq2.offer(pq1.poll()[1]);
		
		
		while(!pq1.isEmpty()) {
			int[] p1  = pq1.poll();
			
			
			if(pq2.peek() <= p1[0]) {
				pq2.poll();
			}
			pq2.offer(p1[1]);
		}
		System.out.println(pq2.size());
	}

}
