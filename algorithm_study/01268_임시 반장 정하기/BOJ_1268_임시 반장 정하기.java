import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		boolean[][] check = new boolean[N+1][N+1];
		int[][] map = new int[N+1][6];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<6;j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
 		}
		for(int i=1; i<6; i++) {
			for(int j=1; j<N+1; j++) {
				for(int k=j+1; k<N+1; k++) {
					if(map[j][i] == map[k][i]) 
						check[j][k] = check[k][j] = true;
				}
			}
		}
		int maxCnt=0,minIdx=1;
		for(int i=1; i<N+1; i++) {
			int cnt=0,idx=0;
			for(int j=1; j<N+1; j++) {
				if(check[i][j]) 
					cnt++;
			}
			if(maxCnt < cnt) {
				maxCnt = cnt;
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	}
}