import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,G,R;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int[][] flower;
	static boolean[][] check;
	static int resultCnt,size;
	static Queue<Node> q1 = new LinkedList<>();
	static int max = 0;
	static class Node {
		int x;
		int y;
		int been;
		
		public Node(int x, int y, int been) {
			this.x= x;
			this.y = y;
			this.been = been;
		}
	}
	
	
	static ArrayList<int[]> arr1 = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		resultCnt = G+R;
		map = new int[N][M];
//		flower = new int[N][M];
		flower = new int[resultCnt][3];
		check = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					arr1.add(new int[] {i,j});
				}
			}
		}
		size = arr1.size();

		dfs(0,R,G,0,0);
		System.out.println(max);
		
		
	
	
	}
	
	static void bfs() {
		int qsize = 0,tx=0,ty=0;
		int flowerCnt=0;
		int[][][] tempFlower = new int[N][M][2];
		int count=2;
		q1.clear();
		for(int i=0; i<resultCnt; i++) {
			q1.offer(new Node(flower[i][0],flower[i][1],flower[i][2]));
			tempFlower[flower[i][0]][flower[i][1]][0] = flower[i][2];
			tempFlower[flower[i][0]][flower[i][1]][1] = 1;
		}
		
		
		while(!q1.isEmpty())  {
			qsize = q1.size();
			
			for(int i=0; i<qsize; i++) {
				Node e1 = q1.poll();
				
				if(tempFlower[e1.x][e1.y][1] == -1) {
					continue;
				}
				
				for(int d=0; d<4; d++) {
					tx = e1.x + dx[d];
					ty = e1.y + dy[d];
					
					if(tx<0 || tx>=N || ty<0 || ty>=M || map[tx][ty] == 0) {
						continue;
					}
					
					if(tempFlower[tx][ty][1] == count && (tempFlower[tx][ty][0] != e1.been)) { //  꽃
						flowerCnt++;
						tempFlower[tx][ty][1] = -1;
						continue;
					}
					if(tempFlower[tx][ty][1] == 0) {
						tempFlower[tx][ty][0] = e1.been;
						tempFlower[tx][ty][1] = count;
						
						q1.offer(new Node(tx,ty,e1.been));
					}
				
					
				}
				
			}
			count++;
			
			
		}
	
		
		max = (max > flowerCnt) ? max : flowerCnt;
		
		
		
	}
	
	
	
	static void dfs(int cnt,int red,int green,int Rstart, int Gstart) {
		if(cnt == resultCnt) {
			//////////////////////// 씨를 다 뿌렸을 때 
			bfs();
			return;
		}
		
		
		for(int i=0; i<size; i++) {
			int[] xy = arr1.get(i);
			
			if(check[xy[0]][xy[1]] == true) {
				continue;
			}
			
			if(red !=0) { // 빨간거 
				if(i<Rstart) {
					continue;
				}
				flower[cnt][0] = xy[0];
				flower[cnt][1] = xy[1];
				flower[cnt][2] = 1;
				check[xy[0]][xy[1]] = true;
				dfs(cnt+1,red-1,green,i+1,0);
				check[xy[0]][xy[1]] = false;
				
			}
			else { // 초록
				if(i<Gstart) {
					continue;
				}
				flower[cnt][0] = xy[0];
				flower[cnt][1] = xy[1];
				flower[cnt][2] = 2;
				check[xy[0]][xy[1]] = true;
				dfs(cnt+1,red,green-1,0,i+1);
				check[xy[0]][xy[1]] = false;
			}
			
			
			
			
		}
		
		
	}

}
