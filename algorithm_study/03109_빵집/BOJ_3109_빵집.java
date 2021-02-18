import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static char[][] mat;
	static int[] dx = {-1,0,1};
	static int R,C,tx,ty;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mat = new char[R][C];
		String s;
		for(int i=0;i<R;i++) {
			s = br.readLine();
			for(int j=0;j<C;j++) {
				mat[i][j] = s.charAt(j);
			}
		}
		boolean tf =false;
		for(int i=0;i<R;i++)
			tf = dfs(i,0);	
		System.out.println(cnt);
	}
	
	static boolean dfs(int row,int col) {
		if(col == C-1) {
			cnt++;
			return true;
		}
	
			for(int i=0;i<3;i++) {
				tx = row+dx[i];
				ty = col+1;
				if(tx <0 || tx >=R ||mat[tx][ty] == 'x')
					continue;

				mat[tx][ty] ='x';
				if(dfs(tx,ty)) {
					return true;
				}
			}
		return false;
	}
}