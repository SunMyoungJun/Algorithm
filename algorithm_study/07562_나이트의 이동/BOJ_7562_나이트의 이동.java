import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	static boolean[][] check;
	static int L,sr,sc,er,ec,cnt;
	static int[] p1;
	static Queue<int[]> q1 = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		while(test-- !=0) {
			cnt =0;
			L = Integer.parseInt(br.readLine());
			check = new boolean[L][L];
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());  //시작 행
			sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());  // 도착 행
			ec = Integer.parseInt(st.nextToken());

			q1.offer(new int[] {sr,sc});
			bfs();
			System.out.println(cnt);

		}


	}



	static void bfs() {
		int tx=0,ty=0;
		int size =0;
		while(!q1.isEmpty()) {
			size = q1.size();

			while(size -- !=0) {
				p1 = q1.poll();	

				if(p1[0] == er && p1[1] == ec) {
					q1.clear();
					return;
				}
				for(int i=0;i<8;i++) {
					tx = p1[0] + dx[i];
					ty = p1[1] + dy[i];

					if(tx <0 || tx >=L || ty<0 || ty>=L || check[tx][ty] ==true) {
						continue;
					}

					check[tx][ty] = true;
					q1.offer(new int[] {tx,ty});

				}
			}
			cnt++;
		}



	}
}
