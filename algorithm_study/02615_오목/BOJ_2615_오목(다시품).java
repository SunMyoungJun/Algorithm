import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] dx = {-1,0,1,1};  //오른위 , 오른, 오른밑, 밑
	static int[] dy = {1,1,1,0};
	static int[][] mat = new int[20][20];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i=1;i<20;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<20;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean tf =false;
		int tx=0,ty=0;
		for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				if(mat[i][j]==1) {
					for(int k=0;k<4;k++) {
						if(dfs(1,i,j,1,k)) {   //검은알 ,시작 행,열,바둑알 개수,탐색 방향
							tx = i-dx[k];
							ty = j-dy[k];

							if(!(tx >0 && ty>0 && tx<20 && ty<20 && mat[tx][ty]==1)) {
								System.out.println("1");
								System.out.println(i+" "+j);
								return;
							}
						}
					}
				}
				else if(mat[i][j]==2) {
					for(int k=0;k<4;k++) {
						if(dfs(2,i,j,1,k)) {   //흰알 ,시작 행,열,바둑알 개수,탐색 방향
							tx = i-dx[k];
							ty = j-dy[k];

							if(!(tx >0 && ty>0 && tx<20 && ty<20 && mat[tx][ty] ==2)) {
								System.out.println("2");
								System.out.println(i+" "+j);
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("0");
	}

	static boolean dfs(int w, int row,int col, int cnt,int dir) {

 		if(cnt == 6) {
			return false;
		}


		int tx=0,ty=0;

		tx = row+dx[dir];
		ty = col+dy[dir];

		if((tx <=0 || tx >=20 || ty<=0 || ty >=20) && cnt!=5) {
			return false;
		}
		if((tx <=0 || tx >=20 || ty<=0 || ty >=20) && cnt==5)
			return true;
		if(mat[tx][ty] !=w) {
			if(cnt ==5) {
				return true;
			}
			return false;
		}
		return dfs(w,tx,ty,cnt+1,dir);
	}
}