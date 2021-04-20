import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[][] mat;
	static boolean[][][] check;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static Queue<Node> q1 = new LinkedList<Node>();
	static class Node {
		int x;
		int y;
		int wall;
		public Node(int x,int y,int wall) {
			this.x =x;
			this.y =y;
			this.wall =wall;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		check = new boolean[N][M][K+1];  
		String s;
		
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0; j<M;j++) {
				mat[i][j] = s.charAt(j) -48;
			}
		}
		
		q1.offer(new Node(0,0,0));
		for(int i=0;i<K+1;i++) {
			check[0][0][i] = true;
		}
		
		int size=0;
		int tx=0,ty=0;
		Node n1;
		int cnt=1;
		boolean flag = false;
		while(!q1.isEmpty()) {
			size = q1.size();
			
			for(int t=0; t<size; t++) {
				n1 = q1.poll();
				
				if(n1.x == N-1 && n1.y ==M-1) {
					System.out.println(cnt);
					return;
				}
				for(int i=0;i<4;i++) {
					tx = n1.x +dx[i];
					ty = n1.y +dy[i];
					
					if(tx <0 || tx >=N || ty <0 || ty>=M)
						continue;
					
					for(int j=0;j<=n1.wall;j++) {
						if(n1.wall == j && check[tx][ty][n1.wall]== true) {
							flag = true;
						}
					}
					
					if(flag) {
						flag = false;
						continue;
					}
					
					
					if(mat[tx][ty] ==1) {
						if(n1.wall <K) {
							q1.offer(new Node(tx,ty,n1.wall+1));
							check[tx][ty][n1.wall+1] =true;
						}
						
						
					}
					else {
						q1.offer(new Node(tx,ty,n1.wall));
						check[tx][ty][n1.wall] = true;
					}
				}
			}
			cnt++;
		}
		System.out.println("-1");
	}
}