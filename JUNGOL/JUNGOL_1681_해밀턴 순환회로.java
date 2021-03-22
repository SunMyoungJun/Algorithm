import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visited;
	static int[][] map;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		map = new int[N][N];	
		StringTokenizer st=null;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0] = true;
		dfs(0,0,0);
		System.out.println(MIN);
	}
	
	
	static void dfs(int cnt,int idx,int sum) {
		int S=0;
		if(cnt == N-1) {
			if( map[idx][0] !=0) {
				S = sum + map[idx][0];
				MIN = (MIN < S) ? MIN : S;
			}
			return;
		}
		
		
		
		if(MIN < sum) {
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(i !=idx && !visited[i] && map[idx][i] !=0) {
				visited[i] = true;
				dfs(cnt+1,i,sum+map[idx][i]);
				visited[i] = false;
			}
			
			
		}
		
		
		
		
	}

}
