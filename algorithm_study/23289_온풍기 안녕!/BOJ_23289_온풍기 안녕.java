package 삼성준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ23289온풍기안녕 {
	static int R,C,K,W;
	static int[][][] map;
	static List<int[]> wind = new ArrayList<>();
	static List<int[]> find = new ArrayList<>();
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=0,x=0,y=0,t=0,chco=0;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[R][C][5];


		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				n = Integer.parseInt(st.nextToken());
				if(n>0 && n<5) {
					wind.add(new int[] {i,j,n});
				}
				else if(n==5) {
					find.add(new int [] {i,j});
				}
			}
		}

		W = Integer.parseInt(br.readLine());

		while(W-- !=0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			t = Integer.parseInt(st.nextToken());
			if(t==1) {
				map[x][y][1]=1;
				map[x][y+1][2]=1;
			}
			else {
				map[x][y][3] = 1;
				map[x-1][y][4] =1;
			}
		}


		while(chco <101) {

			allWind(); // 모든 온풍기에서 바람 나옴
			plusminus(); // 온도 조절
			minusOne(); // 가장 바깥쪽 칸의 온도가 1이상이면 온도 1감소
			chco++;

			if(kChecking()) { // 조사하는 모든 칸의 온도가 K이상인지 여부
				break;
			}
		}
		System.out.println(chco);

	}


	static boolean kChecking() {

		int size = find.size();
		int [] p1;

		for(int i=0; i<size; i++) {
			p1 = find.get(i);
			if(map[p1[0]][p1[1]][0]<K) {
				return false;
			}
		}

		return true;
	}


	static void minusOne() {

		for(int i=0; i<R;i++) {
			if(map[i][0][0] >0) {
				map[i][0][0]--;
			}
			if(map[i][C-1][0]>0) {
				map[i][C-1][0]--;
			}
		}

		for(int i=1; i<C-1; i++) {
			if(map[0][i][0]>0) {
				map[0][i][0]--;
			}
			if(map[R-1][i][0] >0) {
				map[R-1][i][0]--;
			}
		}


	}



	static void plusminus() {
		int[][] temparr = new int[R][C];
		int num=0,tx=0,ty=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				for(int d=0; d<2; d++) {
					tx = i+dx[d];
					ty = j+dy[d];

					if(tx<0 || tx>=R || ty<0 || ty>=C) {
						continue;
					}
					if(d==0 && map[i][j][1] ==1) {
						continue;
					}
					if(d==1 && map[i][j][4]==1) {
						continue;
					}
					num = (Math.abs(map[i][j][0]-map[tx][ty][0]))/4;
					if(map[i][j][0]>map[tx][ty][0]) {
						temparr[i][j] -= num;
						temparr[tx][ty] +=num;
					}
					else if(map[i][j][0]<map[tx][ty][0]) {
						temparr[tx][ty] -= num;
						temparr[i][j] += num;
					}
				}
			}
		}


		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j][0] += temparr[i][j];
			}
		}
	}





	static void right(int r,int c) {
		boolean[][] check = new boolean[R][C];
		Queue<int[]> q1 = new LinkedList<>();
		q1.offer(new int[] {r,c+1});
		map[r][c+1][0] +=5;
		check[r][c+1] = true;
		int tx=0,ty=0,size=0;
		int[] p1;
		int score=4;
		while(!q1.isEmpty()) {
			size= q1.size();

			for(int i=0; i<size; i++) {
				p1= q1.poll();
				if(p1[0]-1 >=0 && map[p1[0]][p1[1]][3] ==0) {
					if((p1[1]+1)<C && map[p1[0]-1][p1[1]][1] ==0) {
						if(!check[p1[0]-1][p1[1]+1]) {
							check[p1[0]-1][p1[1]+1] = true;
							map[p1[0]-1][p1[1]+1][0]+=score;
							q1.offer(new int[] {p1[0]-1,p1[1]+1});
						}
					}
				}
				if((p1[1]+1)<C && map[p1[0]][p1[1]][1] ==0) {
					if(!check[p1[0]][p1[1]+1]) {
						check[p1[0]][p1[1]+1] = true;
						map[p1[0]][p1[1]+1][0]+=score;
						q1.offer(new int[] {p1[0],p1[1]+1});
					}
				}

				if(p1[0]+1 <R && map[p1[0]][p1[1]][4] ==0) {
					if((p1[1]+1)<C && map[p1[0]+1][p1[1]][1] ==0) {
						if(!check[p1[0]+1][p1[1]+1]) {
							check[p1[0]+1][p1[1]+1] = true;
							map[p1[0]+1][p1[1]+1][0]+=score;
							q1.offer(new int[] {p1[0]+1,p1[1]+1});
						}
					}
				}
			}
			score--;
			if(score==0) {
				break;
			}
		}
	}


	static void left(int r,int c) {
		boolean[][] check = new boolean[R][C];
		Queue<int[]> q1 = new LinkedList<>();
		q1.offer(new int[] {r,c-1});
		map[r][c-1][0] +=5;
		check[r][c-1] = true;
		int tx=0,ty=0,size=0;
		int[] p1;
		int score=4;
		while(!q1.isEmpty()) {
			size= q1.size();
			for(int i=0; i<size; i++) {
				p1= q1.poll();
				if(p1[0]-1 >=0 && map[p1[0]][p1[1]][3] ==0) {
					if(p1[1]-1>=0 && map[p1[0]-1][p1[1]][2] ==0) {
						if(!check[p1[0]-1][p1[1]-1]) {
							check[p1[0]-1][p1[1]-1] = true;
							map[p1[0]-1][p1[1]-1][0]+=score;
							q1.offer(new int[] {p1[0]-1,p1[1]-1});
						}
					}
				}
				if((p1[1]-1)>=0 && map[p1[0]][p1[1]][2] ==0) {
					if(!check[p1[0]][p1[1]-1]) {
						check[p1[0]][p1[1]-1] = true;
						map[p1[0]][p1[1]-1][0]+=score;
						q1.offer(new int[] {p1[0],p1[1]-1});
					}
				}

				if(p1[0]+1 <R && map[p1[0]][p1[1]][4] ==0) {
					if((p1[1]-1)>=0 && map[p1[0]+1][p1[1]][2] ==0) {
						if(!check[p1[0]+1][p1[1]-1]) {
							check[p1[0]+1][p1[1]-1] = true;
							map[p1[0]+1][p1[1]-1][0]+=score;
							q1.offer(new int[] {p1[0]+1,p1[1]-1});
						}
					}
				}
			}
			score--;
			if(score==0) {
				break;
			}
		}
	}


	static void up(int r,int c) {
		boolean[][] check = new boolean[R][C];
		Queue<int[]> q1 = new LinkedList<>();
		q1.offer(new int[] {r-1,c});
		check[r-1][c] = true;
		map[r-1][c][0] +=5;
		int tx=0,ty=0,size=0;
		int[] p1;
		int score=4;
		while(!q1.isEmpty()) {
			size= q1.size();
			for(int i=0; i<size; i++) {
				p1= q1.poll();
				if(p1[1]-1 >=0 && map[p1[0]][p1[1]][2] ==0) {
					if(p1[0]-1>=0 && map[p1[0]][p1[1]-1][3] ==0) {
						if(!check[p1[0]-1][p1[1]-1]) {
							check[p1[0]-1][p1[1]-1] = true;
							map[p1[0]-1][p1[1]-1][0]+=score;
							q1.offer(new int[] {p1[0]-1,p1[1]-1});
						}
					}
				}
				if((p1[0]-1)>=0 && map[p1[0]][p1[1]][3]==0) {
					if(!check[p1[0]-1][p1[1]]) {
						check[p1[0]-1][p1[1]] = true;
						map[p1[0]-1][p1[1]][0]+=score;
						q1.offer(new int[] {p1[0]-1,p1[1]});
					}
				}

				if(p1[1]+1 <C && map[p1[0]][p1[1]][1] ==0) {
					if((p1[0]-1)>=0 && map[p1[0]][p1[1]+1][3]==0) {
						if(!check[p1[0]-1][p1[1]+1]) {
							check[p1[0]-1][p1[1]+1] = true;
							map[p1[0]-1][p1[1]+1][0]+=score;
							q1.offer(new int[] {p1[0]-1,p1[1]+1});
						}
					}
				}
			}
			score--;
			if(score==0) {
				break;
			}
		}
	}

	static void down(int r,int c) {
		boolean[][] check = new boolean[R][C];
		Queue<int[]> q1 = new LinkedList<>();
		q1.offer(new int[] {r+1,c});
		check[r+1][c] = true;
		map[r+1][c][0] +=5;
		int tx=0,ty=0,size=0;
		int[] p1;
		int score=4;
		while(!q1.isEmpty()) {
			size= q1.size();
			for(int i=0; i<size; i++) {
				p1= q1.poll();
				if(p1[1]-1 >=0 && map[p1[0]][p1[1]][2] ==0) {
					if(p1[0]+1<R && map[p1[0]][p1[1]-1][4]==0) {
						if(!check[p1[0]+1][p1[1]-1]) {
							check[p1[0]+1][p1[1]-1] = true;
							map[p1[0]+1][p1[1]-1][0]+=score;
							q1.offer(new int[] {p1[0]+1,p1[1]-1});
						}
					}
				}
				if((p1[0]+1)<R && map[p1[0]][p1[1]][4]==0) {
					if(!check[p1[0]+1][p1[1]]) {
						check[p1[0]+1][p1[1]] = true;
						map[p1[0]+1][p1[1]][0]+=score;
						q1.offer(new int[] {p1[0]+1,p1[1]});
					}
				}

				if(p1[1]+1 <C && map[p1[0]][p1[1]][1] ==0) {
					if((p1[0]+1)<R && map[p1[0]][p1[1]+1][4]==0) {
						if(!check[p1[0]+1][p1[1]+1]) {
							check[p1[0]+1][p1[1]+1] = true;
							map[p1[0]+1][p1[1]+1][0]+=score;
							q1.offer(new int[] {p1[0]+1,p1[1]+1});
						}
					}
				}
			}
			score--;
			if(score==0) {
				break;
			}
		}
		
		
		
		
	}


	static void allWind() {

		int size= wind.size();
		int[] p1;

		for(int i=0; i<size; i++) {
			p1 = wind.get(i);
			if(p1[2] == 1) { // 오른쪽
				right(p1[0],p1[1]);
			}
			else if(p1[2]==2) { // 왼쪽
				left(p1[0],p1[1]);
			}
			else if(p1[2]==3) { // 위쪽
				up(p1[0],p1[1]);
			}
			else { // 아래쪽
				down(p1[0],p1[1]);

			}


		}
		
		

	}

}
