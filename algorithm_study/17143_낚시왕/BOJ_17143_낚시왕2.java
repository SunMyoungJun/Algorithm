import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C,M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int sum;
	static Queue<Shark> q1 = new LinkedList<>();
	static int[][][] map;
	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		public Shark(int r,int c,int s,int d,int z)  {
			this.r=r;
			this.c=c;
			this.s=s;
			this.d=d;
			this.z=z;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C][3];
		int r=0,c=0,s=0,d=0,z=0;
		while(M-- !=0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken())-1;
			z = Integer.parseInt(st.nextToken());

			if(d==0 || d==1) {
				s=s%((R-1)*2);
			}
			else {
				s=s%((C-1)*2);
			}
			map[r][c][0] = s;
			map[r][c][1] = d;
			map[r][c][2] = z;
		}
		int start=0;
		while(start != C) {
			catchShark(start);
			moveShark();
			start++;
		}
		
		System.out.println(sum);
	}

	static void moveShark() {

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j][2]>0) {
					q1.offer(new Shark(i,j,map[i][j][0],map[i][j][1],map[i][j][2]));
					map[i][j][0]=0;
					map[i][j][1]=0;
					map[i][j][2]=0;
				}
			}
		}

		int size=q1.size();
		int time=0;
		int tx=0,ty=0,d=0;
		Shark e1;
		for(int i=0; i<size; i++) {
			e1 = q1.poll();
			time = e1.s;
			tx = e1.r;
			ty = e1.c;
			d=e1.d;
			while(time-- !=0) {
				if(tx+dx[d] <0 || tx+dx[d]>=R || ty+dy[d]<0 || ty+dy[d]>=C) {
					d = (d==0 || d==2) ? d+1 :d-1;
				}
				tx = tx + dx[d];
				ty = ty + dy[d];
			}
			q1.offer(new Shark(tx,ty,e1.s,d,e1.z));
		}
		
		
		while(!q1.isEmpty()) {
			e1 = q1.poll();
			if(map[e1.r][e1.c][2] >0) {
				if(map[e1.r][e1.c][2] < e1.z) {
					map[e1.r][e1.c][0] = e1.s;
					map[e1.r][e1.c][1] = e1.d;
					map[e1.r][e1.c][2] = e1.z;
				}
			}
			else {
				map[e1.r][e1.c][0] = e1.s;
				map[e1.r][e1.c][1] = e1.d;
				map[e1.r][e1.c][2] = e1.z;
			}
		}
	}

	static void catchShark(int start) {
		for(int i=0; i<R; i++) {
			if(map[i][start][2]>0) {
				map[i][start][0]=0;
				map[i][start][1]=0;
				sum += map[i][start][2];
				map[i][start][2]=0;
				break;
			}
		}
	}
}