import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,count;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map1,map2;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map1 = new int[N][M];
		map2 = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				map1[i][j] =Integer.parseInt(st.nextToken());
				if(map1[i][j] >0) {
					count++;
				}
			}
		}
		
		int cnt=0;
		while(true) {
			map2 = arrayCopy(map1);
			if(!checking()) {
				break;
			}
			melt();
			if(count ==0) {
				cnt=0;
				break;
			}
			map1 = arrayCopy(map2);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	
	
	
	static int[][] arrayCopy(int[][] map1) {
		
		int[][] map3 = new int[N][M];
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<M;j++) {
				map3[i][j] = map1[i][j];
			}
		}
		return map3;
		
		
	}
	
	static void melt() {
		
		int cnt=0,tx=0,ty=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				cnt=0;
				if(map1[i][j] >0) {
					for(int d=0; d<4; d++) {
						tx = i + dx[d];
						ty = j + dy[d];
						
						if(tx<0 || tx>=N || ty<0 || ty>=M || map1[tx][ty] >0) {
							continue;
						}
						cnt++;
					}
					
					if(map1[i][j] - cnt <=0) {
						map2[i][j] = 0;
						count--;
					}
					else {
						map2[i][j] -=cnt;
					}
				}
			}
		}
	}
	
	
	static void bfs(int r, int c) {
		Queue<int[]> q1 = new LinkedList<>();
		int tx=0,ty=0;
		
		q1.offer(new int[] {r,c});
		
		
		while(!q1.isEmpty()) {
			int[] p1 = q1.poll();
			
			for(int d=0; d<4; d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];
				
				if(tx<0 || tx>=N || ty<0 || ty>=M || check[tx][ty] || map2[tx][ty] ==0) {
					continue;
				}
				check[tx][ty] = true;
				q1.offer(new int[] {tx,ty});
			}
		}
		
		
		
	}
	
	static boolean checking() {
		check = new boolean[N][M];
		boolean flag=false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!flag && !check[i][j] && map2[i][j] >0) {
					check[i][j] = true;
					bfs(i,j);
					flag = true;
				}
				else if(flag && !check[i][j] && map2[i][j] >0) {
					return false;
				}
			}
		}
		return true;
	}

}
