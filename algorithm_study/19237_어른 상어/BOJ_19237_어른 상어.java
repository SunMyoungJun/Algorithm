import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	static int N,M,k,cnt,sec;
	static int map[][][];
	static int[][][] sharkdir;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	static ArrayList<shark> arr1 = new ArrayList<shark>();
	
	static class shark {
		int x,y,number,dir;

		public shark(int x, int y, int number, int dir) {
			this.x = x;
			this.y = y;
			this.number = number;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		cnt = M;
		map = new int[N][N][3];  //상어번호, 냄새, 머물고있는 상어 수
		sharkdir = new int[M+1][5][5];
		int temp =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				temp = Integer.parseInt(st.nextToken());
				if(temp !=0) {
					map[i][j][0] = temp;
					map[i][j][1] = k;
					map[i][j][2] = 1;
					arr1.add(new shark(i,j,temp,-1));
				}
				
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<M+1;i++) {
			for(int j=0;j<M;j++) {
				if(arr1.get(j).number == i) {
					arr1.get(j).dir = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int i=1;i<M+1;i++) {
			for(int j=1;j<5;j++) {
				st = new StringTokenizer(br.readLine());
				for(int u=1;u<5;u++) {
					sharkdir[i][j][u] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		while(true) {
			move();
			eat();
			smelldown();
			sec++;
			if(sec>1000) {
				System.out.println("-1");
				break;
			}
			else if(cnt==1) {
				System.out.println(sec);
				break;
			}
			
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					if(map[i][j][2] !=0)
//						System.out.print(map[i][j][0]+" ");
//					else
//						System.out.print("0"+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("---------------");
			
			
		}
	
	}
	static void move() {  //원래 위치에 냄새남기기, 다음위치에 상어 이동
		int number=0,dir=0;
		int sharkx=0,sharky=0;
		for(int i=0;i<arr1.size();i++) {
			int d=0,tx=0,ty=0,tf=0;
			sharkx = arr1.get(i).x;
			sharky = arr1.get(i).y;
			dir = arr1.get(i).dir;
			number = arr1.get(i).number;
			
			for(int j=1;j<5;j++) {   //  map = new int[N][N][3];  //상어번호, 냄새, 머물고있는 상어 수
				d = sharkdir[number][dir][j];
				tx = sharkx + dx[d];
				ty = sharky + dy[d];
				
				if(tx<0 || ty <0 || tx>=N || ty>=N || map[tx][ty][1] !=0) { //범위 벗어나거나 냄새 있으면
					continue;
				}
				
				tf= 1;
				arr1.get(i).x = tx;
				arr1.get(i).y = ty;
				arr1.get(i).dir = d;
				
				map[sharkx][sharky][2]--;  //옮긴후 원래자리 상어 수 감소
				if(map[tx][ty][2] !=0) {
					map[tx][ty][0] = (map[tx][ty][0] < number) ? map[tx][ty][0] : number;
				}
				else {
					map[tx][ty][0] = number;
				}
				map[tx][ty][2]++;   //이동 후 상어 수 증가
				break;
				
			}
			
			if(tf==0) {  //4방향 전부 향기가 있다면 그전에 냄새 뿌렷던 자리로 돌아가기
				for(int j=1;j<5;j++) { //  map = new int[N][N][3];  //상어번호, 냄새, 머물고있는 상어 수
					d = sharkdir[number][dir][j];
					tx = sharkx +dx[d];
					ty = sharky +dy[d];
					
					if(tx<0 || tx>=N || ty<0 || ty>=N)
						continue;
					
					if(map[tx][ty][0] == number) {
						arr1.get(i).x = tx;
						arr1.get(i).y = ty;
						arr1.get(i).dir = d;
						if(map[tx][ty][2] !=0) {
							map[tx][ty][0] = (map[tx][ty][0] < number) ? map[tx][ty][0] : number;
						}
						else {
							map[tx][ty][0] = number;
						}
						map[tx][ty][2]++;  //머물고 있는 상어 수
						map[sharkx][sharky][2]--;
						break;
					}
				}
			}	
		}
	}
	
	static void eat() { //map = new int[N][N][3];  //상어번호, 냄새, 머물고있는 상어 수
		int number =0,tx=0,ty=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j][2] >1) { //같은칸에 상어가 여러마리 일때
					for(int k=0;k<arr1.size();k++) {
						number = arr1.get(k).number;
						tx = arr1.get(k).x;
						ty = arr1.get(k).y;
						if(tx == i && ty == j && map[i][j][0] != number) {
							arr1.remove(k);
							map[i][j][2]--;
							cnt--;
							k--;
						}
					}
				}
			}
		}
	}
	
	static void smelldown() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j][2] !=0) { // 상어 존재하면
					map[i][j][1] = k;
				}
				else if(map[i][j][1] !=0) {
					map[i][j][1]--;
				}
			}
		}
	}
}