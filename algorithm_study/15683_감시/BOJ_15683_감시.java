import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int N,M,cctvcount,MIN;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static List<cctv> CCTV = new ArrayList<cctv>();
	static class cctv{
		int x;
		int y;
		int number;

		public cctv(int x,int y,int number) {
			this.x = x;
			this.y = y;
			this.number = number;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >=1 && map[i][j] <5) {
					CCTV.add(new cctv(i,j,map[i][j]));
					cctvcount++;
				}
				
				else if(map[i][j] == 0)
					MIN++;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] ==5) {
					for(int k=0;k<4;k++) {
						checked(i,j,k,map);
					}
				}
			}
		}
		
		go(0,map);
		System.out.println(MIN);

	}

	public static void go(int cnt,int[][] map) {  //cnt = cctv index
		if(cctvcount == cnt) {
			int temp=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] == 0)
						temp++;
				}
			}
			
			MIN = (MIN < temp) ? MIN : temp;
			return;
		}

		int x=0,y=0,number=0;
		x = CCTV.get(cnt).x;
		y = CCTV.get(cnt).y;
		number = CCTV.get(cnt).number;
		int[][] tempmap = new int[N][M];
		if(number ==1) {  //한 방향 4번
			for(int i=0;i<4;i++) {
				tempmap = deepcopy(map);
				checked(x,y,i,tempmap);
				go(cnt+1,tempmap);
			}
		}
		else if(number ==2) {  //2방향(평행) 2번
			for(int i=0;i<2;i++) {
				tempmap = deepcopy(map);
				checked(x,y,i,tempmap);
				checked(x,y,i+2,tempmap);
				go(cnt+1,tempmap);
			}
		}
		else if(number ==3) {  // 2방향(직각) 4번
			for(int i=0;i<4;i++) {
				tempmap = deepcopy(map);
				checked(x,y,i,tempmap);
				checked(x,y,(i+1)%4,tempmap);
				go(cnt+1,tempmap);
			}
			
		}
		else if(number ==4) {  // 3방향 4번
			for(int i=0;i<4;i++) {
				tempmap = deepcopy(map);
				checked(x,y,i,tempmap);
				checked(x,y,(i+1)%4,tempmap);
				checked(x,y,(i+2)%4,tempmap);
				go(cnt+1,tempmap);
			}
		}
	
	}

	static void checked(int x,int y,int dir,int[][] map) {
		int tx = x + dx[dir];
		int ty = y + dy[dir];
		
		while(tx>=0 && ty>=0 && tx <N && ty <M) {
			if(map[tx][ty] == 0)
				map[tx][ty] = 7;
			if(map[tx][ty] ==6)
				break;
			tx = tx + dx[dir];
			ty = ty + dy[dir];
		}
		
	}
	static int[][] deepcopy(int[][] map) {
		int[][] result = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				result[i][j] = map[i][j];
			}
		}
		return result;
	}
}