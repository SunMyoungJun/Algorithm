import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][][] mat;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int MIN = Integer.MAX_VALUE;
	static Queue<gamer> q1 = new LinkedList<gamer>();
	static class gamer{
		int x,y,wall;

		public gamer(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat = new int[M][N][2];   // 0 : 벽인지 아닌지    1 :현재 위치에서 부순 최소 벽수 
		String s;
		for(int i=0;i<M;i++) {
			s = br.readLine();
			for(int j=0;j<N;j++) {
				mat[i][j][0] = (int)s.charAt(j) -48;
				mat[i][j][1] = 10002; //최대값 넣어두기
			}
		}
		q1.offer(new gamer(0,0,0));

		bfs();
		System.out.println(MIN);
	}
	static void bfs() {
		int size =0;
		int tx=0,ty=0,twall=0;
		gamer gm;
		while(!q1.isEmpty()) {
			size = q1.size();

			for(int i=0;i<size;i++) {
				gm = q1.poll();
				
				if(gm.x ==M-1 && gm.y ==N-1)
					MIN = (MIN <gm.wall) ? MIN : gm.wall;
				
				for(int j=0;j<4;j++) {
					tx = gm.x + dx[j];
					ty = gm.y + dy[j];
					twall = gm.wall;
					if(tx <0 || tx >=M || ty<0 || ty>=N)
						continue;

					if(mat[tx][ty][0] ==1) 
						twall +=1;

					if(mat[tx][ty][1] <= twall)
						continue;
					
					mat[tx][ty][1] = twall;
					q1.offer(new gamer(tx,ty,twall));
				}
			}
		}
	}
}