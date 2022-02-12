import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,idx2,count;
	static int MIN=3000;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int[][] temp;
	static ArrayList<int[]> arr1 = new ArrayList<>();
	static Queue<Node> q1 = new LinkedList<>();
	
	static class Node {
		int x;
		int y;
		int sec;
		 public Node(int x,int y,int sec) {
			this.x = x;
			this.y = y;
			this.sec = sec;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		temp = new int[M][2];
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					arr1.add(new int[] {i,j});
					idx2++;
				}
				else if(map[i][j] == 0) {
					count++;
				}
			}
		}
		
		if(count ==0) {
			System.out.println("0");
			return;
		}
		
		q1.offer(new Node(0,0,0));
		dfs(0,0);
		
		
		if(MIN == 3000) {
			System.out.println("-1");
		}
		else {
			System.out.println(MIN);
		}
		
	}
	
	static int[][] arrayCopy() {
		int[][] map2 = new int[N][N];
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				if(map[i][j] ==2) {
					map2[i][j] = 3;
				}
				else {
					map2[i][j] = map[i][j];
				}
			}
		}
		return map2;
	}
	
	static void bfs() {
		int[][] map2 = arrayCopy();

		q1.clear();
		for(int i=0; i<M; i++) {
			q1.offer(new Node(temp[i][0],temp[i][1],0));
			map2[temp[i][0]][temp[i][1]] = 2;
		}
		
		Node e1;
		int size =0,tx=0,ty=0,cnt=0;
		while(!q1.isEmpty()) {
			size = q1.size();
			
			for(int i=0; i<size; i++) {
				e1 = q1.poll();
				
				if(e1.sec > MIN) {
					return;
				}
				for(int d=0; d<4; d++) {
					tx = e1.x + dx[d];
					ty = e1.y + dy[d];
					
					if(tx<0 || tx>=N || ty<0 || ty>=N || map2[tx][ty] ==1 ||  map2[tx][ty] == 2) {
						continue;
					}
					
					if(map2[tx][ty] ==0) {
						cnt++;
						if(cnt == count) {
							MIN = (MIN < e1.sec+1) ? MIN : e1.sec+1;
							return;
						}
					}
					map2[tx][ty] = 2;
					q1.offer(new Node(tx,ty,e1.sec+1));
					
				}
			}
		}
	}
	
	static void dfs(int cnt,int idx) {
		if(cnt == M) {
			bfs();
			return;
		}
		
		for(int i=idx; i<idx2;i++) {
			temp[cnt] = arr1.get(i);
			dfs(cnt+1,i+1);
		}
		
		
		
	}

}
