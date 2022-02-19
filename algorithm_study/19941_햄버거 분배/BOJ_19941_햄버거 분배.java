import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = br.readLine();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt=0;
		Queue<Integer> q1 = new LinkedList<>();
		for(int i=0; i<N; i++) {
			char a = s.charAt(i);
			if(a == 'H') 
				q1.offer(i);
		}
		
		for(int i=0; i<N; i++) {
			char a = s.charAt(i);
			if(a == 'P') {
				while(!q1.isEmpty() && !(q1.peek() - i > K)) {
					int num = q1.poll();
					if(Math.abs(num-i) <=K) {
						cnt++;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}