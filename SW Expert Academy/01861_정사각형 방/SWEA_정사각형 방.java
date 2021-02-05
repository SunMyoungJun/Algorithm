package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_정사각형방 {
	static int N,SUM=1,MAX;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] check;
	static  int[][] room;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		
		for(int t =1; t<test+1;t++){
			int x=0,y=0;
			MAX = Integer.MIN_VALUE;
			 N = Integer.parseInt(br.readLine());
			 room = new int[N][N];
			 int minroom=Integer.MAX_VALUE;
			 for(int i=0;i<N;i++) {
				 st = new StringTokenizer(br.readLine());
				 for(int j=0;j<N;j++) {
					 room[i][j] = Integer.parseInt(st.nextToken());
				 }
			 }
			 
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++){
					check = new boolean[N][N];
					dfs(i,j);
					if(MAX<SUM){
						MAX = SUM;
						minroom = room[i][j];
					}
					else if(MAX ==SUM) {
						if(minroom > room[i][j]) {
							x=i; y=j;
							minroom = room[i][j];
						}			
					}
					SUM=1;
				}
			}
			
			System.out.println("#"+t+" "+minroom+" "+MAX);
		}
	}
	
	static void dfs(int row,int col) {
		check[row][col] = true;
		int troom=0;
		for(int i=0;i<4;i++) {
			if(row+dx[i] >=0 && row+dx[i] <N && col+dy[i] >=0 && col+dy[i] <N && check[row+dx[i]][col+dy[i]]==false) {
				troom= room[row+dx[i]][col+dy[i]];
				if(troom == room[row][col]+1) {
					SUM++;
					dfs(row+dx[i],col+dy[i]);
				}
			}
		}
	}
}
