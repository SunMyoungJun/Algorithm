import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Character[][] check1;
	static int R,C,N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<int[]> q1 = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		check1 = new Character[R][C];
		String s;
		for(int i=0;i<R;i++) {
			s = br.readLine();
			for(int j=0;j<C;j++) {
				check1[i][j] = s.charAt(j);  
			}
		}
		int cnt=0;
		while(cnt != N+1) {
			if(cnt<2) {  //2초 이하까진 그대로 
				cnt++;
				continue;
			}
			bfs(cnt);
			cnt++;
		}

		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(check1[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void bfs(int cnt) {
		if(cnt%2==0) {  //map전부 폭탄으로 채우기
			bombFill();
		}
		else {  // 3초지난 폭탄들 기준 4방위 폭발
			explode();
		}
	}	

	static void bombFill() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(check1[i][j] == 'O') { //모두 폭탄으로 채울때 원래 폭탄이엿던 놈들은 큐에 저장.
					q1.offer(new int[] {i,j});
				}
				check1[i][j] ='O';
			}
		}
	}
	
	static void explode() {
		int tx=0,ty=0;
		int[] p1;

		while(!q1.isEmpty()) {
			p1 = q1.poll();
			check1[p1[0]][p1[1]] = '.';
			for(int i=0;i<4;i++) {
				tx = p1[0] + dx[i];
				ty = p1[1] + dy[i];
				if(tx<0 || tx>=R || ty<0 || ty>=C) {
					continue;
				}
				check1[tx][ty] = '.';
			}
		}
	}
}