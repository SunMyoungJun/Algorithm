import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,M,cnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		String s="";
		for(int i=0;i<N; i++) {
			s = br.readLine();
			for(int j=0;j<M;j++) {
				if(s.charAt(j) =='U') {
					map[i][j] = 0;
				}
				else if(s.charAt(j)=='R') {
					map[i][j] = 1;
				}
				else if(s.charAt(j)=='D') {
					map[i][j] = 2;
				}
				else {
					map[i][j] = 3;
				}
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(check[i][j] == 0) {
					rotate(i,j);
				}			}
		}
		
		System.out.println(cnt);
	}
	static void rotate(int r,int c) {
		int tx=r,ty=c;
		int dir = 0;
		
		
		while(check[tx][ty] == 0) {
			check[tx][ty] = -1;
			dir = map[tx][ty];
			tx = tx + dx[dir];
			ty = ty + dy[dir];
		}
		
		
		if(check[tx][ty] == -1) {
			trueInput(r,c);
		}
		
		else if(check[tx][ty] >0) {
			falseInput(r,c);
		}	
	}
	
	static void trueInput(int r,int c) {
		int tx=r,ty=c;
		int dir = 0;
		cnt++;
		
		while(check[tx][ty] == -1) {
			check[tx][ty] = cnt;
			dir = map[tx][ty];
			tx = tx + dx[dir];
			ty = ty + dy[dir];
		}	
	}
	
	static void falseInput(int r,int c) {
		int tx=r,ty=c;
		int dir = 0;
		
		while(check[tx][ty] == -1) {
			check[tx][ty] = cnt;
			dir = map[tx][ty];
			tx = tx + dx[dir];
			ty = ty + dy[dir];
		}	
	}
}
