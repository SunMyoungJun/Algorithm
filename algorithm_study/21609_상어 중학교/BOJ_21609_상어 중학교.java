import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,MAX,R,C,giR,giC,score,maxrainbow;
	static boolean[][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		while(true) {
			maxrainbow=0;
			R=0; C=0; MAX=1; giR=-1; giC=-1;
			check = new boolean[N+1][N+1];
			for(int i=1; i<N+1; i++) {
				for(int j=1 ; j<N+1; j++) {
					if(check[i][j] == true || map[i][j] ==0 || map[i][j] == -1 || map[i][j] == -2) {
						continue;
					}
					check[i][j] = true;
					bfs(i,j);
				}
			}
			
			if(MAX == 1) {
				break;
			}
			
			minusBlock(giR,giC);
			junluck();
			
			rotate();
			junluck();
			
			
		}
		
		System.out.println(score);
		
	}
	
	
	static void rotate() {
		int[][] map2 = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				map[i][j] = map2[j][N-i+1];
			}
		}
		
		
		
	}
	
	
	static void junluck() {
		int cnt=0;
		for(int i=1; i<N+1; i++) {
			for(int j=N-1; j>0; j--) {
				if(map[j][i] == -1 || map[j][i] == -2) {
					continue;
				}
				cnt=0;
			
				for(int z=j+1; z<N+1; z++) {
					if(map[z][i] == -2) {
						cnt++;
					}
					else {
						break;
					}
				}
				if(cnt >0) {
					map[j+cnt][i] = map[j][i];
					map[j][i] = -2;
				}
			
			}
		}
		
		
		
	}
	
	
	static void minusBlock(int r,int c) {
		Queue<int[]> q1 = new LinkedList<>();
		q1.offer(new int[] {r,c});
		int[] p1;
		int tx=0,ty=0,cnt=1;
		int num = map[r][c];
		map[r][c] = -2;
		
		while(!q1.isEmpty()) {
			p1 = q1.poll();

			for(int d=0; d<4; d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];

				if(tx<=0 || tx>N || ty<=0 || ty>N || map[tx][ty] == -1 || map[tx][ty] == -2) {
					continue;
				}
				
				if(map[tx][ty] != num && map[tx][ty] !=0) {
					continue;
				}
				map[tx][ty] = -2;
				cnt++;
				q1.offer(new int[] {tx,ty});
			}
		}
		
		score = score + cnt*cnt;
		
	}
	
	
	static void bfs(int r, int c) {
		Queue<int[]> q1 = new LinkedList<>();
		q1.offer(new int[] {r,c});
		boolean[][] check2 = new boolean[N+1][N+1];
		check2[r][c] = true;
		int[] p1;
		int tx=0,ty=0,cnt=1;
		int num = map[r][c];
		int rr=r,cc=c;
		int rainbow=0;
		while(!q1.isEmpty()) {
			p1 = q1.poll();

			for(int d=0; d<4; d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];

				if(tx<=0 || tx>N || ty<=0 || ty>N || check2[tx][ty] == true || map[tx][ty] == -1 || map[tx][ty] == -2) {
					continue;
				}
				
				if(map[tx][ty] != num && map[tx][ty] !=0) {
					continue;
				}
				if(map[tx][ty] == 0) {
					rainbow++;
				}
				if(map[tx][ty] >0) {
					if(rr == tx) {
						if(cc > ty) {
							rr = tx;
							cc = ty;
						}
					}
					else if(rr > tx) {
						rr = tx;
						cc = ty;
					}
				}
						
				cnt++;
				check2[tx][ty] = true;
				q1.offer(new int[] {tx,ty});
			}
		}

		if(MAX == cnt) {
			if(rainbow > maxrainbow) {
				R = rr;
				C = cc;
				giR = r;
				giC = c;
				maxrainbow = rainbow;
			}
			
			
			else if(rainbow == maxrainbow) {
				if(rr == R) {
					if(cc > C) {
						R = rr;
						C = cc;
						giR = r;
						giC = c;
						maxrainbow = rainbow;
					}
				}
				else if(rr > R) {
					R = rr;
					C = cc;
					giR = r;
					giC = c;
					maxrainbow = rainbow;
				}
			}
			
			
			
			
		}
		else if(MAX < cnt) {
			R = rr;
			C = cc;
			giR = r;
			giC = c;
			MAX = cnt;
			maxrainbow = rainbow;
		}
		
	}

}
