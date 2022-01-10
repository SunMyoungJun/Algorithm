import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static boolean[] check;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		int[] arr1 = new int[N+1];
		check = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			arr1[i] =i;
		}
		
		dfs(0);
		System.out.println(sb.toString());
		
	}

	
	
	static void dfs(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=1; i<N+1; i++) {
			if(check[i] == true) {
				continue;
			}
			check[i] = true;
			result[cnt] = i;
			dfs(cnt+1);
			check[i] = false;
		}
		
	}
}
