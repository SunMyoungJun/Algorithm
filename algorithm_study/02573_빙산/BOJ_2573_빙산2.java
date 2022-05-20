import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int[][] check;
	static boolean[][] check2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time=1;
		boolean flag=false;
		while(true) {
			check = new int[N][M];
			ice();
			int n = isTwo();
			if(n==1){
				break;
			}
			else if(n==0) {
				flag=true;
				break;
			}
			time++;
		}
		
		if(flag) {
			System.out.println("0");
		}
		else {
			System.out.println(time);
		}
	}
	
	static void bfs(int r,int c) {
		Queue<int[]> q1 = new LinkedList<>();
		q1.offer(new int[] {r,c});
		check2[r][c] =true;
		int tx=0,ty=0;
		int[] p1;
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			
			for(int d=0; d<4; d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];
				
				if(tx<0 || tx>=N || ty<0 || ty>=M || check2[tx][ty] || map[tx][ty]==0) {
					continue;
				}
				check2[tx][ty] =true;
				q1.offer(new int [] {tx,ty});
			}
		}
	}
	
	static int isTwo() {
		check2 = new boolean[N][M];
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] ==0 || check2[i][j]) {
					continue;
				}
				bfs(i,j);
				cnt++;
				if(cnt>=2) {
					return 1;
				}
			}
		}
		if(cnt==0) {
			return 0;
		}
		return -1;
	}
	
	static void ice() {
		
		int tx=0,ty=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M;j++) {
				if(map[i][j]>0) {
					for(int d=0; d<4; d++) {
						tx = i+dx[d];
						ty = j+dy[d];
						if(tx<0 || tx>=N || ty<0 || ty>=M || map[tx][ty]>0) {
							continue;
						}
						check[i][j]++;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					continue;
				}
				map[i][j] -= check[i][j];
				map[i][j] = (map[i][j]<0) ? 0 : map[i][j];
			}
		}
	}
}