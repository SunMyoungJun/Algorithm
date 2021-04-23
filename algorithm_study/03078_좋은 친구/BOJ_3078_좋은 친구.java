import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Queue<Integer> q1 = new LinkedList<>();
		TreeMap<Integer,Integer> map = new TreeMap<>();
		String s;
		int len = 0;
		long cnt = 0;
		int n1=0;
		for(int i=0;i<N;i++) {
			s = br.readLine();
			len = s.length();
			if(i<=K) {
				q1.offer(len);  
				if(map.containsKey(len)) { 
					cnt+= map.get(len);
					map.put(len, map.get(len)+1);
				}
				else {
					map.put(len, 1);
				}
				continue;
			}
			
			int num1 = q1.poll();

			if(map.get(num1) >1) {
				map.put(num1, map.get(num1) -1);
			}
			else {
				map.remove(num1);
			}
			
			q1.offer(len);  
			if(map.containsKey(len)) { 
				cnt+= map.get(len);
				map.put(len, map.get(len)+1);
			}
			else {
				map.put(len, 1);
			}
			
			
		}
		
		System.out.println(cnt);

	}

}
