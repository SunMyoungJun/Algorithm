import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static int[][] mat;
	static boolean[][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<int[]> q1 = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		check = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] t1;
		int size =0;
		int tx=0,ty=0;
		int cnt=0,cnt2=0;
		int hour=0;
		while(true) {
			cnt=0;
			for(boolean[] a : check) {
				Arrays.fill(a, false);
			}
			check[0][0] =true;
			q1.offer(new int[] {0,0});
			while(!q1.isEmpty()) {
				t1 = q1.poll();
				for(int i=0;i<4;i++) {
					tx = t1[0] +dx[i];
					ty = t1[1] +dy[i];
					
					if(tx<0 || tx>=N || ty<0 || ty >=M || check[tx][ty] ==true)
						continue;
					
					if(mat[tx][ty] == 1) {
						check[tx][ty] =true;
						mat[tx][ty] =0;
						cnt++;
						continue;
					}
					
					check[tx][ty] = true;
					q1.offer(new int[] {tx,ty});
				}
			}
			if(cnt ==0) {
				break;
			}
			hour++;
			cnt2= cnt;
		}

		System.out.println(hour);
		System.out.println(cnt2);


	}
}
