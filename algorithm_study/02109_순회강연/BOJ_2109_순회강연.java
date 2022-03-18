import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int p=0,d=0,sum=0;
		StringTokenizer st = null;
		int[][] arr1 = new int[n][2];
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? 1: -1;
			}
		});
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			arr1[i][0] = p;
			arr1[i][1] = d;
		}
		Arrays.sort(arr1,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] < o2[0] ? 1: -1;
				}
				return o1[1] > o2[1] ? 1: -1;
			}
		});
		
		for(int i=0; i<n; i++) {
			p = arr1[i][0];
			d = arr1[i][1];
			if(pq1.size() >=d && pq1.peek() < p) {
				sum -= pq1.poll();
				pq1.offer(p);
				sum+=p;
			}
			else if(pq1.size() <d) {
				pq1.offer(p);
				sum+=p;
			}
		}
		System.out.println(sum);
	}
}