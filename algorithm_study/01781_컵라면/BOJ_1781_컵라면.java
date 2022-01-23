package year2022;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1781컵라면 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<int[]> pq1 = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return (o1[1] < o2[1]) ? 1: -1;
				}
				return (o1[0] > o2[0]) ? 1: -1;
			}
		});

		PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return (o1[0] < o2[0]) ? 1: -1;
				}
				return (o1[1] > o2[1]) ? 1: -1;
			}
		});


		StringTokenizer st =null;
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N+1];
		int n1=0,n2=0;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());

			pq1.offer(new int[] {n1,n2});
		}

		int start =0,sum=0,temp=0;

		while(!pq1.isEmpty()) {
			int[] p1 = pq1.poll();

			if(result[p1[0]] ==0) {
				start++;
				result[start] = p1[1];
				p1[0] = start;
				pq2.offer(p1);
			}

			else if(start == p1[0]) { // 딱 맞을 때
				int[] p2 = pq2.poll();
				if(p2[1] < p1[1]) {
					result[p2[0]] = p1[1];
					p1[0] = p2[0];
					pq2.offer(p1);
				}
				else {
					pq2.offer(p2);
				}
   			}

		}


		for(int i=1; i<N+1; i++) {

			sum += result[i];
		}


		System.out.println(sum);
	}

}








