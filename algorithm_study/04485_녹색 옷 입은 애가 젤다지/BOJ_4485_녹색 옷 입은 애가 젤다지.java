import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][][] map;
	static int N;
	static PriorityQueue<green> q1 = new PriorityQueue<green>(new Comparator<green>() {
		@Override
		public int compare(green o1, green o2) {
			return (o1.sum > o2.sum) ? 1: -1;
		}
	});
	static int cnt;
	static class green {
		int x,y,sum;
		public green(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		while(true) {
			cnt++;
			N = Integer.parseInt(br.readLine());	
			if(N==0) {
				break;
			}
			map = new int[N][N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j][0] = Integer.parseInt(st.nextToken());
					map[i][j][1] = Integer.MAX_VALUE;
				}
			}
			
			map[0][0][1] = map[0][0][0];
			q1.offer(new green(0,0,map[0][0][0]));
			bfs();
		}
	}
	
	static void bfs() {
		green gr;
		int tx=0,ty=0,ts=0;
		while(!q1.isEmpty()) {
			gr = q1.poll();	
			if(gr.x == N-1 && gr.y == N-1) {
				q1.clear();
				System.out.println("Problem "+cnt+": "+map[N-1][N-1][1]);
				return;
			}
			
			for(int i=0;i<4;i++) {
				tx = gr.x + dx[i];
				ty = gr.y + dy[i];			
				if(tx<0 || tx >=N || ty<0 || ty>=N) 
					continue;
				
				if( map[tx][ty][1] <= gr.sum + map[tx][ty][0])
					continue;
				
				map[tx][ty][1] = gr.sum + map[tx][ty][0];
				q1.offer(new green(tx,ty,map[tx][ty][1]));			
			}	
		}
	}
}