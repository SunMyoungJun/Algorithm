import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K,W,H;
	static int[][] mat;
	static int[][] check;

	static int[] nx = {2,1,-1,-2,-2,-1,1,2};  // 체스판 나이트
	static int[] ny = {1,2,2,1,-1,-2,-2,-1};

	static int[] dx = {-1,0,1,0}; //인접 4바우이
	static int[] dy = {0,1,0,-1};
	static Queue<monkey> q1 = new LinkedList<monkey>();
	static class monkey {
		int x,y,k,sec;

		public monkey(int x,int y,int k,int sec) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.sec = sec;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		mat = new int[H][W];
		check = new int[H][W];

		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				check[i][j] = -2;
			}
		}

		q1.offer(new monkey(0,0,K,0));
		check[0][0] = Integer.MAX_VALUE;
		bfs();
	}

	static void bfs() {
		monkey mk;
		int tx=0,ty=0;

		while(!q1.isEmpty()) {
			mk = q1.poll();

			if(mk.x == H-1 && mk.y == W-1) {
				System.out.println(mk.sec);
				return;
			}	

			int tempk=0;
			
			if(mk.k !=0) {
				for(int i=0; i<8;i++) {
					tx = mk.x + nx[i];
					ty = mk.y + ny[i];	
					tempk = mk.k-1;
					if(tx <0 || tx>=H || ty<0 || ty>=W || check[tx][ty] >= tempk || mat[tx][ty] ==1) {
						continue;
					}

					check[tx][ty] = tempk;
					q1.offer(new monkey(tx,ty,mk.k-1,mk.sec+1));
				}
			}
			
			for(int i=0; i<4;i++) {
				tx = mk.x + dx[i];
				ty = mk.y + dy[i];
				tempk = mk.k;
				if(tx <0 || tx>=H || ty<0 || ty>=W || check[tx][ty] >= tempk || mat[tx][ty] ==1) {
					continue;
				}
				check[tx][ty] = tempk;
				q1.offer(new monkey(tx,ty,tempk,mk.sec+1));
			}
		}
		System.out.println("-1");
		return;
	}
}