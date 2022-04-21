import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M,R;
	static int[][] map;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		check = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int idx=0,tx=0,ty=0,d=0,prev=0,temp=0,cnt=0;
		int te = 1;
		while(R-- !=0) {
			idx=0;tx=0;ty=0;d=0; cnt=0;
			prev=map[0][0];
			check = new boolean[N][M];
			while(true) {
				tx = tx + dx[d];
				ty = ty + dy[d];
				if(tx<0 || ty<0 || tx>=N || ty>=M || check[tx][ty]) {
					cnt++;
					tx = tx-dx[d];
					ty = ty-dy[d];
					d++;
					if(d>3) {
						idx++;
						if(idx == N/2 || idx == M/2) {
							break;
						}
						tx=idx;
						ty=idx;
						d=0;
						prev=map[tx][ty];
					}
					continue;
				}
				temp = map[tx][ty];
				map[tx][ty] = prev;
				check[tx][ty] = true;
				prev= temp;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}