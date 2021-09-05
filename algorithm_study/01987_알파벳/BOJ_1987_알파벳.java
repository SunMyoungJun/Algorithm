import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] alpa;
	static boolean[][] check1;
	static boolean[] check2;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int MAX = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpa = new char[R][C];
		check1 = new boolean[R][C];
		check2 = new boolean[26];
		String s;
		for(int i=0;i<R;i++) {
			s = br.readLine();
			for(int j=0;j<C;j++) {
				alpa[i][j] = s.charAt(j);
			}
		}
		check1[0][0] = true;
		check2[alpa[0][0] -65] = true;
		dfs(0,0,0);
		System.out.println(MAX+1);
	}
	
	static void dfs(int row,int col,int cnt) {
		int tx=0,ty=0;
		for(int i=0;i<4;i++) {
			tx = row + dx[i];
			ty = col + dy[i];
			if(tx <0 || tx >=R || ty<0 || ty >=C || check1[tx][ty] ==true || check2[alpa[tx][ty]-65]==true)
				continue;
			
			check1[tx][ty] = true;
			check2[alpa[tx][ty]-65] = true;
			dfs(tx,ty,cnt+1);
			check2[alpa[tx][ty]-65] = false;		
			check1[tx][ty] = false;
		}
		MAX = (MAX > cnt) ? MAX : cnt;
	}
}