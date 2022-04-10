import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w,h;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] map;
	static boolean[][] check;
	static boolean[][] check2;
	static Queue<int[]> q1;
	static Queue<int[]> q2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		int tx=0,ty=0,size=0,cnt=0;
		boolean flag= false;
		int[] p1;
		while(test-- !=0) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			cnt=0;
			flag= false;
			q1 = new LinkedList<>();
			q2 = new LinkedList<>();
			map = new char[h][w];
			check = new boolean[h][w];
			check2 = new boolean[h][w];
			for(int i=0; i<h; i++) {
				String s = br.readLine();
				for(int j=0; j<w; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='@') {
						q1.offer(new int[] {i,j});
						check2[i][j] = true;
					}
					else if(map[i][j]=='*') {
						q2.offer(new int[] {i,j});
						check[i][j] = true;
					}
				}
			}

			while(true) {
				size = q2.size();
				for(int i=0; i<size; i++) {
					p1 = q2.poll();
					for(int d=0; d<4; d++) {
						tx = p1[0]+dx[d];
						ty =p1[1]+dy[d];
						
						if(tx<0 ||tx>=h || ty<0 || ty>=w || check[tx][ty] || map[tx][ty] =='#') {
							continue;
						}
						check[tx][ty] = true;
						map[tx][ty] = '*';
						q2.offer(new int[] {tx,ty});
					}
				}

				size = q1.size();
				if(size==0) {
					sb.append("IMPOSSIBLE").append("\n");
					break;
				}
				for(int i=0; i<size; i++) {
					p1 = q1.poll();
					for(int d=0; d<4; d++) {
						tx = p1[0]+dx[d];
						ty = p1[1]+dy[d];

						if(tx<0 || tx>=h || ty<0 || ty>=w) {
							flag=true;
							break;
						}
						else if(check2[tx][ty] || map[tx][ty] =='#' || map[tx][ty]=='*') {
							continue;
						}
						check2[tx][ty] = true;
						q1.offer(new int[] {tx,ty});
					}
				}
				cnt++;
				if(flag) {
					sb.append(cnt).append("\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}