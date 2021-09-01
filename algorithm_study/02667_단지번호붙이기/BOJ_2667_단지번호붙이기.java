import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int N,cnt;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] mat;
	static ArrayList<Integer> arr1 = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String s;
		mat = new int[N][N];
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<N;j++) {
				mat[i][j] = s.charAt(j) -48;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(mat[i][j] ==1) {
					cnt=1;
					mat[i][j] = 2;
					dfs(i,j);
					arr1.add(cnt);
				}
			}
		}
		Collections.sort(arr1);
		int size = arr1.size();
		System.out.println(size);
		for(int i=0;i<size;i++)
			System.out.println(arr1.get(i));
	}
    
	static void dfs(int r, int c) {
		int tx=0,ty=0;
		for(int i=0;i<4;i++) {
			tx = r+dx[i];
			ty = c+dy[i];
			
			if(tx<0 || tx >=N || ty<0 || ty>=N || mat[tx][ty] !=1)
				continue;
			
			mat[tx][ty] = 2;
			cnt++;
			dfs(tx,ty);
			
		}
	}
}