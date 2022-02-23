import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,max;
	static int[][] mat;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j] == 0) {
					bfs(i,j);
				}
			}
		}
		System.out.println(max);
	}
	
	static void bfs(int r,int c) {
		Queue<int[]> q1 = new LinkedList<>();
		
		q1.offer(new int[] {r,c});
		int size=0,cnt=0,tx=0,ty=0;
		int[] p1;
		boolean[][] check = new boolean[N][M];
		check[r][c] = true;
		while(!q1.isEmpty()) {
			size = q1.size();
			for(int i=0; i<size; i++) {
				p1 = q1.poll();
				for(int d=0; d<8; d++) {
					tx = p1[0] + dx[d];
					ty = p1[1] + dy[d];
					if(tx<0 || tx>=N || ty<0 || ty>=M || check[tx][ty] == true) {
						continue;
					}
					if(mat[tx][ty] == 1) {
						max = (max > cnt+1) ? max : cnt+1;
						return;
					}
					check[tx][ty] = true;
					q1.offer(new int[] {tx,ty});
				}
			}
			cnt++;
		}
	}
}