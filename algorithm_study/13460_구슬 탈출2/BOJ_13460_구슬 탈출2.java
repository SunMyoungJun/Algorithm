import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int min=Integer.MAX_VALUE;
	static int redX,redY,blueX,blueY;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String s;

		map = new char[N][M];
		for(int i=0; i<N; i++) {
			s = br.readLine();
			for(int j=0; j<M; j++) {	
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'R') {
					map[i][j] = '.';
					redX=i;
					redY=j;
				}
				else if(map[i][j]=='B') {
					map[i][j]='.';
					blueX=i;
					blueY=j;
				}
			}
		}
		dfs(redX,redY,blueX,blueY,1,-1); // 각 좌표 , 몇번 , 직전 방향
		min = (min==Integer.MAX_VALUE) ? -1 : min;
		System.out.println(min);
	}


	static void dfs(int x1,int y1,int x2,int y2,int cnt, int prevDir) {

		if(cnt>10) { // 10번 이상은 어짜피 -1 출력
			return;
		}

		int tx1=0,ty1=0,tx2=0,ty2=0;
		boolean flag1=false,flag2=false;
		for(int d=0; d<4; d++) {
			if(prevDir ==(d+2)%4 || prevDir ==d) {
				continue;
			}
			tx1 = x1;
			ty1 = y1;
			tx2 = x2;
			ty2 = y2;

			if(map[tx1+dx[d]][ty1+dy[d]]=='#' && map[tx2+dx[d]][ty2+dy[d]]=='#') {
				continue;
			}

			while(map[tx1+dx[d]][ty1+dy[d]] !='#') {
				tx1 = tx1 + dx[d];
				ty1 = ty1 + dy[d];
				if(map[tx1][ty1] =='O') {
					flag1 = true;
					break;
				}
			}
			while(map[tx2+dx[d]][ty2+dy[d]] != '#') {
				tx2 = tx2 + dx[d];
				ty2 = ty2 + dy[d];
				if(map[tx2][ty2] =='O') {
					flag2 = true;
					break;
				}
			}
			if(flag2) {
				flag1=false;
				flag2 = false;
				continue;
			}
			if(flag1) {
				min = Math.min(min,cnt);
				return;
			}
			
			
			if(tx1 == tx2 && ty1 ==ty2) { // 위치 곂침
				if(d==0) {
					if(x1 < x2) {
						tx2 = tx2 -dx[d];
						ty2 = ty2 - dy[d];
					}
					else {
						tx1 = tx1 - dx[d];
						ty1 = ty1 - dy[d];
					}
				}
				if(d==1) {
					if(y1 > y2) {
						tx2 = tx2 -dx[d];
						ty2 = ty2 - dy[d];
					}
					else {
						tx1 = tx1 - dx[d];
						ty1 = ty1 - dy[d];
					}
				}
				if(d==2) {
					if(x1 > x2) {
						tx2 = tx2 -dx[d];
						ty2 = ty2 - dy[d];
					}
					else {
						tx1 = tx1 - dx[d];
						ty1 = ty1 - dy[d];
					}
				}
				if(d==3) {
					if(y1 < y2) {
						tx2 = tx2 -dx[d];
						ty2 = ty2 - dy[d];
					}
					else {
						tx1 = tx1 - dx[d];
						ty1 = ty1 - dy[d];
					}
				}
			}
			
			if(x1==tx1 && y1==ty1 && x2==tx2 && y2==ty2) {
				continue;
			}
			dfs(tx1,ty1,tx2,ty2,cnt+1,d);
		}
	}
}