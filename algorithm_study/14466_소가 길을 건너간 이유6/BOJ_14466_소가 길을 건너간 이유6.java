import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,K,R;
	static boolean[][][][] street;
	static boolean[][][][] cowPair;
	static boolean[][] cowMap;
	static List<int[]> cow = new ArrayList<int[]>();
	static Queue<int[]> q1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] p1,p2;
		int sum=0;
		N = Integer.parseInt(st.nextToken()); // 격자 크기
		K = Integer.parseInt(st.nextToken()); // 소 마리
		R = Integer.parseInt(st.nextToken()); // 길 개수
		
		street = new boolean[N+1][N+1][N+1][N+1];
		cowMap = new boolean[N+1][N+1];
		cowPair = new boolean[N+1][N+1][N+1][N+1];
		int r=0,c=0,r1=0,c1=0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			street[r][c][r1][c1] = true;
			street[r1][c1][r][c] = true;
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			cowMap[r][c] = true;
			cow.add(new int[] {r,c});
		}
		for(int i=0; i<K; i++) {
			p1 = cow.get(i);
			q1 = new LinkedList<int[]>();
			q1.offer(p1);
			
			bfs(p1[0],p1[1]);
		}
		
		for(int i=0; i<K; i++) {
			p1 = cow.get(i);
			for(int j=i+1; j<K;j++) {
				p2 = cow.get(j);
				if(cowPair[p1[0]][p1[1]][p2[0]][p2[1]] == false) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
	
	static void bfs(int cowr,int cowc) {
		int[] p1;
		int tx=0,ty=0;
		boolean[][] check = new boolean[N+1][N+1];
		check[cowr][cowc] = true;
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			check[p1[0]][p1[1]] = true;
			if(cowMap[p1[0]][p1[1]] == true) {
				cowPair[cowr][cowc][p1[0]][p1[1]] = true;
			}
			for(int d=0;d<4;d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];
				
				if(tx <=0 || tx>N || ty<=0 || ty>N) {
					continue;
				}
				else if(check[tx][ty] == true || street[p1[0]][p1[1]][tx][ty] == true) {
					continue;
				}	
				check[tx][ty] = true;
				q1.offer(new int[] {tx,ty});
			}
		}
	}
}