import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,sum;
	static int[][] mat;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		mat = new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) 
				mat[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(1,2,0); // dir : 0 -> 가로// 1-> 대각선 // 2->세로
		System.out.println(sum);
	}

	static void dfs(int row,int col,int dir) {
		if(row ==N && col ==N) {
			sum++;
			return;
		}
		
		if(dir!=2 && !(col+1 ==N+1 || mat[row][col+1] ==1)) //가로
			dfs(row,col+1,0);
				
		if(dir !=0 && !(row+1 ==N+1 || mat[row+1][col] ==1))  //세로
			dfs(row+1,col,2);
			
		if(!(row+1 ==N+1 || col+1 == N+1 || mat[row+1][col+1] ==1
				|| mat[row][col+1] ==1 || mat[row+1][col]==1))  //대각선
			dfs(row+1,col+1,1);
	}
}