import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,d,s,start;
	static int[][] map;
	static int[][][] next;
	static int sum;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		next = new int[N][N][2];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		start = N/2;
		saveMove();
		while(M--!=0) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = (d==1) ? 3 : (d==2) ? 1 : (d==3) ? 0 : 2;
			ice();
			while(true) {
				move();
				if(!bomb()) {
					break;
				}
			}
			divideGroup();
		}
		System.out.println(sum);
	}

	static void divideGroup() {
		int tx=start,ty=start,dd=0,tx2=start,ty2=start,tx3=start,ty3=start;
		int[] p1;
		int[][] temp = new int[N][N];
		int num1=0,num2=0;
		Queue<int[]> q1 = new LinkedList<>();
		int prev=map[start+dx[dd]][start+dy[dd]];
		a:for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<=i; k++) {
					tx = tx+ dx[dd];
					ty = ty+ dy[dd];
					if(ty ==-1) {
						break a;
					}
					if(prev == map[tx][ty]) {
						q1.offer(new int[] {tx,ty});
					}
					else {
						num1 = q1.size();
						num2 = prev;
						tx2 = next[tx2][ty2][0];
						ty2 = next[tx2][ty2][1];
						
						if(tx2<0 || tx2>=N || ty2<0 || ty2>=N) {
							break a;
						}
						tx3 = next[tx2][ty2][0];
						ty3 = next[tx2][ty2][1];
						temp[tx2][ty2] = num1;

						if(tx3<0 || tx3>=N || ty3<0 || ty3>=N) {
							break a;
						}
						temp[tx3][ty3] = num2;
						tx2=tx3;
						ty2=ty3;
						
						q1.clear();
						q1.offer(new int[] {tx,ty});
						prev = map[tx][ty];
					}
				}
				dd = (dd+1)%4;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = temp[i][j];
			}
		}
		return;
	}

	static boolean bomb() {
		int tx=start,ty=start,dd=0;
		boolean flag=false;
		int[] p1;
		Queue<int[]> q1 = new LinkedList<>();
		int prev=map[start+dx[dd]][start+dy[dd]];
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<=i; k++) {
					tx = tx+ dx[dd];
					ty = ty+ dy[dd];
					if(ty ==-1) {
						return flag;
					}

					if(prev == map[tx][ty]) {
						q1.offer(new int[] {tx,ty});
					}
					else {
						if(q1.size()>=4) {
							flag=true;
							sum = sum+ (prev * q1.size());
							while(!q1.isEmpty()) {
								p1 = q1.poll();
								map[p1[0]][p1[1]] = 0;
							}
						}
						q1.clear();
						q1.offer(new int[] {tx,ty});
						prev = map[tx][ty];
					}
				}
				dd = (dd+1)%4;
			}
		}
		return flag;
	}

	static void saveMove() {
		int tx=start,ty=start;
		int dd=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<=i; k++) {
					next[tx][ty][0] = tx+ dx[dd];
					next[tx][ty][1] = ty+ dy[dd];
					tx = tx+ dx[dd];
					ty = ty+ dy[dd];
					if(ty ==-1) {
						return;
					}
				}
				dd = (dd+1)%4;
			}
		}
	}

	static void move() {
		int tx=start,ty=start;
		boolean flag=false;
		int dd=0,idx1=0,idx2=0;
		int[] p1 = {0,0};
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<=i; k++) {
					tx = tx+ dx[dd];
					ty = ty+ dy[dd];
					if(ty ==-1) {
						return ;
					}
					if(!flag && map[tx][ty] ==0) {
						idx1=tx;
						idx2=ty;
						flag=true;
					}
					else if(flag && map[tx][ty] !=0) {
						map[idx1][idx2] = map[tx][ty];
						map[tx][ty] =0;
						p1 = next[idx1][idx2];
						idx1 = p1[0];
						idx2 = p1[1];
					}
				}
				dd = (dd+1)%4;
			}
		}
	}

	static void ice() {
		int cnt=0,tx=start,ty=start;
		while(++cnt<= s) {
			tx = tx+dx[d];
			ty = ty+dy[d];
			map[tx][ty]=0;
		}
	}
}