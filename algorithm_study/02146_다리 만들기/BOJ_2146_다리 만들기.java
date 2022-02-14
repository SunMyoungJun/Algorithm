import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,cnt;
	static int MIN=Integer.MAX_VALUE;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] mat;
	static boolean[][][] check;
	static ArrayList<ArrayList<int[]>> arr1 = new ArrayList<ArrayList<int[]>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		check = new boolean[N][N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j][0] == true) {
					continue;
				}
				if(mat[i][j] == 1) {
					check[i][j][0] = true;
					bfs(i,j);
					cnt++;
				}
		
			}
		}
		
		int x1=0,x2=0,y1=0,y2=0,size1=0,size2=0,num=0;
		int[] a1,a2;
		for(int i=0; i<cnt; i++) {
			ArrayList<int[]> A1 = arr1.get(i);
			size1 = A1.size();
			for(int j=i+1; j<cnt; j++) {
				ArrayList<int[]> A2 = arr1.get(j);
				size2 = A2.size();
				
				for(int k=0; k<size1; k++) {
					for(int z=0; z<size2; z++) {
						a1 = A1.get(k);
						a2 = A2.get(z);
						num = Math.abs(a1[0] - a2[0]) + Math.abs(a1[1] - a2[1]);
						MIN = (MIN < num) ? MIN : num;
					}
				}
				
			}
		}
		
		System.out.println(MIN-1);
		
		

	}
	static void bfs(int r,int c) {
		Queue<int[]> q1 = new LinkedList<>();
		q1.offer(new int[] {r,c});
		int[] p1;
		int tx=0,ty=0;
		ArrayList<int[]> a1 = new ArrayList<>();
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			
			for(int d=0; d<4; d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];
				
				if(tx<0 || tx>=N || ty<0 || ty>=N || check[tx][ty][0] ==true) {
					continue;
				}
				
				if(mat[tx][ty] == 0 && check[p1[0]][p1[1]][1] == false) {
					check[p1[0]][p1[1]][1] = true;
					a1.add(new int[] {p1[0],p1[1]});
				}
				if(mat[tx][ty] ==1) {
					check[tx][ty][0] = true;
					q1.offer(new int[] {tx,ty});
				}

			}
			
		}
		
		arr1.add(a1);
		
		
	}

}
