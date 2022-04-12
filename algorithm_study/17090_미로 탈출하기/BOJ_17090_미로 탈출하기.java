import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static char[][] map;
	static boolean[][] check1;
	static boolean[][] check2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		check1 = new boolean[N][M];
		check2 = new boolean[N][M];
		int sum=0;
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!check1[i][j]) {
					check1[i][j] = true;
					check2[i][j] = dfs(i,j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(check2[i][j]) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
	
	static boolean dfs(int r,int c) {
		int tx=r,ty=c;
		if(map[r][c] =='U') {
			tx--;
		}
		else if(map[r][c] =='R') {
			ty++;
		}
		else if(map[r][c] =='D') {
			tx++;
		}
		else {
			ty--;
		}
		
		if(tx<0 || tx>=N || ty<0 || ty>=M) {
			return true;
		}
		
		if(check1[tx][ty]) {
			return check2[tx][ty];
		}
		
		check1[tx][ty] = true;
		return check2[tx][ty] = dfs(tx,ty);
	}
}