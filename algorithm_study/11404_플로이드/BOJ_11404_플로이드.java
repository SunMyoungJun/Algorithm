import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] map = new int[n+1][n+1];
		StringBuilder sb = new StringBuilder();
		int start_V=0,end_V=0,edge=0;
		StringTokenizer st = null;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			start_V = Integer.parseInt(st.nextToken());
			end_V = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());

			if(map[start_V][end_V] ==0 || map[start_V][end_V] > edge) {
				map[start_V][end_V] = edge;
			}
		}

		for(int k=1;k<n+1;k++) {
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<n+1;j++) {
					if(map[i][k] ==0 || map[k][j]==0 || i==j) {  //가는경로가 둘중에 한개라도 없으면 continue
						continue;
					}
					else if(map[i][j] !=0 && map[i][j] > map[i][k] + map[k][j]) { //지금 보다 빨리갈수있을 때
						map[i][j] =  map[i][k] + map[k][j];
					}
					else if(map[i][j] ==0) {  //아직 거기까지 가는 경로없을 때는 그냥 대입
						map[i][j] =  map[i][k] + map[k][j];
					}
				}
			}
		}

		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}