
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N;
	static int result=1;
	static int[][][] map;
	static class Node {
		int x;
		int y;
		int max;
		
		public Node(int x,int y,int max) {
			this.x = x;
			this.y = y;
			this.max = max;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N][2];
		Queue<Node> q1 = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		
		Node e1;
		int size=0,cnt=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {

				cnt = dfs(i,j,1);
//				map[i][j][1] = cnt;
				result = (result > map[i][j][1]) ? result : map[i][j][1];
			}
		}
		
		System.out.println(result);
	}
	
	
	static int dfs(int r,int c,int cnt) {
		
		
		int tx=0,ty=0,max=0;
		int count=0;
		for(int d=0;d<4;d++) {
			tx = r + dx[d];
			ty = c + dy[d];
			
			if(tx<0 || ty<0 || tx >=N || ty>=N || map[r][c][0] >= map[tx][ty][0]) {
				continue;
			}
			
			if(map[tx][ty][1] !=0) {
				count= map[tx][ty][1]+1;
			}
			else {
				count = dfs(tx,ty,cnt+1);
			}
			
			max = (max > count) ? max : count;
			
		}
		
		if(max ==0) {
			map[r][c][1] =1;
			return map[r][c][1]+1;
		}
		
		map[r][c][1] = max;
		return max+1;
	}
	
	
	
	
}
