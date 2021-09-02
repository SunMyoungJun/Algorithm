import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] mat;
	static int[][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<int[]> q1 = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] mat = new int[N][M];
		int[][] check;
		int cheeze=0;
		for(int i =0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j] ==1) {
					cheeze++;
				}
			}
		}
		
		int cnt=0,size=0,tx=0,ty=0;
		int esc =0;
		int[] p1;
		while(esc != cheeze) {
			check = new int[N][M];
			check[0][0] = 1;
			q1.offer(new int[] {0,0});
 			while(!q1.isEmpty()) {
				size = q1.size();
				p1 = q1.poll(); 
				
				for(int i=0;i<4;i++) {
					tx = p1[0] +dx[i];
					ty = p1[1] + dy[i];			
					
					if(tx<0 || tx >=N || ty<0 || ty>=M) {
						continue;
					}
					
					else if(mat[tx][ty] ==0 && check[tx][ty] ==1) {  //치즈 자리아닌데 방문했다면
						continue;
					}
					else if(mat[tx][ty] ==1) {
						check[tx][ty]++;
						continue;
					}
					check[tx][ty]++;
					q1.offer(new int[] {tx,ty});	
				}
			}
			cnt++;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(check[i][j] >=2) {
						mat[i][j] = 0;
						esc++;
					}
				}
			}		
		}
		System.out.println(cnt);
	}
}