import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static int[][] color;
	static int[][] numWhere;
	static List<Node>[][] arr1;
	static boolean flag2;
	static class Node {
		int x;
		int y;
		int num;
		int dir;
		public Node(int x,int y,int num,int dir) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
		public void setDir(int dir) {
			this.dir = dir;
		}
	}
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		numWhere = new int[K+1][2];
		color = new int[N+1][N+1];
		arr1 = new ArrayList[N+1][N+1];
		int row=0,col=0,dir=0,count=1;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				arr1[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=1; i<K+1; i++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			numWhere[i][0] = row;
			numWhere[i][1] = col;
			arr1[row][col].add(new Node(row,col,i,dir));
		}		
		while(true) {
			if(move()) 
				break;
			count++;
			if(count>1000) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(count);
	}
	
	static boolean move() {
		int r=0,c=0,size=0,idx=0,dir=0,tx=0,ty=0;
		Node e1;
		boolean flag = false;
		int count=0;
		for(int i=1; i<K+1; i++) {
			r = numWhere[i][0];
			c = numWhere[i][1];
			idx=0;
			size = arr1[r][c].size();
			flag = false;

			for(int j=0;j<size;j++) {
				e1 = arr1[r][c].get(j);
				if(e1.num == i) {
					idx = j;
					dir = e1.dir;
					break;
				}
			}
			tx = r+ dx[dir];
			ty = c+ dy[dir];
			
			if(tx<=0 || tx>N || ty<=0 || ty>N || color[tx][ty] ==2) 
				moveBlue(r,c,dir,idx);
			else if(color[tx][ty] ==0) 
				moveWhite(r,c,tx,ty,idx);
			else if(color[tx][ty] == 1) 
				moveRed(r,c,tx,ty,idx);
			if(flag2) 
				return true;
			
		}
		return false;
	}
	static void moveRed(int r,int c,int tx,int ty,int idx) {
		int size = arr1[r][c].size();
		Node e1;
		for(int i=size-1; i>=idx;i--) {
			e1 = arr1[r][c].get(i);
			numWhere[e1.num][0] = tx;
			numWhere[e1.num][1] = ty;
			arr1[tx][ty].add(e1);
			arr1[r][c].remove(i);
		}
		
		if(arr1[tx][ty].size() >=4) {
			flag2 = true;
			return;
		}
	}
	
	static void moveWhite(int r,int c,int tx,int ty,int idx) {
		int cnt=0;
		int size = arr1[r][c].size();
		Node e1;
		for(int i=idx; i<size; i++) {
			e1 = arr1[r][c].get(i-cnt);
			numWhere[e1.num][0] = tx;
			numWhere[e1.num][1] = ty;
			arr1[tx][ty].add(arr1[r][c].get(i-cnt));
			arr1[r][c].remove(i-cnt);
			cnt++;
		}
		if(arr1[tx][ty].size() >=4) {
			flag2 = true;
			return;
		}
	}
	
	static void moveBlue(int r,int c,int dir, int idx) {
		if(dir == 1 || dir ==3) 
			dir= dir+1;
		else 
			dir = dir-1;
		
		int tx= r + dx[dir];
		int ty= c + dy[dir];
		arr1[r][c].get(idx).setDir(dir);
		if(tx<=0 || tx>N || ty<=0 || ty>N || color[tx][ty] ==2) {
			return;
		}
		if(color[tx][ty] ==0) {
			moveWhite(r,c,tx,ty,idx);
		}
		else {
			moveRed(r,c,tx,ty,idx);
		}
	}
}