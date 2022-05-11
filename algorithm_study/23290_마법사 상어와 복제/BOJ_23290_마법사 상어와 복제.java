import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M,S,startX,startY,max,realDir,result;
	static int[][] smell = new int[4][4];
	static int[][] temp = new int[4][4];
	static Queue<Fish> copyFish = new LinkedList<>();
	static Queue<Fish> whereFish = new LinkedList<>();
	static List<Fish>[][] arr1 = new ArrayList[4][4];
	
	static class Fish {
		int x;
		int y;
		int d;
		public Fish(int x,int y,int d) {
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	static int[] dx1 = {0,-1,-1,-1,0,1,1,1};
	static int[] dy1= {-1,-1,0,1,1,1,0,-1};
	static int[] dx2 = {-2,-1,0,1,0};
	static int[] dy2 = {-2,0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				arr1[i][j] = new ArrayList<Fish>();
			}
		}
		
		
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int x=0,y=0,d=0;
		while(M-- !=0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			d = Integer.parseInt(st.nextToken())-1;
			arr1[x][y].add(new Fish(x,y,d));
			whereFish.offer(new Fish(x,y,d));
		}
		
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken())-1; // 상어 초기 위치
		startY = Integer.parseInt(st.nextToken())-1;
		
		
		int count=1;
		while(S-- !=0) {
			fishCopy();
			fishMove();
			moveShark();
			checkTwoSmell();
			copyPut();
		}
		
		int answer=0;
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				answer += arr1[i][j].size();
			}
		}
		
		System.out.println(answer);
		
	}
	static void copyPut() {
		Fish e1;
		while(!copyFish.isEmpty()) {
			e1 = copyFish.poll();
			arr1[e1.x][e1.y].add(e1); 
		}
		
		
		for(int i=0; i<4; i++)  {
			for(int j=0; j<4; j++) {
				for(int k=0; k<arr1[i][j].size(); k++) {
					whereFish.offer(arr1[i][j].get(k));
				}
			}
		}
		
	}
	static void checkTwoSmell() {
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(smell[i][j]>0) {
					smell[i][j]--;
				}
			}
		}
		
		
	}
	
	static void moveShark() {

		
		max=-1;
		realDir=-1;
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				temp[i][j] = arr1[i][j].size();
			}
		}
		dfs(startX,startY,0,0,0);
		
		int tx=startX,ty = startY;
		
		tx = tx + dx2[realDir/100];
		ty = ty + dy2[realDir/100];
		
		if(arr1[tx][ty].size()>0) {
//			result += arr1[tx][ty].size();
			arr1[tx][ty].clear();
			smell[tx][ty] =3;
		}
	
		
		realDir = realDir%100;
		
		tx = tx + dx2[realDir/10];
		ty = ty + dy2[realDir/10];
		
		if(arr1[tx][ty].size()>0) {
			arr1[tx][ty].clear();
			smell[tx][ty] =3;
		}
		
		realDir = realDir%10;
		
		tx = tx + dx2[realDir];
		ty = ty + dy2[realDir];
		
		if(arr1[tx][ty].size()>0) {
			arr1[tx][ty].clear();
			smell[tx][ty] =3;
		}
		
		startX = tx;
		startY = ty;
	}
	
	static void dfs(int x,int y,int sum, int dir, int cnt) {
		if(cnt ==3) {
			if(max < sum) {
				max = sum;
				realDir = dir;
			}
			return;
		}
		
		
		int tx=0,ty=0;
		int prev=0;
		for(int i=1; i<5; i++) {
			tx = x+dx2[i];
			ty = y+dy2[i];
			
			if(tx<0 || tx>=4 || ty<0 || ty>=4) {
				continue;
			}
			prev= temp[tx][ty];
			temp[tx][ty] = 0;
			dfs(tx,ty,sum+prev,dir*10+i,cnt+1);
			temp[tx][ty] = prev;
		}
		
	}
	
	
	static void fishMove() {
		int size = whereFish.size();
		
		Fish p1;
		int canSize=0,dd=0,tx=0,ty=0,cnt=0;
		Fish ff;
		for(int i=0; i<size; i++) {
			p1 = whereFish.poll();
			if(arr1[p1.x][p1.y].size() ==0) {
				continue;
			}
			canSize = arr1[p1.x][p1.y].size();
			for(int j=0; j<canSize; j++) {
				ff = arr1[p1.x][p1.y].get(j);
				dd = ff.d;
				cnt=0;
				
				while(cnt != 8) {
					tx = ff.x+dx1[dd];
					ty = ff.y+dy1[dd];
					
					if(tx<0 || tx>=4 || ty<0 || ty>=4 || smell[tx][ty]>0) {
						dd = (dd-1) <0 ? 7 : dd-1;
						cnt++;
						continue;
					}
					
					if(tx == startX && ty == startY) {
						dd = (dd-1) <0 ? 7 : dd-1;
						cnt++;
						continue;
					}
					whereFish.offer(new Fish(tx,ty,dd));
					break;
				}
				if(cnt ==8) {
					whereFish.offer(ff);
				}
			}
			arr1[p1.x][p1.y].clear();
		}
		while(!whereFish.isEmpty()) {
			ff = whereFish.poll();
			arr1[ff.x][ff.y].add(ff);
		}
	}
	
	static void fishCopy() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				for(int k=0; k<arr1[i][j].size(); k++) {
					copyFish.offer(arr1[i][j].get(k));
				}
			}
		}
	}
}