import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] map;
	static boolean[][][] check;
	static Queue<Node> q1 = new LinkedList<>();
	
	static class Node {
		int x;
		int y;
		int value;
		
		public Node(int x,int y,int value) {
			this.x= x;
			this.y= y;
			this.value = value;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		check = new boolean[M][N][1 <<6];
		int cnt=1,endX=0,endY=0;
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='S') {
					q1.offer(new Node(i,j,0));
					check[i][j][0]=true;
				}
				else if(map[i][j]=='X') {
					map[i][j] = (char)(cnt+'0');
					cnt++;
				}
				else if(map[i][j]=='E') {
					endX=i;
					endY=j;
				}
			}
		}
		
		
		
		
		int walk=0,size=0;
		int tx=0,ty=0,ob=0;
		
		int result = (int)Math.pow(2, cnt)-2;
		
		while(!q1.isEmpty()) {
			size = q1.size();
			
			
			for(int i=0; i<size; i++) {
				Node e1 = q1.poll();
				
				if(e1.value == result && e1.x ==endX && e1.y==endY) {
					System.out.println(walk);
					return;
				}
				
				
				for(int d=0; d<4; d++) {
					tx = e1.x + dx[d];
					ty = e1.y + dy[d];
					ob = e1.value;
					if(tx<0 || tx>=M || ty<0 || ty>=N) {
						continue;
					}
					if(check[tx][ty][e1.value] || map[tx][ty] =='#') {
						continue;
					}
					
					if(map[tx][ty] >'0' && map[tx][ty] <'6') {
						ob = (e1.value | (1 << (map[tx][ty]-'0')));
					}
					
					check[tx][ty][ob]= true; 
					q1.offer(new Node(tx,ty,ob));
				}
			}
			walk++;
		}
		System.out.println("gd");
		
	}

}
