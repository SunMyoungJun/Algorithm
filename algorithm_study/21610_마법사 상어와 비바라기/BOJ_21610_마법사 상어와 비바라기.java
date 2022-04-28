import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,d,s;
	static Queue<int[]> q1 = new LinkedList<>();	
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {0,-1,-1,-1,0,1,1,1};
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q1.offer(new int[] {N-1,0});
		q1.offer(new int[] {N-1,1});
		q1.offer(new int[] {N-2,0});
		q1.offer(new int[] {N-2,1});
		
		while(M-- !=0) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken())%N;
			check = new boolean[N][N];
			moveAndPlusWater();
			copy();
			makeCloud();
		}
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum +=map[i][j];
			}
		}
		System.out.println(sum);
	}
	static void makeCloud() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]>=2 && !check[i][j]) {
					map[i][j] -=2;
					q1.offer(new int[] {i,j});
				}
			}
		}
	}
	
	static void copy() {
		int cnt=0,tx=0,ty=0;
		int[] p1;
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			cnt=0;
			for(int d=1; d<8; d=d+2) {
				tx = p1[0]+dx[d];
				ty = p1[1]+dy[d];
				
				if(tx<0 || tx>=N || ty<0 || ty>=N || map[tx][ty]==0) {
					continue;
				}
				cnt++;
			}
			map[p1[0]][p1[1]] += cnt;
		}
	}
	static void moveAndPlusWater() {
		int tx=0,ty=0,size=q1.size();
		int[] p1;
		
		for(int i=0; i<size; i++) {
			p1 =q1.poll();
			tx = p1[0]+(dx[d]*s);
			ty = p1[1]+(dy[d]*s);
			tx = (tx<0) ? (N+tx) : tx%N;
			ty = (ty<0) ? (N+ty) : ty%N;
			map[tx][ty]++;
			check[tx][ty]=true;
			q1.offer(new int[] {tx,ty});
		}
	}
}