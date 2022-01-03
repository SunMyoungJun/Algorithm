
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main{
	static int N;
	static int sRow,sCol,eRow,eCol;
	static char[][] map;
	static boolean[][][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class Node {
		int x;
		int y;
		int d;
		int cnt;

		public Node(int x,int y,int d,int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		check = new boolean[N][N][4];
		PriorityQueue<Node> pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (o1.cnt > o2.cnt) ? 1: -1;
			}
		});
		boolean flag = false;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N;j++) {
				map[i][j] = s.charAt(j);
				if(s.charAt(j)=='#') {
					if(!flag) {
						flag= true;
						sRow = i;
						sCol = j;
					}
					else {
						eRow = i;
						eCol = j;
					}
				}
			}
		}
		int tx=0,ty=0;
		for(int d=0;d<4; d++) {
			tx = sRow + dx[d];
			ty = sCol + dy[d];

			if(tx<0 || tx>=N || ty<0 || ty>=N || map[tx][ty] =='*') {
				continue;
			}

			if(map[tx][ty] =='!') {
				for(int dd=0; dd<4; dd++) {
					if(d ==dd || (d+2)%4 == dd) {
						continue;
					}
					check[tx][ty][dd] = true;
					pq1.offer(new Node(tx,ty,dd,1));
				}
			}
			check[tx][ty][d] = true;
			pq1.offer(new Node(tx,ty,d,0));

		}


		while(!pq1.isEmpty()) {
			Node e1 = pq1.poll();

			if(e1.x == eRow && e1.y == eCol) {
				System.out.println(e1.cnt);
				break;
			}




			tx = e1.x + dx[e1.d];
			ty = e1.y + dy[e1.d];

			if(tx<0 || tx>=N || ty<0 || ty>=N || map[tx][ty] =='*' || check[tx][ty][e1.d] == true) {
				continue;
			}

			if(map[tx][ty] =='!') {
				
				for(int dd=0; dd<4; dd++) {
					if(e1.d ==dd || (e1.d+2)%4 == dd) {
						continue;
					}
					pq1.offer(new Node(tx,ty,dd,e1.cnt+1));
				}
			}
			
			check[tx][ty][e1.d] = true;
			pq1.offer(new Node(tx,ty,e1.d,e1.cnt));

		



		}



	}

}
