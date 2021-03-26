import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int N=0,M=0,W=0,S=0,E=0,T=0;
		int[][] map;
		while(test -- !=0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int[N+1][N+1];
			
				for(int i=1;i<N+1;i++) {
					for(int j=1;j<N+1;j++) 
						map[i][j] = Integer.MAX_VALUE >>1;
				}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				map[S][E] = Math.min(map[S][E], T);
				map[E][S] = Math.min(map[E][S], T);
			}
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				map[S][E] = Math.min(map[S][E], -T);

			}
			
			for(int k=1;k<N+1;k++) {
				for(int i=1;i<N+1;i++) {
					for(int j=1;j<N+1;j++) {
						if(i ==k && k ==j && i ==j) {
							continue;
						}
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for(int i=1;i<N+1;i++) {
				min = Math.min(min, map[i][i]);
				if(min <0)
					break;
			}
			
			if(min <0)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}
}