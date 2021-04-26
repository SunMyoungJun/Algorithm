package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution{
	static int N,size,MIN;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static Character[][] map;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());

		for(int t=1; t<test+1; t++) {
			N = Integer.parseInt(br.readLine());
			map = new Character[N][N];
			check = new boolean[N][N];
			String s;
			MIN=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				s = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == '.') {
						eightcheck(i,j);
					}
				}
			}
			int count=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] =='0' && check[i][j] == false) {
						check[i][j] = true;
						dfs(i,j);
						count++;
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] !='*' && check[i][j] == false) {
						count++;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(count).append("\n");
			
		}
		System.out.println(sb.toString());
	}	
	
	static void dfs(int row,int col) {
		int tx=0,ty=0;
		for(int d=0; d<8;d++) {
			tx = row + dx[d];
			ty = col + dy[d];
			
			if(tx<0 || tx>=N || ty<0 || ty>=N || check[tx][ty] == true) {
				continue;
			}
			if(map[tx][ty] == '*') {
				continue;
			}
			if(map[tx][ty] == '0') {
				check[tx][ty] = true;
				dfs(tx,ty);
			}
			
			if(map[tx][ty] !='0' && map[tx][ty] !='*') {
				check[tx][ty] = true;
			}
		}
		
	}
	
	
	
	static void eightcheck(int row,int col) {
		int tx=0,ty=0;
		int cnt =0;
		for(int d=0;d<8;d++) {
			tx = row + dx[d];
			ty = col + dy[d];
			
			if(tx<0 || tx>=N || ty<0 || ty>=N) {
				continue;
			}
			
			if(map[tx][ty] == '*') {
				cnt++;
			}
		}
		
		map[row][col] = (char)(cnt+'0');
		
	}
}










