import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][][] bd;
	static boolean[][][] check;
	static int[] dz = {0,0,0,0,1,-1};
	static int[] dx = {-1,0,1,0,0,0};
	static int[] dy = {0,1,0,-1,0,0};
	static int height,row,col; //입력 높이,행,열

	static class loc{
		int z;  //높이
		int x;  //행
		int y;  //열

		public loc(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y =y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sh=0,sr=0,sc=0;  //시작 높이,행,열
		int eh=0,er=0,ec=0;  //  끝 높이,행,열
		int tz=0,tx=0,ty=0;
		int qz=0,qx=0,qy=0;
		int size=0; //큐 크기
		loc loc1;
		StringBuilder sb = new StringBuilder();
		while(true)  {
			st = new StringTokenizer(br.readLine());
			height = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			int cnt=0;
			if(height ==0) //입력 1개 0이면 끝남.
				break;
			boolean tf =false;
			String s;
			bd = new char[height][row][col];
			check = new boolean[height][row][col];
			Queue<loc> q1 = new LinkedList<loc>();
			for(int k=0;k<height;k++) {
				for(int i=0;i<row;i++) {
					s = br.readLine();
					for(int j=0;j<col;j++) {
						bd[k][i][j] = s.charAt(j);
						if(s.charAt(j) =='S') { //시작 좌표 저장
							sh = k;
							sr =i;
							sc = j;
							q1.offer(new loc(sh,sr,sc));
						}
						else if(s.charAt(j) =='E') { //끝 좌표 저장
							eh =k;
							er = i;
							ec =j;
						}
					}
				}
				s = br.readLine();   //공백 줄바꿈
			}

			while(!q1.isEmpty()) {
				size = q1.size();

				for(int i=0; i<size;i++) {
					loc1 = q1.poll();
					tz = loc1.z;
					tx = loc1.x;
					ty = loc1.y;

					if(tz == eh && tx==er && ty==ec) {
						sb.append("Escaped in ").append(cnt).append(" minute(s).\n");
						q1.clear();
						tf = true;
						break;
					}

					for(int j=0;j<6;j++) {
						qz = tz+dz[j];
						qx = tx+dx[j];
						qy = ty+dy[j];

						if(qz<0 || qz>=height || qx<0 || qx>=row || qy<0 || qy>=col || check[qz][qx][qy] ==true)
							continue;

						if(bd[qz][qx][qy] =='#')
							continue;
						check[qz][qx][qy] = true;
						q1.offer(new loc(qz,qx,qy));
					}
				}
				cnt++;
			}

			if(tf == false) {  //도착 못했을때
				sb.append("Trapped!\n");
			}
		}
		System.out.println(sb.toString());
	}
}