import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,Q,L,div,zegob,dfsmax=0,MAX=0;
	static int[][]map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] temparray;
	static boolean[][] check;
	static boolean[][] check2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		zegob = (int) Math.pow(2, N);
		map = new int[zegob][zegob];
		check = new boolean[zegob][zegob];
	
		for(int i=0;i<zegob;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<zegob;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		int tempsum=0;
		st = new StringTokenizer(br.readLine());
		while(Q-- !=0) {
			L = Integer.parseInt(st.nextToken());
			div = (int)Math.pow(2, L);
			temparray = new int[div][div];
			rotate(0,0,zegob);
			check2 = new boolean[zegob][zegob];
			
			for(int i=0;i<zegob;i++) {  //얼음이 한번에 줄어 들어야함
				for(int j=0;j<zegob;j++) {
					checked(i,j);
				}
			}
			minus();
			tempsum=0;

		}
		int sum=0;
		for(int i=0;i<zegob;i++) {
			for(int j=0;j<zegob;j++) {
				sum+=map[i][j];
				if(check[i][j] ==false && map[i][j] !=0) {
					check[i][j] = true;
					dfsmax =1;
					dfs(i,j);
					MAX = (MAX > dfsmax) ? MAX : dfsmax;
				}
			}
		}
		System.out.println(sum);
		System.out.println(MAX);
	}
	
	static void dfs(int row,int col) {   //가장 큰 덩어리
		int tx=0,ty=0;

		for(int i=0;i<4;i++) {
			tx = row+dx[i];
			ty = col+dy[i];
			
			if(tx<0 || tx>=zegob || ty <0 || ty>=zegob || map[tx][ty] ==0 || check[tx][ty] == true)
				continue;
			
			check[tx][ty] = true;
			dfs(tx,ty);
			dfsmax++;
		}
		
	}
	
	
	static void rotate(int row,int col,int size) {  // 90도 회전
		if(size == div) {
			deepcopy(row,col);
			return;
		}
		
		
		rotate(row,col,size/2);
		rotate(row,col+size/2,size/2);
		rotate(row+size/2,col,size/2);
		rotate(row+size/2,col+size/2,size/2);
		
		
	}

	static void deepcopy(int row, int col) {
		
		for(int i=0;i<div;i++) {  //90도 회전값 임시 배열 저장
			for(int j=0;j<div;j++) {
				temparray[j][div-1-i] = map[row+i][col+j];
			}
		}
		
		for(int i=0;i<div;i++) {   //원래 배열에 저장
			for(int j=0;j<div;j++) {
				map[row+i][col+j] = temparray[i][j];
			}
		}	
	}
	
	
	static void checked(int row,int col) {  //인접 얼음 3개이상 남아있는지
		int cnt=0,tx=0,ty=0;
		for(int i=0;i<4;i++) {
			tx = row+dx[i];
			ty = col+dy[i];
			
			if(tx<0 || tx>=zegob || ty<0 || ty>=zegob || map[tx][ty] ==0)
				continue;
			
			cnt++;
		}
		
		if(cnt <3) { 
//			map[row][col] = (map[row][col] ==0) ? 0 : map[row][col]-1;
			check2[row][col] = true;
		}
		
	}
	
	static void minus() {
		
		for(int i=0;i<zegob;i++) {
			for(int j=0;j<zegob;j++) {
				if(check2[i][j] == true) {
					map[i][j] = (map[i][j] ==0) ? 0 : map[i][j]-1;
				}
			}
		}
	}
	
}
