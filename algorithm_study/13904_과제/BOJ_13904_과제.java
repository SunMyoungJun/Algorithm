package year2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13904과제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int d=0,s=0,cnt=1,min=101,sum=0;
		PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return (o2[1] < o2[1]) ? 1:- 1;
				}
				else {
					return (o1[0] > o2[0]) ? 1: -1;
				}
			}
		});
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			pq1.offer(new int[] {d,s});
			
		}
		int[] p1 = pq1.poll();
		pq2.offer(p1[1]);
		sum = p1[1];
		while(!pq1.isEmpty()) {
			p1 = pq1.poll();
			
			if(p1[0] > pq2.size()) {
				pq2.offer(p1[1]);
				sum += p1[1];
			}
			else if(p1[1] > pq2.peek()) {
				sum -= pq2.poll();
				pq2.offer(p1[1]);
				sum += p1[1];
			}
		}
		
		System.out.println(sum);
		
	}

}
