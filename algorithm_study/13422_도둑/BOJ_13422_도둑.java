import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx=0,cnt=0,sum=0;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		while(T-- !=0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N];
			idx=0; cnt=0;sum=0;
			Queue<Integer> q1 = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
				if(i<M) {
					q1.offer(map[i]);
					sum+=map[i];
				}
			}
			if(sum < K) {
				cnt++;
			}

			idx=M;
			if(N!=M) {
				while(idx%N != (M-1)) {
					sum = sum - q1.poll() + map[idx%N];
					q1.offer(map[idx%N]);

					if(sum < K) {
						cnt++;
					}
					idx++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}