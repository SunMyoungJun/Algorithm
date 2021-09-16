import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,cnt,rx,ry,rv;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][][] check;
	static Character[][] map;
	static Queue<int[]> q1 = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Character[N][M];
		check = new int[N][M][1 << 6];  /// 3,4 a열쇠랑 c열쇠랑 

		String s;
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0')  { //시작점일떄
					q1.offer(new int[] {i,j,0});
					check[i][j][0] = 1;
				}
			}
		}
		
		
		if(bfs()) {
			System.out.println(check[rx][ry][rv]);
		}
		else {
			System.out.println("-1");
		}
	}
	
	static boolean bfs() {
		int tx=0,ty=0,key=0,size=0;
		int[] p1;

		while(!q1.isEmpty()) {
			
 			size = q1.size();		
			for(int t=0; t<size; t++) {
				p1 = q1.poll();		
				
				for(int d=0; d<4;d++) {
					tx = p1[0] + dx[d];
					ty = p1[1] + dy[d];
					key = p1[2]; 
					
					
					
					
					if(tx<0 || tx>=N || ty<0 || ty>=M || map[tx][ty] == '#') {
						continue;
					}
					
					
					if(map[tx][ty] =='1') {
						rx = p1[0];
						ry = p1[1];
						rv = p1[2];
						return true;
					}
					
					if(check[tx][ty][key] !=0) { // 이미 가지고 잇으면서 해당 자리로 왔을 때
						continue;
					}
				
					if(map[tx][ty]-'a' >=0 && map[tx][ty]-'a' <=6) { //열쇠 일 때 
						key = (key | (1 << (map[tx][ty]-'a')));
					}
					else if(map[tx][ty] -'A' >=0 && map[tx][ty] -'A' <=6) { //문 일 때
						if((key & (1 << (map[tx][ty]-'A'))) ==0 ) { //해당 열쇠를 가지고 있지 않다면
							continue;
						}
					}
					
					q1.offer(new int[] {tx,ty,key});
					check[tx][ty][key] = check[p1[0]][p1[1]][p1[2]] +1;
				}
			}
		}
		return false;
	}
}
