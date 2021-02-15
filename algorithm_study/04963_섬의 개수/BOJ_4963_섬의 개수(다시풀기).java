import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M,N;
	static int[][] mat;
	static boolean[][] check;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int count;
		while(true) {
			count =0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(M ==0 && N==0)
				break;
			check = new boolean[N][M];
			mat = new int[N][M];
				
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(mat[i][j] ==1) {
						count++;
						dfs(i,j);
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void dfs(int row,int col) {
		int tx,ty;

		for(int i=0; i<8;i++) {
			tx = row + dx[i];
			ty = col + dy[i];
			if(tx<0 || tx >=N || ty <0 || ty >=M || mat[tx][ty] !=1  ) 
				continue;
			
			mat[tx][ty] =2;  //의미없는수로 초기화
			dfs(tx,ty);
		}
	}
}