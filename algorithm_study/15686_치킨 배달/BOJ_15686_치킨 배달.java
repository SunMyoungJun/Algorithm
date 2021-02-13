import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static int[][] mat;
	static int N,M;
	static int MIN = Integer.MAX_VALUE;
	static ArrayList<chicken> arr1 = new ArrayList<>();
	static class chicken{
		int x,y;

		public chicken(int x,int y) {
			this.x = x;
			this.y =y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		dfs(0,0,0);
		System.out.println(MIN);

	}

	static void dfs(int cnt,int startrow, int startcol) {
		if(cnt == M) {
			compare();
			return;
		}

		for(int i=startrow;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(startrow == i && j <startcol)
					continue;
				if(mat[i][j] ==2) {
					arr1.add(new chicken(i,j));
					if(j !=N-1)
						dfs(cnt+1,i,j+1);
					else
						dfs(cnt+1,i+1,0);
					arr1.remove(arr1.size()-1);
				}
			}
		}

	}


	static void compare() {
		int tsum =0;
		int tmin=Integer.MAX_VALUE;
		int tx=0,ty=0,txy=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(mat[i][j] ==1) {
					for(int k=0;k<arr1.size();k++) {
						tx = arr1.get(k).x;
						ty = arr1.get(k).y;
						txy = Math.abs(tx-i) + Math.abs(ty-j);
						tmin = (tmin < txy) ? tmin : txy;
					}
					tsum = tsum +tmin;
					if(tsum > MIN)
						return;
					tmin = Integer.MAX_VALUE;
				}

			}
		}
		MIN = (MIN < tsum) ? MIN : tsum;
	}
}
