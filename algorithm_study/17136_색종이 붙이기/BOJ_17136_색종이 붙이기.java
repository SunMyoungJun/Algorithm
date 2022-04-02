package year2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17136색종이붙이기 {
	static int[][] map = new int[10][10];
	static int[] paper = {0,5,5,5,5,5};
	static int min=26;
	static boolean[][] check = new boolean[10][10];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10 ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					N++;
				}
			}
		}
		if(N==0) {
			System.out.println("0");
			return;
		}
		dfs(0,0,0);

		if(min == 26) {
			System.out.println("-1");
			return;
		}
		System.out.println(min);

	}

	static void dfs(int row, int col,int result) {
//		if(row ==9 && col ==10) {
//			min = Math.min(min, result);
//			return;
//		}


		if(min <= result) {
			return;
		}

		if(col ==10) {
			col=0;
			row++;
			if(row ==10 && col ==0) {
				min = Math.min(min, result);
				return;
			}
		}



		if(map[row][col] ==1 && check[row][col] == false) {
			for(int k=5; k>=1; k--) {
				if(paper[k] ==0) {
					continue;
				}
				if(right(row,col,k)) {
					checking(row,col,k,true);
					paper[k]--;
					dfs(row,col+1,result+1);
					checking(row,col,k,false);
					paper[k]++;
				}

			}
		}
		else if(map[row][col] ==0 || check[row][col] == true) {
			dfs(row,col+1,result);
		}

	}




	static boolean right(int r,int c, int num) {
		int R = r+num;
		int C = c+num;
		if(R >10 || C>10) {
			return false;
		}

		for(int i=r; i<R; i++) {
			for(int j=c; j<C; j++) {
				if(check[i][j] == true || map[i][j] ==0) {
					return false;
				}
			}
		}



		return true;
	}


	static void checking(int r,int c,int num, boolean flag) {
		for(int i=r; i< r+num; i++) {
			for(int j=c; j<c+num; j++) {
				check[i][j] = flag;
			}
		}
	}

}
