import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,L,R,cnt,count,sum;
	static int[][] map;
	static int[][] map2;
	static int[][] result;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Node> q1 = new LinkedList<>();
	static class Node {
		int x;
		int y;
		int value;
		
		public Node(int x,int y,int value) {
			this.x=x;
			this.y=y;
			this.value=value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		sum = N*N;
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			cnt=1;
			map2 = new int[N][N];
			result = new int[2501][2];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map2[i][j] == 0) {
						map2[i][j] = cnt;
						result[cnt][0] += map[i][j];
						result[cnt][1]++;
						q1.offer(new Node(i,j,map[i][j]));	
						bfs();				
						cnt++;
					}
				}
			}
			
			if(sum == cnt-1) {
				break;
			}
			
			int idx=0;
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					idx = map2[i][j];
					map[i][j] = result[idx][0] / result[idx][1];
				}
			}
			
			count++;
		}
		
		System.out.println(count);
		
	
	}
	static void bfs() {
		Node e1;
		int tx=0,ty=0;
		int dif=0;
		while(!q1.isEmpty()) {
			e1 = q1.poll();
			
			
			for(int i=0; i<4; i++) {
				tx = e1.x + dx[i];
				ty = e1.y + dy[i];
				
				if(tx<0 || tx>=N || ty<0 || ty>=N) {
					continue;
				}
				dif = Math.abs(map[tx][ty] - map[e1.x][e1.y]);
				if(dif >=L && dif <= R && map2[tx][ty] ==0) {
					map2[tx][ty] = cnt;
					result[cnt][0] += map[tx][ty];
					result[cnt][1]++;
					q1.offer(new Node(tx,ty,map2[tx][ty]));
				}
				
			}
			
			
			
			
		}
		
		
		
		
	}

}
