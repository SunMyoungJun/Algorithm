import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int idx1=0,idx2=0;
		int cnt =0;
		
		Queue<String> q1 = new LinkedList<String>();
		Queue<String> q2 = new LinkedList<String>();
		TreeMap<String,Integer> map1 = new TreeMap<>();
		TreeMap<String,Integer> map2 = new TreeMap<>();
		
		
		for(int i=0; i<N; i++) {
			String a1 = br.readLine();
			q1.offer(a1);
			map1.put(a1,1);
		}
		for(int i=0; i<N; i++) {
			String a2 = br.readLine();
			q2.offer(a2);
			map2.put(a2,1);
		}
		
		String s1 = q1.poll();
		String s2 = q2.poll();
		
		
		while(q2.size()!=0) {
			
			if(s1.equals(s2)) {
				map1.remove(s1);
				map2.remove(s2);
				
				while(true) {
					s1 = q1.poll();
					
					if(map1.get(s1) != null) {
						break;
					}
				}
				
				s2 = q2.poll();
			}
			
			else {
				cnt++;
				map1.remove(s2);
				map2.remove(s2);
				s2 = q2.poll();
			}
		}
		System.out.println(cnt);
		
	}

}
