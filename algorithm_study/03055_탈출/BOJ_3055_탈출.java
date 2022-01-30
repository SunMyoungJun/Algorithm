import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<int[]> q1,q2;
	static char[][] map;
	static int R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		int startR=0,startC=0,endR=0,endC=0,cnt=1,size=0;
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'S') {
					startR = i;
					startC = j;
					map[i][j] = '*';
					q1.offer(new int[] {startR,startC});
				}
				else if(map[i][j] == 'D') {
					endR = i;
					endC = j;
				}
				else if(map[i][j] =='*') {
					q2.offer(new int[] {i,j});
				}
			}
		}
		
		while(!q1.isEmpty()) {
			size = q1.size();
			int tx=0,ty=0;
			int[] p1;
			plusWater();
			for(int i=0; i<size; i++) {
				p1 = q1.poll();
				for(int d=0; d<4; d++) {
					tx = p1[0] + dx[d];
					ty = p1[1] + dy[d];
					
					if(tx<0 || tx>=R || ty<0 || ty>=C) 
						continue;
					
					if(map[tx][ty] =='.') {
						map[tx][ty] = '*';
						q1.offer(new int[] {tx,ty});
					}
					else if(map[tx][ty] =='D') {
						System.out.println(cnt);
						return;
					}
				}
			}
			cnt++;
		}
		System.out.println("KAKTUS");
	}
	static void plusWater() {
		int size=q2.size();
		int[] p1;
		int tx=0,ty=0;
		for(int i=0; i<size; i++) {
			p1 = q2.poll();
			
			for(int d=0; d<4; d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];
				
				if(tx<0 || tx>=R || ty<0 || ty>=C) 
					continue;
				
				if(map[tx][ty] == '.') {
					map[tx][ty] = '*';
					q2.offer(new int[] {tx,ty});
				}
			}
		}
	}
}