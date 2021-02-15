import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
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
		mat = new int[N][M];
		check = new boolean[N][M][2];   //0번째는 벽을 안뚫고 온놈. 1번째는 벽을 뚫고온놈.
		String s;
		
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0; j<M;j++) {
				mat[i][j] = s.charAt(j) -48;
			}
		}
		
		q1.offer(new Node(0,0,0));
		check[0][0][0] =true;
		check[0][0][1] = true;
		int size=0;
		int tx=0,ty=0;
		Node n1;
		int cnt=1;
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
					
					if(n1.wall ==0 && check[tx][ty][0] ==true)  //벽 안깻을 때 다음 벽을 이미 안꺤사람이 방문했다면 
						continue;
					
					if(n1.wall==1 && check[tx][ty][1] ==true) //벽을 깨고 왓는데 다음 벽을 이미 깬사람이 방문했다면
						continue;
					if(mat[tx][ty] ==1) {
						if(n1.wall == 0) {
							q1.offer(new Node(tx,ty,1));
							check[tx][ty][1] =true;
						}
					}
					else {
						q1.offer(new Node(tx,ty,n1.wall));
						if(n1.wall ==1)
							check[tx][ty][1] = true;
						else
							check[tx][ty][0] = true;
					}
				}
			}
			cnt++;
		}
		System.out.println("-1");
	}

}
