import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,M,MAX = Integer.MIN_VALUE; 
	static int[][] mat;
	static boolean[][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		check = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				mat[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				check[i][j] = true;
				dfs(1,mat[i][j],i,j);
				check[i][j] = false;
			}
		}
		int tsum=0;
		for(int i=1; i<N; i++) {   // ㅗ 모양 하드코딩
			for(int j=1; j<M-1;j++) {
				tsum = mat[i][j]+mat[i-1][j]+mat[i][j-1]+mat[i][j+1];
				MAX = (MAX >tsum) ? MAX :tsum;
			}
		}
		
		for(int i=0;i<N-1;i++) {   // ㅜ 모양 하드코딩
			for(int j=1;j<M-1;j++) {
				tsum = mat[i][j] + mat[i+1][j]+mat[i][j-1]+mat[i][j+1];
				MAX = (MAX>tsum) ? MAX : tsum;
			}
		}
		
		for(int i=1;i<N-1;i++) {   // ㅓ 모양 하드코딩
			for(int j=1;j<M;j++) {
				tsum = mat[i][j] + mat[i][j-1]+mat[i-1][j]+mat[i+1][j];
				MAX = (MAX>tsum) ? MAX : tsum;
			}
		}
		for(int i=1;i<N-1;i++) {   // ㅏ 모양 하드코딩
			for(int j=0;j<M-1;j++) {
				tsum = mat[i][j] + mat[i][j+1]+mat[i-1][j]+mat[i+1][j];
				MAX = (MAX>tsum) ? MAX : tsum;
			}
		}
		
		System.out.println(MAX);
	}
	
	static void dfs(int cnt, int sum, int row, int col) {
		if(cnt ==4) {
			MAX = (MAX > sum) ? MAX : sum;
			return;
		}
	
		int tx=0,ty=0;
		for(int i=0;i<4;i++) {
			tx = row + dx[i];
			ty = col + dy[i];
			if(tx <0 || tx >=N || ty <0 || ty >=M || check[tx][ty] ==true) 
				continue;
			
			check[tx][ty] = true;
			dfs(cnt+1,sum+mat[tx][ty],tx,ty);
			check[tx][ty] = false;
		}
	}
}