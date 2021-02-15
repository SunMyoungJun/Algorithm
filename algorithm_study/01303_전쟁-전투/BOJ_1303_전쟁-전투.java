import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{   ///BFS로 풀어보자
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M,Wscore,Bscore;
	static char[][] mat;
	static boolean[][] check;
	static Queue<int[]> q1 = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat  = new char[M][N];
		check  = new boolean[M][N];
		String s;
		for(int i=0; i< M; i++) {
			s = br.readLine();
			for(int j=0; j<N;j++) {
				mat[i][j] =  s.charAt(j);
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0;j<N;j++) {
				if(check[i][j] == false && mat[i][j] =='W') {
					check[i][j] = true;
					q1.offer(new int[] {i,j});
					bfs('W');
				}
				else if(check[i][j] == false && mat[i][j] =='B') {
					check[i][j] = true;
					q1.offer(new int[] {i,j});
					bfs('B');
				}
			}
		}
		System.out.println(Wscore+" "+Bscore);
	}
	
	static void bfs(char WB) {
		int[] temp;
		int cnt=1;
		int tx,ty;
		while(!q1.isEmpty()) {
			temp = q1.poll();
			
			for(int i=0;i<4;i++) {
				tx = temp[0] + dx[i];
				ty = temp[1] + dy[i];
				
				if(tx <0 || tx >=M || ty<0 || ty >=N || check[tx][ty] == true || mat[tx][ty] != WB)
					continue;
				
				check[tx][ty] = true;
				q1.offer(new int[] {tx,ty});
				cnt++;
			}
		}
		if(WB =='W') {
			Wscore += cnt *cnt;
		}
		else
			Bscore += cnt*cnt;
		
		
	}
}