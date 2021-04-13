import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N;
	static int[][][] map;
	static PriorityQueue<int[]> q1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return (o1[2] > o2[2]) ? 1: -1;
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		String s="";
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<test+1; t++) {
			q1.clear();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N][2];
			
			for(int i=0;i<N;i++) {
				s = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j][0] = s.charAt(j) -'0';
					map[i][j][1] = Integer.MAX_VALUE;
				}
			}
			
			map[0][0][0] = 0;
			q1.offer(new int[] {0,0,0});
			
			
			int result = bfs();
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
						
		}
		
		System.out.println(sb.toString());		
	}
	
	static int bfs() {
		int tx=0,ty=0;
		boolean[][] check = new boolean[N][N];
		check[0][0] = true;
		while(!q1.isEmpty()) {
			int[] p1 = q1.poll();
			
			
			for(int d=0;d<4;d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];
				
				if(tx == N-1 && ty == N-1) {
					return p1[2];
				}
				
				
				if(tx<0 || tx >=N || ty<0 || ty>=N) {
					continue;
				}
				
				
				if(map[tx][ty][1] > map[tx][ty][0]+p1[2]) {
					map[tx][ty][1] = map[tx][ty][0] + p1[2];
					q1.offer(new int[] {tx,ty,map[tx][ty][1]});
				}
				
				
			}
		}
		
		return -1;
		
		
	}

}
