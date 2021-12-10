import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M;
	static int sr,sc,er,ec;
	static int[][] map;
	static int[][][] check;
	static class Node {
		int x;
		int y;
		int distance;
		int cnt;
		
		public Node(int x,int y,int distance,int cnt)  {
			this.x = x;
			this.y=y;
			this.distance=distance;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Node> q1 = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken())-1;
		sc = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		er = Integer.parseInt(st.nextToken())-1;
		ec = Integer.parseInt(st.nextToken())-1;
		map = new int[N][M];
		check = new int[N][M][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				check[i][j][0] = 1000001;
				check[i][j][1] = 1000001;
			}
		}
		
		
		q1.offer(new Node(sr,sc,0,0));
		boolean flag = false;
		while(!q1.isEmpty()) {
			Node e1 = q1.poll();
			int tx=0,ty=0;
			
			
			if(e1.x == er && e1.y == ec) {
				System.out.println(e1.distance);
				flag = true;
				break;
			}
			
			
			for(int d=0; d<4; d++) {
				tx = e1.x +dx[d];
				ty = e1.y + dy[d];
				if(tx<0 || ty<0 || tx>=N || ty>=M) {
					continue;
				}
				
				
				if(map[tx][ty] == 0) {
					if(check[tx][ty][e1.cnt] <= e1.distance+1) {
						continue;
					}
					check[tx][ty][e1.cnt]= e1.distance+1;
					q1.offer(new Node(tx,ty,check[tx][ty][e1.cnt],e1.cnt));
				}
				else {
					if(e1.cnt ==1) {
						continue;
					}
					else {
						if(check[tx][ty][1] <= e1.distance+1) {
							continue;
						}
						check[tx][ty][1] = e1.distance+1;
						q1.offer(new Node(tx,ty,check[tx][ty][e1.cnt+1],e1.cnt+1));
					}
					
				}
				
			
				
			}
			
		}
 		
		
		if(!flag) {
			System.out.println("-1");
		}
	}

}