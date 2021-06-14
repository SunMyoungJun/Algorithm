import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int N,K;
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static int[][] map;
	static int[][] horse;
	static List<int[]>[][] horseMap;
	static int maxHorse = -1;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r=0,c=0,dir=0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		horseMap = new ArrayList[N+1][N+1]; // 각 좌표별 말 번호와 방향 저장
		horse = new int[K+1][2]; // 각 번호별 말들의 좌표
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				horseMap[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=1;i<K+1;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			
			horseMap[r][c].add(new int[] {i,dir});
			
			horse[i][0] = r;
			horse[i][1] = c;	
		}
			
		int hx=0,hy=0,tx=0,ty=0,td=0,turn=1;
		a:while(true) {
			flag = false;
			
			if(turn ==1000) {
				System.out.println("-1");
				return;
			}
			for(int i=1; i<K+1; i++) {
				hx = horse[i][0];
				hy = horse[i][1];
				
				if(horseMap[hx][hy].get(0)[0] != i) { // 해당위치의 제일 밑이 아닐 때
					continue;
				}
				
				td = horseMap[hx][hy].get(0)[1];
				tx = hx + dx[td];
				ty = hy + dy[td];
				
				if(tx <=0 || tx>N || ty <=0 || ty>N || map[tx][ty] == 2) { // 벽 이거나 파랑색 일 때
					nextWallBlue(i,hx,hy,tx,ty,td);  //말 번호, 현재 행,현재 열, 다음 행, 다음 열, 방향
				}
				else if(map[tx][ty] ==0) { // 다음칸이 흰색 일때
					nextWhite(i,hx,hy,tx,ty,td);
				}
				else {
					nextRed(i,hx,hy,tx,ty,td);
				}
				
				if(maxHorse >= 4) {
					break a;
				}	
			}
			if(flag == false) { // 모든 말이 움직이지 못한 경우
				System.out.println("-1");
				return;
			}
			turn++;
		}
		System.out.println(turn);
	}
	
	
	static void nextWallBlue(int num,int hx,int hy,int tx,int ty,int td) { //말 번호, 현재 행,현재 열, 다음 행, 다음 열, 방향
		if(td ==1 || td==3) { //방향 반대로
			td = td+1;
		}
		else {
			td = td-1;
		}
		
		tx = hx + dx[td];
		ty = hy + dy[td];
		
		if(tx <=0 || tx>N || ty <=0 || ty>N || map[tx][ty] == 2) { // 방향 바꿔도 벽 이거나 파랑색 일 때
			horseMap[hx][hy].get(0)[1] = td; // 방향만 변경
		}
		else {
			flag = true;
			horseMap[hx][hy].get(0)[1] = td;
			if(map[tx][ty] == 0) {
				nextWhite(num,hx,hy,tx,ty,td);
			}
			else {
				nextRed(num,hx,hy,tx,ty,td);
			}
		}
	}
	
	static void nextWhite(int num,int hx,int hy,int tx,int ty,int td) {
		int size = horseMap[hx][hy].size();
		int[] p1;
		for(int i=0; i<size; i++) {
			p1 = horseMap[hx][hy].get(i);
			horseMap[tx][ty].add(p1);
			horse[p1[0]][0] = tx;
			horse[p1[0]][1] = ty;
		}
		
		flag = true;
		horseMap[hx][hy].clear();
		horse[num][0] = tx;
		horse[num][1] = ty;
		
		maxHorse = horseMap[tx][ty].size();
	}
	
	static void nextRed(int num,int hx,int hy,int tx,int ty, int td) {
		
		int size = horseMap[hx][hy].size();
		int[] p1;
		for(int i=size-1; i>=0; i--) {
			p1 = horseMap[hx][hy].get(i);
			horseMap[tx][ty].add(p1);
			horse[p1[0]][0] = tx;
			horse[p1[0]][1] = ty;
		}
		
		flag = true;
		horseMap[hx][hy].clear();
		maxHorse = horseMap[tx][ty].size();
	}
}