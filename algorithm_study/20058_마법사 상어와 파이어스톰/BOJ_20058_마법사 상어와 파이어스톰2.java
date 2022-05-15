import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,Q,M,L,result2;
	static int[][] map;
	static boolean[][] check2;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		M = (int)Math.pow(2, N);
		map = new int[M][M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while(Q-- !=0) {
			L = Integer.parseInt(st.nextToken());
			L = (int)Math.pow(2, L);
			
			divideAndCon(0,0,M);
			minusIce();
		}
		check2 = new boolean[M][M];
		int result1=0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				result1 += map[i][j];
				if(check2[i][j] || map[i][j] ==0) {
					continue;
				}
				check2[i][j] = true;
				bfs(i,j);
			}
		}
		
		System.out.println(result1);
		System.out.println(result2);
	}
	static void bfs(int r,int c) {
		Queue<int[]> q1 = new LinkedList<>();
		
		int cnt=1,tx=0,ty=0;
		q1.offer(new int[] {r,c});
		int[] p1;
		
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			
			for(int d=0; d<4; d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];
				
				if(tx<0 || tx>=M || ty<0 || ty>=M || check2[tx][ty] || map[tx][ty]==0) {
					continue;
				}
				check2[tx][ty] =true;
				q1.offer(new int[] {tx,ty});
				cnt++;
			}
		}
		
		result2 = Math.max(result2, cnt);
		
	}
	
	
	
	static void minusIce() {
		int tx=0,ty=0;
		int cnt=0;
		boolean[][] check = new boolean[M][M];
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				cnt=0;
		
				for(int d=0; d<4; d++) {
					tx = i+dx[d];
					ty = j+dy[d];
					
					if(tx<0 || tx>=M || ty<0 || ty>=M || map[tx][ty] ==0) {
						continue;
					}
					cnt++;
				}
				if(cnt <3) {
					check[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				if(check[i][j] && map[i][j]>0) {
					map[i][j]--;
				}
			}
		}
	}
	
	static void divideAndCon(int r,int c,int m) {
		int len = m/2;
		if(m != L) {
			divideAndCon(r,c,len);
			divideAndCon(r,c+len,len);
			divideAndCon(r+len,c,len);
			divideAndCon(r+len,c+len,len);
		}
		else {
			rotate(r,c);
		}
	}

	static void rotate(int startX,int startY) {
		int[][] temp = new int[L][L];
		for(int i=0; i<L; i++) {
			for(int j=0; j<L; j++){
				temp[i][j] = map[i+startX][j+startY];
			}
		}
		
		for(int i=0; i<L;i++) {
			for(int j=0; j<L; j++) {
				map[startX+j][startY+L-1-i] = temp[i][j];
			}
		}
	}
}