import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,SUM=0;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[] sandrow ;
	static int[] sandcol ;
	static int[] persent = {1,1,7,7,2,2,10,10,5};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int r=N/2;
		int c=N/2;
		int dir = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int size =2*N-1;   //토네이도 횟수
		int change=0;  //방향 전환
		int len=1;  //화살표 길이

		for(int i=0;i<size;i++) {
			if(change ==2) {
				change=0;
				len++;
			}

			for(int j=0;j<len;j++) {
				r = r+dx[dir];
				c = c+dy[dir];
				result(r,c,dir);  //한칸 이동시마다 모래 바뀐 값.
			}

			if(len == N-1) {  //마지막은 같은길이로 3번돌아야하므로
				change--;
			}

			dir = (dir+1)%4;		
			change++;
		}
		System.out.println(SUM);
	}

	static void result(int r,int c,int dir) { // 행,열 ,방향
		
		if(dir ==0) {
			sandrow =new int[]{-1,1,-1,1,-2,2,-1,1,0};
			sandcol = new int[]{1,1,0,0,0,0,-1,-1,-2};
		}
		if(dir ==1) {
			sandrow =new int[]{-1,-1,0,0,0,0,1,1,2};
			sandcol = new int[]{-1,1,-1,1,-2,2,-1,1,0};
		}
		if(dir ==2) {
			sandrow =new int[]{-1,1,-1,1,-2,2,-1,1,0};
			sandcol = new int[]{-1,-1,0,0,0,0,1,1,2};
		}
		if(dir ==3) {
			sandrow =new int[]{1,1,0,0,0,0,-1,-1,-2};
			sandcol = new int[]{-1,1,-1,1,-2,2,-1,1,0};
		}
		
		int temp=0,tx=0,ty=0,tsum=0;
		for(int i=0;i<9;i++) {
			tx = r+(sandrow[i]);
			ty = c+(sandcol[i]);

			temp = map[r][c] * persent[i] /100;

			if(tx<0 || tx>=N || ty<0 || ty>=N) {  //범위 밖일때
				SUM += temp;
				tsum +=temp;
			}
			else {  //범위 안 모래판일 때
				map[tx][ty] +=temp;
				tsum += temp;
			}
		}
		
		tx = r+dx[dir];
		ty = c+dy[dir];
		if(tx<0 || tx>=N || ty<0 || ty>=N) {  //알파의 좌표가 범위 밖일 때
			SUM += (map[r][c] -tsum);
		}
		else {
			map[tx][ty] += (map[r][c] -tsum);
		}
		map[r][c] = 0;
	}
}