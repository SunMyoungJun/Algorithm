import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int W,H;
	static Character[][] map;
	static int[][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static PriorityQueue<Node> q1 = new PriorityQueue<Node>(new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.laser - o2.laser;
		}
	});
	static class Node {
		int x,y,dir,laser;
		
		public Node(int x,int y,int dir,int laser) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.laser = laser;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s;
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int x=0,y=0;
		map = new Character[H][W];
		check = new int[H][W];
	
		for(int i=0;i<H;i++) {
			s = br.readLine();
			for(int j=0;j<W;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] =='C') {
					x =i;
					y = j;
				}
				
				check[i][j] = Integer.MAX_VALUE;
				
			}
		}
		
		check[x][y] = 0; //시작점
		q1.offer(new Node(x, y,-1,0));  //방향 -1 일때 4가지 방향으로 거울 없이 쏨.(첫번째 입력만)
		
		bfs();
	}
	
	static void bfs() {
		Node temp;
		int tx=0,ty=0;
		while(!q1.isEmpty()) {
			temp = q1.poll();
			
			if(check[temp.x][temp.y] !=0 && map[temp.x][temp.y] == 'C') {
				System.out.println(temp.laser);
				return;
			}
			
			for(int d=0;d<4;d++) {
				tx = temp.x + dx[d];
				ty = temp.y + dy[d];
				
				if(tx<0 || tx>=H || ty<0 || ty>=W || map[tx][ty] =='*') {
					continue;
				}
				
				else if(temp.dir == d && check[tx][ty] < temp.laser) { // 반사되면서 온 레이저 처리 check배열
					continue;
				}
				else if(temp.dir !=d && check[tx][ty] <temp.laser+1) { // 반사되면서 온 레이저 처리 check배열
					continue;
				}			
				
				else if(temp.dir == -1 || temp.dir == d) { //첫 입력 이거나 다음 위치 방향과 현재 레이저 방향 동일할 떄
					check[tx][ty] = temp.laser;
					q1.offer(new Node(tx,ty,d,temp.laser));
				}
				else{
					check[tx][ty] = temp.laser+1;
					q1.offer(new Node(tx,ty,d,temp.laser+1));
				}	
			}
		}
	}
}