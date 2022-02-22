import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N,M,size,total,time=99999;
	static int[][] map;
	static int[][] mapA;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static ArrayList<int[]> arr1 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		mapA = new int[M][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					arr1.add(new int[] {i,j});
				}
				if(map[i][j] == 0 || map[i][j] ==2) {
					total++;
				}
			}
		}
		total = total - M;
        if(total == 0) {
			System.out.println("0");
			return;
		}
		size = arr1.size();
		dfs(0,0);
		time = (time == 99999) ? -1 : time;
		System.out.println(time);
	}
	
	static void bfs() {
		int[][] temp = new int[N][N];
		int count = total;
		int sec=0;
		int tx=0,ty=0;
		Queue<int[]> q1 = new LinkedList<>();
		for(int i=0; i<M; i++) {
			q1.offer(new int[] {mapA[i][0],mapA[i][1]});
			temp[mapA[i][0]][mapA[i][1]] = -1;
		}
		
		while(!q1.isEmpty()) {
			int q1size = q1.size();
			for(int i=0; i<q1size; i++) {
				int[] p1 = q1.poll();
				for(int d=0; d<4; d++) {
					tx = p1[0] + dx[d];
					ty = p1[1] + dy[d];
					
					if(tx<0 || tx>=N || ty<0 || ty>=N || temp[tx][ty] == -1 || map[tx][ty] == 1) {
						continue;
					}
					
					temp[tx][ty] = -1;
					count--;
					if(count ==0) {
						time = (time < sec+1) ? time : sec+1;
						return;
					}
					q1.offer(new int[] {tx,ty});
				}	
			}
			sec++;
		}
	}
    
	static void dfs(int idx, int cnt) {
		int[] p1;
		if(cnt == M) {
			bfs();
			return;
		}
		for(int i=idx; i<size; i++) {
			p1 = arr1.get(i);
			map[p1[0]][p1[1]] = 3;
			mapA[cnt][0] = p1[0];
			mapA[cnt][1] = p1[1];
			dfs(i+1,cnt+1);
			map[p1[0]][p1[1]] = 2;
		}
	}
}