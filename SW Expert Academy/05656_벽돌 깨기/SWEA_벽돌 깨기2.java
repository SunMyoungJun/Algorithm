package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656벽돌깨기 {
	static int T,N,W,H,min;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st =null;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<T+1; i++) {
			st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];

			for(int j=0; j<H; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<W; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			

			min = Integer.MAX_VALUE;
			
			dfs(0,map);
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}

		System.out.println(sb.toString());





	}

	static void dfs(int cnt,int[][] map) {
		if(cnt == N) {
			int sum=0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] >0) {
						sum++;
					}
				}
			}
			min = Math.min(min, sum);
			return;
		}


		int[][] temp = arrayCopy(map);

		for(int i=0; i<W; i++) {
			choose(temp,i);
			move(temp);
			dfs(cnt+1,temp);
			temp = arrayCopy(map);
		}
	}

	static void move(int[][] temp) {
		boolean flag= false;
		int idx=0;
		for(int j=0;j<W;j++) {
			flag =false; idx=0;
			for(int i=H-1; i>=0; i--) {
				if(!flag && temp[i][j] ==0) {
					flag = true;
					idx=i;
				}
				else if(flag && temp[i][j]>0) {
					temp[idx][j] = temp[i][j];
					temp[i][j]=0;
					idx--;
				}
			}
			if(flag) {
				temp[0][j] = 0;
			}
		}
	}



	static void choose(int[][] temp, int idx) {

		boolean[][] check = new boolean[H][W];
		Queue<int[]> q1 = new LinkedList<>();

		for(int i=0; i<H; i++) {
			if(temp[i][idx] !=0) {
				check[i][idx] = true;
				q1.offer(new int[] {i,idx});
				break;
			}
		}

		int[] p1;
		int n=0,tx=0,ty=0;
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			n = temp[p1[0]][p1[1]];

			for(int d=0; d<4; d++) {
				tx=p1[0]; ty=p1[1];
				for(int i=1; i<n; i++) {
					tx = tx+dx[d];
					ty = ty+dy[d];


					if(tx<0 || tx>=H || ty<0 || ty>=W || check[tx][ty]) {
						continue;
					}

					check[tx][ty] = true;
					if(temp[tx][ty] >1) {
						q1.offer(new int[] {tx,ty});
					}

				}
			}
		}



		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(check[i][j]) {
					temp[i][j] = 0;
				}
			}
		}
	}



	static int[][] arrayCopy(int[][] map) {
		int[][] temp = new int[H][W];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				temp[i][j] = map[i][j];
			}
		}


		return temp;

	}




}
