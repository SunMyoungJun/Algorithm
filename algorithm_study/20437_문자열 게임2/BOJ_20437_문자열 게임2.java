import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] alpa = new ArrayList[27];
		
		
		
		
		while(T-- !=0) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			char one=0,beforeone=0;
			for(int i=0; i<27; i++) {
				alpa[i] = new ArrayList<Integer>();
			}
			String s = br.readLine();
			int size = s.length();
			int K = Integer.parseInt(br.readLine());
			
			
			for(int i=0; i<size; i++) {
				one = s.charAt(i);
				alpa[one-'a'].add(i);
			}
			
			
			
			for(int i=0;i<27;i++) {
				if(alpa[i].size() >=K) {
					for(int j=0; j<= alpa[i].size()-K; j++) {
						max = Math.max(max, alpa[i].get(j+K-1) - alpa[i].get(j)+1);
						min = Math.min(min, alpa[i].get(j+K-1) - alpa[i].get(j)+1);
					}
				}
			}
			
			if(max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
				sb.append("-1\n");
			}
			else {
				sb.append(min).append(" ").append(max).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
