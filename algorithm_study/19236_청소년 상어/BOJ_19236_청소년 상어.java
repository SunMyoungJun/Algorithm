import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] fish = new int[4][4][2];
	static int[] dx = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,0,-1,-1,-1,0,1,1,1};
	static int sharkx = 0,sharky = 0,MAX=0;
	static int sharkdir;
	static int[][] where = new int[17][3];
		

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		 
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				fish[i][j][0] = Integer.parseInt(st.nextToken());  //물고기 번호
				fish[i][j][1] = Integer.parseInt(st.nextToken());  //물고기 방향
				where[fish[i][j][0]][0] = i;
				where[fish[i][j][0]][1] = j;
				where[fish[i][j][0]][2] = fish[i][j][1];  //물고기 행,열,방향
			}
		}
		int firstnum = fish[0][0][0];
		sharkdir = fish[0][0][1];		
		MAX=fish[0][0][0]; //첫 물고기 먹은 번호
		fish[0][0][0] = 100; ///상어가 먹은 위치 번호 100으로(빈칸)
		where[MAX][2] =-1;
		dfs(0,0,sharkdir,1,firstnum,fish,where);
		System.out.println(MAX);
		
	}
	
	static int[][][] move(int[][][] tempfish,int[][] tempwhere) {  // where[번호][3] 물고기 행,열,방향    //fish[i][j][2] 물고기 번호,방향
		
		int tx=0,ty=0;
		int td=0;
		for(int i=1;i<17;i++) {
			int dircnt=0;
			if(tempwhere[i][0] ==sharkx && tempwhere[i][1] == sharky) {
				continue;
			}
			
			if(tempwhere[i][2] == -1) {
				continue;
			}
			td = tempwhere[i][2];
			
			for(int j=td;j<td+10;j++) {  ////////////////아마 그럴리 없겟지만 물고기가 8방향모두 이동못할때 예외잇을수도있음.
				int tj =j;
				if(tj%9 ==0) {
					tj=1;
				}
				tx = tempwhere[i][0] + dx[tj%9];
				ty = tempwhere[i][1] + dy[tj%9];
				
				if(tx<0 || ty<0 || tx>=4 || ty>=4 || tempfish[tx][ty][0] ==100) {
					dircnt++;
					continue;
				}
				break;
			}
			
			int gx=0,gy=0,gd=0;  //tempfish[i][j][2] 물고기 번호,방향 //tempwhere[번호][3] 물고기 행,열,방향 
			int gx2=0,gy2=0;
			gx = tempwhere[i][0]; // x 좌표
			gy = tempwhere[i][1]; // y 좌표
			gd = tempwhere[i][2] +dircnt; //방향
			
			gd = (gd % 9 ==0) ? 1 : gd%9;
		
			gx2 = tempfish[tx][ty][0]; // 상어번호  
			gy2 = tempfish[tx][ty][1]; // 상어방향
			
			tempwhere[i][0] = tx;
			tempwhere[i][1] = ty;
			tempwhere[i][2] = gd;
			
			tempwhere[gx2][0] = gx;
			tempwhere[gx2][1] = gy;
			tempwhere[gx2][2] = gy2; //tempfish[i][j][2] 물고기 번호,방향 //tempwhere[번호][3] 물고기 행,열,방향 
			
			tempfish[gx][gy][0] = gx2;
			tempfish[gx][gy][1] = gy2;
			
			tempfish[tx][ty][0] = i;
			tempfish[tx][ty][1] = gd;
		}
		
		return tempfish;
		
	}
	
	static void dfs(int row,int col,int dir,int eat,int sum,int[][][] fish2,int[][] where2) { //상어 행,열 , 방향, 먹은 마리, 먹은 번호합
        
		MAX = (MAX > sum) ? MAX :sum;
		if(eat == 16) {
			return;
		}
		
		int[][][] tempfish = new int[4][4][2];   //tempfish[i][j][2] 물고기 번호,방향
		int[][] tempwhere = new int[17][3]; //tempwhere[번호][3] 물고기 행,열,방향  
		tempfish = deepcopy(tempfish,fish2);  //현재 상태에서 map 상황 
		tempwhere = deepcopy2(tempwhere,where2);
		tempfish = move(tempfish,tempwhere);  //물고기들 이동

		int tx = row+dx[dir];
		int ty = col+dy[dir];
		int cnt=1;
		
		int sharkx2 = sharkx;
		int sharky2 = sharky;
		while(true) {	
			sharkx2 = sharkx;
			sharky2 = sharky;
			if(tx<0 || tx>=4 || ty<0 || ty>=4) {
				break;
			}

			//tempfish[i][j][2] 물고기 번호,방향 //tempwhere[번호][3] 물고기 행,열,방향 
		
			
			int first=0,first2=0;
			
			if(tempfish[tx][ty][0] !=0) {
				tempfish[sharkx2][sharky2][0] =0;
				sharkx = tx;
				sharky = ty;
				first= tempfish[tx][ty][0];
				first2 = tempwhere[tempfish[tx][ty][0]][2];
				
				tempwhere[tempfish[tx][ty][0]][2] = -1; //쓰레기값
				tempfish[tx][ty][0] =100;
				dfs(tx,ty,tempfish[tx][ty][1],eat+1,sum+first,tempfish,tempwhere);
				tempfish[tx][ty][0] =first;
				tempwhere[tempfish[tx][ty][0]][2] = first2; //쓰레기값
				sharkx = sharkx2;
				sharky = sharky2;
				tempfish[sharkx][sharky][0] = 100;
			}

			int tj = dir%9;
			if(tj ==0)
				tj =1;
			tx = tx+dx[tj];
			ty = ty+dy[tj];
		}
	}

	static int[][][] deepcopy(int[][][] tempfish,int[][][] fish2) {
		
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				tempfish[i][j][0] = fish2[i][j][0];
				tempfish[i][j][1] = fish2[i][j][1];
			}
		}
		return tempfish;
	}
	
	static int[][] deepcopy2(int[][] tempwhere,int[][] where2) {  //tempfish[i][j][2] 물고기 번호,방향
																	//tempwhere[번호][3] 물고기 행,열,방향  
		
		for(int i=1;i<17;i++) {
			for(int j=0;j<3;j++) {
				tempwhere[i][j] = where2[i][j];
			}
		}
		return tempwhere;
	}
}