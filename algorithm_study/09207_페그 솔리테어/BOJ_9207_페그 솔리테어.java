import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Character[][] map = new Character[5][9];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int PIN;
	static int MIN_pin;
	static int MIN_distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int test = Integer.parseInt(br.readLine());

		while(test-- !=0) {
			PIN=0;
			
			for(int i=0;i<5;i++) {
				s = br.readLine();
				for(int j=0;j<9;j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] =='o')
						PIN++;
				}
			}

			MIN_pin = PIN;
			MIN_distance=0;
			dfs(0);
			System.out.println(MIN_pin+" "+MIN_distance);

			if(test !=0)
				s = br.readLine();
		}
	}

	static void dfs(int cnt) {
		if(MIN_pin > PIN-cnt) {
			MIN_pin = PIN-cnt;
			MIN_distance = cnt;
		}

		boolean flag = false;
		int tx=0,ty=0;
		int ttx=0,tty=0;

		for(int i=0;i<5;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j] =='o') {  //핀 
					for(int d=0;d<4;d++) {  //4방위 탐색
						tx = i + dx[d];
						ty = j+ dy[d];

						if(tx <0 || tx>4 || ty<0 || ty>8 || map[tx][ty] !='o') { //인접에 핀 없으면
							continue;
						}

						ttx = tx+dx[d];
						tty = ty+dy[d];

						if(ttx <0 || ttx>4 || tty<0 || tty>8 || map[ttx][tty] !='.') { // 인접한 핀 넘어서 빈칸없으면
							continue;
						}

						map[i][j] ='.';   //이동 전 핀 칸
						map[tx][ty] = '.'; // 없어질 핀 칸
						map[ttx][tty] = 'o'; // 이동 후 핀 칸
						dfs(cnt+1);
						map[i][j] ='o';   
						map[tx][ty] = 'o'; 
						map[ttx][tty] = '.'; 
						flag = true;
					}
				}
			}
		}
	}
}