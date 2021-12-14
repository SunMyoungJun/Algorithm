import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] check;
	static boolean[][] check2;
	static boolean[][] check3;
	static int N,M;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static Queue<int[]> q1 = new LinkedList<>();
	static ArrayList<int[]>[][] arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start=0,end=0;
		check = new boolean[N][N];
		check2 = new boolean[N][N]; 
		check3 = new boolean[N][N]; 
		check[0][0] = true; // 불
		check2[0][0] = true; // 갈 수 있는 곳
		check3[0][0] = true;
		arr1 = new ArrayList[N][N];
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				arr1[i][j] = new ArrayList<int[]>();
			}
		}
		
		int n1=0,n2=0,n3=0,n4=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			n3 = Integer.parseInt(st.nextToken());
			n4 = Integer.parseInt(st.nextToken());
			
			if(n1 ==1 && n2 ==1) {
				q1.offer(new int[] {n1-1,n2-1});
			}
			arr1[n1-1][n2-1].add(new int[] {n3-1,n4-1});
		}
		
		
		int[] p,p2;
		int tx=0,ty=0,size=0;
	
		while(!q1.isEmpty()) {
			p = q1.poll();
			
			
			for(int d=0; d<4; d++) {
				tx = p[0] + dx[d];
				ty = p[1] + dy[d];
				if(tx <0 || ty<0 || tx>=N || ty>=N) {
					continue;
				}
				
				check2[tx][ty] = true;
			}
			
			
			int size1 = arr1[p[0]][p[1]].size();
			
			for(int i=0; i<size1; i++) {
				p2 = arr1[p[0]][p[1]].get(i);
				check[p2[0]][p2[1]] = true;
				
				if(check2[p2[0]][p2[1]] == true && check3[p2[0]][p2[1]] == false) {
					q1.offer(new int[] {p2[0],p2[1]});
				}
				
				
			}
			
			
			for(int d=0; d<4; d++) {
				tx = p[0] + dx[d];
				ty = p[1] + dy[d];
				
				
				if(tx <0 || ty<0 || tx>=N || ty>=N) {
					continue;
				}
				if(!check2[tx][ty] || check3[tx][ty] || !check[tx][ty]) {
					continue;
				}
				check3[tx][ty] = true;
				q1.offer(new int[] {tx,ty});
				
			}
			
			
			
		
			
		}
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				if(check[i][j] == true) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	
	}

}
