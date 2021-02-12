import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int M,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		
		while(test -- !=0) {
			int count=0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			check = new int[N][M];
			int K = Integer.parseInt(st.nextToken());
			int col=0,row=0;
			while(K -- !=0) {
				st = new StringTokenizer(br.readLine());
				col = Integer.parseInt(st.nextToken());
				row = Integer.parseInt(st.nextToken());
				check[row][col] = 1;
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(check[i][j] ==1) {
						count++;
						dfs(i,j);
					}
				}
			}
			System.out.println(count);
		}

	}
	
	static void dfs(int row,int col) {
		check[row][col] = 2;
		int tx=0,ty=0;
		
		for(int i=0;i<4;i++) {
			tx = row + dx[i];
			ty = col +dy[i];
			if(tx <0 || tx >=N || ty <0 || ty >= M) {
				continue;
			}
			if(check[tx][ty] ==1)
				dfs(tx,ty);
		}
	}
}
