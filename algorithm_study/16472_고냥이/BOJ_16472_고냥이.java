import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpa = new int[27];
		Queue<Character> q1 = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		int count=0;
		String s = br.readLine();
		
		int size = s.length();
		int result = 0;
		
		char temp1,temp2;
		for(int i=0; i<size; i++) {
			char temp = s.charAt(i);
	
			if(alpa[temp-'a'] ==0) { // 추가해야할때
				if(count <N) {
					count++;
				}
				else {
					while(true) {
						temp2 = q1.poll();
						alpa[temp2-'a']--;
						if(alpa[temp2-'a'] == 0) {
							break;
						}
					}
					
				}
			}
			q1.offer(temp);
			alpa[temp-'a']++;
			result = Math.max(result, q1.size());
		}
		
		System.out.println(result);
		
		
		
	}

}
