import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] alpa;
	static char[] temp;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- !=0) {
			String s1 = br.readLine();
			alpa = new int[27];
			N = s1.length();
			temp = new char[N];
			for(int i=0; i<N; i++) {
				alpa[s1.charAt(i)-'a']++;
			}
			dfs(0);
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int cnt) {
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				sb.append(temp[i]);
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<26; i++) {
			if(alpa[i]>0) {
				alpa[i]--;
				temp[cnt] = (char)(i+'a');
				dfs(cnt+1);
				alpa[i]++;
			}
		}
	}
}
