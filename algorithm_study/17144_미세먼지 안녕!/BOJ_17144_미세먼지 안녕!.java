import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M,T,high,low;
	static int[][] map;
	static Queue<dust> q1 = new LinkedList<dust>();
	static class dust {
		int x,y,dust;

		public dust(int x, int y, int dust) {
			this.x = x;
			this.y = y;
			this.dust = dust;
		}


	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int temp =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				temp = Integer.parseInt(st.nextToken());

				if(temp >0) {
					q1.offer(new dust(i,j,temp));
				}
				else if(temp ==-1) {
					if(high ==0) {
						high = i;  //위 
					}
					else {
						low = i;
					}
				}
			}
		}

//		map[high][0] = -1;
//		map[low][0] = -1;
		while(T-- !=0) {
			
			move();
			moveHigh();
			moveLow(); 
			
			if(T>=1) {
				queueAdd();
			}
		}
		
		int sum =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
		
	}
	
	private static void queueAdd() {
		q1.clear();	
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] >0) {
					q1.offer(new dust(i,j,map[i][j]));
				}
				map[i][j] =0;
			}
		}
	}

	private static void moveLow() {
		int temp = 0,temp2 =0,ttemp=0;
		temp = map[low][M-1];
		for(int j=M-1;j>=1;j--)
			map[low][j] = map[low][j-1];
		
		temp2 = map[N-1][M-1];
		for(int i=N-1;i>=low+2;i--) {
			map[i][M-1] = map[i-1][M-1];
		}
		map[low+1][M-1] = temp;
		
		ttemp = map[N-1][0];
		for(int j=0;j<M-1;j++) {
			map[N-1][j] = map[N-1][j+1];
		}
		map[N-1][M-2] = temp2;

		for(int i=low;i<N-1;i++) {
			map[i][0] = map[i+1][0];
		}
		map[N-2][0] = ttemp;
		map[low][0] = 0;
	}
	private static void moveHigh() {

		int temp = 0,temp2 =0,ttemp=0;
		temp = map[high][M-1];
		for(int j=M-1;j>=1;j--)
			map[high][j] = map[high][j-1];
		
		temp2 = map[0][M-1];
		for(int i=0;i<high-1;i++) {
			map[i][M-1] = map[i+1][M-1];
		}
		map[high-1][M-1] = temp;
		
		ttemp = map[0][0];
		for(int j=0;j<M-1;j++) {
			map[0][j] = map[0][j+1];
		}
		map[0][M-2] = temp2; 

		for(int i=high-1;i>=1;i--) {
			map[i][0] = map[i-1][0];
		}
		map[1][0] = ttemp;
		



	}
	static void move() {
		dust p1;
		int tx=0,ty=0;
		while(!q1.isEmpty()) {
			int cnt=0;
			p1 = q1.poll();

			for(int d=0;d<4;d++) {
				tx = p1.x + dx[d];
				ty = p1.y + dy[d];

				if(tx<0 || tx>=N || ty<0 || ty>=M) {
					continue;              
				}
				else if((tx ==high && ty ==0) || (tx ==low && ty ==0)) {
					continue;
				}
				cnt++;
				map[tx][ty] += p1.dust/5; 
			}	 
			map[p1.x][p1.y] += p1.dust - (p1.dust/5) * cnt; 
		}

	}

}
