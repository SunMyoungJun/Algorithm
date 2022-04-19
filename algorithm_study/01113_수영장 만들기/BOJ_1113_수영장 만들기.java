import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int sum;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int[] number;
	static boolean[][] check;
	static int num;
	public static void main(String[] args) throws IOException	 {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		number = new int[10];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
				number[map[i][j]]++;
			}
		}
		
		
		for(int i=1; i<9; i++) {
			if(number[i]==0) {
				continue;
			}
			check = new boolean[N][M];
			for(int j=1; j<N-1; j++) {
				for(int k=1; k<M-1; k++) {
					if(map[j][k] ==i && !check[j][k]) {
						check[j][k] = true;
						bfs(j,k,i);

					}
				}
			}
		}
		
		
		System.out.println(sum);
		
		

	}
	static void bfs(int r,int c,int n1) {
		Queue<int[]> q1 = new LinkedList<>();
		int[] p1;
		int num=0,tx=0,ty=0;
		int max=10;
		q1.offer(new int[] {r,c});
		boolean[][] check2 = new boolean[N][M];
		check2[r][c] = true;
		
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			
			for(int d=0; d<4; d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];
				
				if(tx<0 || tx>=N || ty<0 || ty>=M) {
					if(map[p1[0]][p1[1]] <=n1) {
						max=0;
					}
					continue;
				}
				if(check[tx][ty]) {
					continue;
				}
				
				if(n1 == map[tx][ty]) {
					check[tx][ty] = true;
					check2[tx][ty] = true;
					q1.offer(new int[] {tx,ty});
					continue;
				}
				
				if(map[tx][ty] < n1) {
					max=0;
				}
				
				
				if(n1 < map[tx][ty]) {
					max = Math.min(max, map[tx][ty]);
				}
			}
		}
		
		if(max==0) {
			return;
		}
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				if(check2[i][j]) {
					sum = sum + (max-map[i][j]);
					map[i][j] = max;
				}
			}
		}
		return;
	}
}
