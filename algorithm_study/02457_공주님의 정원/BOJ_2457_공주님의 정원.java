import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int s1=0,e1=0,s2=0,e2=0,max=0,cnt=0,end=60;
		int[] days = {0,31,59,90,120,151,181,212,243,273,304,334,365};
		int[][] map =new int[N][2];
		int[] p1;
		
		PriorityQueue<int[]> pq1 = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] < o2[1] ? 1: -1;
				}
				return o1[0] > o2[0] ? 1: -1;
			}
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			s1 =Integer.parseInt(st.nextToken());
			e1 =Integer.parseInt(st.nextToken());
			s2 =Integer.parseInt(st.nextToken());
			e2 =Integer.parseInt(st.nextToken());
			s1 = days[s1-1] + e1;
			s2 = days[s2-1] + e2;
			pq1.offer(new int[] {s1,s2});
		}
		
		while(!pq1.isEmpty()) {
			p1 = pq1.peek();
			if(p1[0] <= end) { // 연속 심을 수 있냐?
				max = Math.max(max, p1[1]);
				pq1.poll();
			}
			else {
				cnt++;
				if(max==0) {
					System.out.println("0");
					return;
				}
				end = max;
				if(end >334) {
					break;
				}
				max=0;
			}
		}
		if(max > end && max >334) {
			cnt++;
		}
		else if(end <=334) {
			cnt=0;
		}	
		System.out.println(cnt);
	}
}