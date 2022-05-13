import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,startX,startY,sum;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[][] dx2 = {{-1,1,-1,1,-1,1,-2,2,0,0},{1,1,0,0,-1,-1,0,0,2,1},{-1,1,-1,1,-1,1,-2,2,0,0},{-1,-1,0,0,1,1,0,0,-2,-1}};
	static int[][] dy2 = {{-1,-1,0,0,1,1,0,0,-2,-1},{-1,1,-1,1,-1,1,-2,2,0,0},{1,1,0,0,-1,-1,0,0,2,1},{-1,1,-1,1,-1,1,-2,2,0,0}};
	static int[] moks = {10,10,7,7,1,1,2,2,5};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int d=0,n1=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		startX=N/2; startY=N/2;
		a:for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<=i; k++) {	
					startX = startX + dx[d];
					startY = startY + dy[d];
					if(startX==0 && startY ==-1) {
						break a;
					}
					n1 = map[startX][startY];
					if(n1==0) {
						continue;
					}
					move(n1,d);
				}
				d=(d+1)%4;
			}
		}
		System.out.println(sum);
	}

	static void move(int num,int d) {
		int tx=0,ty=0,garbage=0;
		int mok=0,localSum=0;
		for(int i=0; i<9; i++) {
			tx = startX + dx2[d][i];
			ty = startY + dy2[d][i];

			mok = (num * moks[i])/100;
			localSum +=mok;
			if(tx<0 || tx>=N || ty<0 || ty>=N) {
				sum += mok;
				continue;
			}
			map[tx][ty] += mok;
		}
		tx = startX + (dx2[d][9]);
		ty = startY + (dy2[d][9]);
	
		garbage = num-localSum;
		if(tx<0 || tx>=N || ty<0 || ty>=N) {
			sum += garbage;
		}
		else {
			map[tx][ty] += garbage;
		}
		map[startX][startY]=0;
	}
}