import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> q1 = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		boolean[][] check = new boolean[N][M];
		int size =0,cnt=1,tx=0,ty=0;
		int[] temp;
		int[][] mat = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M;j++)
				mat[i][j] = s.charAt(j)-'0';
		}
		q1.offer(new int[] {0,0});
		check[0][0] = true;
		while(!q1.isEmpty()) {
			size = q1.size();
			while(size-- !=0) {
				temp = q1.poll();
				if(temp[0] == N-1 && temp[1] == M-1) {
					System.out.println(cnt);
					return;
				}
				
				for(int d=0; d<4; d++) {
					tx = temp[0] + dx[d];
					ty = temp[1] + dy[d];
					if(tx<0 || ty<0 || tx>=N || ty>=M || check[tx][ty] == true || mat[tx][ty] == 0) 
						continue;
					check[tx][ty] = true;
					q1.offer(new int[] {tx,ty});
				}
			}
			cnt++;
		}
	}
}