import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static char[][] mat = new char[12][6];
	static boolean[][] check;
	static boolean[][] check2;
	static boolean[][] check3;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int CNT;
	static boolean tf,tf2;
	public static void main(String[] args) throws IOException {
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<12;i++) {
			s = br.readLine();
			for(int j=0; j<6; j++) {
				mat[i][j] = s.charAt(j);
			}
		}
		int count =0;
		int MAX = Integer.MIN_VALUE;
		 tf2 =false;
		while(true)   {//나중에 멈춤 조건 주자
			check = new boolean[12][6];
			check3 = new boolean[12][6];
			CNT=1;
			for(int i=0;i<12;i++) {
				for(int j=0; j<6;j++) {
					if(mat[i][j] !='.' && check[i][j] ==false && check3[i][j] ==false ) {
						CNT=1;
						check2 = new boolean[12][6];
						check2[i][j] = true;
						check3[i][j] = true;
						tf = false;
						check[i][j] = true;
						dfs(mat[i][j],i,j);
						if(tf == false)
							check[i][j] = false; //이거는 dfs나와서 true할지 fasle할지 결정해야함.
						tf =false;
					}
				}
			}
			
			if(tf2 == false) {
				break; 
			}
			else {
				tf2 = false;
				count++;
			}
				
			for(int i=0; i<12;i++) {
				for(int j=0; j<6; j++) {
					if(check[i][j] == true) {
						for(int k=i; k>0;k--) {
							mat[k][j] = mat[k-1][j];
						}
						mat[0][j] = '.';
					}
				}
			}
		}
		
		System.out.println(count);
		
	}

	static void dfs(char alpa,int row,int col) {
		int tx=0,ty=0;
		for(int i=0;i<4;i++) {
			tx = row +dx[i];
			ty = col + dy[i];
			
			if(tx <0 || tx >=12 || ty <0 || ty >=6 || check2[tx][ty] ==true)
				continue;
			if(mat[tx][ty] == alpa) {
				check2[tx][ty] = true;
				check3[tx][ty] = true;
				CNT++;
				dfs(alpa,tx,ty);
				if(tf == true) {
					check[row][col] = true;
				}
			}
		}
		
		if(CNT >=4) {
			tf = true;
			tf2 = true;
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(check2[i][j] == true) {
						check[i][j] =true;
					}
				}
			}
		}
	}





}
