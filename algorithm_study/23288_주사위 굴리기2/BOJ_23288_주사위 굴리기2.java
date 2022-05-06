import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = {0,6,2,3,4,5,1};
	static int N,M,K,start=6,dir,r,c,sum,max;
	static int[][] map;
	static int[][] dis;
	static boolean[][] check;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dis = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(K-- !=0) {
			move();
			plusScore();
			chooseDir();
		}
		
		System.out.println(sum);
	}
	
	
	static void chooseDir() {
		int A = arr[1];
		int B = map[r][c];
		
		if(A>B) {
			dir = (dir+1)%4;
		}
		else if(A<B) {
			dir -=1;
			dir = (dir<0) ? 3 : dir;
		}
	}
	static void plusScore() {
		int B = map[r][c];
		int C=0;
		max=1;
		check = new boolean[N][M];
		
		
		if(dis[r][c]>0) {
			C = dis[r][c];
		}
		else {
			dis[r][c] = bfs()+1;
			C = dis[r][c];
		}
		sum += B*C;
	}
	
	static int bfs() {
		Queue<int[]> q1 = new LinkedList<>();
		check = new boolean[N][M];
		check[r][c] = true;
		q1.offer(new int[] {r,c});
		int[] p1;
		int tx=0,ty=0,cnt=0;
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			
			for(int d=0; d<4; d++) {
				tx= p1[0]+dx[d];
				ty = p1[1]+dy[d];
				
				if(tx<0 || tx>=N || ty<0 || ty>=M || check[tx][ty]) {
					continue;
				}
				if(map[p1[0]][p1[1]] != map[tx][ty]) {
					continue;
				}
				check[tx][ty] = true;
				q1.offer(new int[] {tx,ty});
				cnt++;
			}
		}
		return cnt;
	}
	
	static void move() {
		int tx = r + dx[dir];
		int ty = c + dy[dir];
		if(tx<0 || tx>=N || ty<0 || ty>=M) {
			dir = (dir+2)%4;
			tx = r+dx[dir];
			ty = c+dy[dir];
		}
		int n1=arr[1],n2=arr[2],n3=arr[3],n4=arr[4],n5=arr[5],n6=arr[6];
		
		if(dir ==0) {
			arr[1] = n3; arr[2] = n2; arr[3] = n6;
			arr[4] = n1; arr[5] = n5; arr[6] = n4;
		}
		else if(dir ==1) {
			arr[1] = n5; arr[2] = n1; arr[3] = n3;
			arr[4] = n4; arr[5] = n6; arr[6] = n2;
		}
		else if(dir ==2) {
			arr[1] = n4; arr[2] = n2; arr[3] = n1;
			arr[4] = n6; arr[5] = n5; arr[6] = n3;
		}
		else if(dir ==3) {
			arr[1] = n2; arr[2] = n6; arr[3] = n3;
			arr[4] = n4; arr[5] = n1; arr[6] = n5;
		}
		r = tx;
		c = ty;
	}
}