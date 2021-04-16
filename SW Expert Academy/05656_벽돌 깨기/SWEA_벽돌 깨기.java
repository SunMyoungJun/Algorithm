import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,W,H;

	static int MIN;
	static Queue<Node> q1 = new LinkedList<Node>();
	static class Node {
		int x,y,area;

		public Node(int x, int y, int area) {
			this.x = x;
			this.y = y;
			this.area = area;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<test+1;t++) {
			MIN = Integer.MAX_VALUE;
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0,map);
			sb.append("#").append(t).append(" ").append(MIN).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int cnt,int[][] tmap) {
		if(cnt == N) {
			result(tmap);
			return;
		}

		int[][] temparr1;

		for(int i=0;i<W;i++) {
			temparr1 = deepcopy(tmap);

			bomb(temparr1,i);
			dfs(cnt+1,temparr1);

		}
	}

	private static void result(int[][] tmap) {
		int cnt =0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(tmap[i][j] !=0) {
					cnt++;
				}
			}
		}
		MIN = (MIN < cnt) ? MIN : cnt;
	}

	static void bomb(int[][] temparr1,int col) {
		boolean[][] check = new boolean[H][W];

		Node p1;
		for(int i=0;i<H;i++) {
			if(temparr1[i][col] >0) {
				check[i][col] = true;
				q1.offer(new Node(i,col,temparr1[i][col]));
				break;
			}
		}

		while(!q1.isEmpty()) {
			p1 = q1.poll();

			for(int d=0;d<4;d++) {
				checkArea(d,p1.x,p1.y,p1.area,check,temparr1);
			}		
		}

		deleteBlock(temparr1,check);


	}


	static void deleteBlock(int[][] temparr1, boolean[][] check) {

		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(check[i][j] == true) {
					temparr1[i][j] = 0;
				}
			}
		}

		for(int i=H-1;i>=1; i--) {
			for(int j=0;j<W;j++) {
				if(temparr1[i][j] ==0) {
					boolean tf = false;
					for(int k=i;k>=1;k--) {
						if(temparr1[k-1][j] !=0) {
							tf = true;
						}
						temparr1[k][j] = temparr1[k-1][j];
					}
					temparr1[0][j] = 0;
					if(tf) {
						j--;
					}

				}
			}
		}




	}

	static void checkArea(int dir,int x,int y,int area,boolean[][] check,int[][] temparr1) {

		while(area-- != 1) {
			x = x+dx[dir];
			y = y+dy[dir];

			if(x<0 || x>=H || y<0 || y>=W) {
				return;
			}
			if(check[x][y] == true || temparr1[x][y] ==0) {
				continue;
			}
			if(temparr1[x][y] ==1) {
				check[x][y] = true;
			}
			check[x][y] = true;
			q1.offer(new Node(x,y,temparr1[x][y]));
		}
	}


	static int[][] deepcopy(int[][] tmap) {
		int[][] temparr1 = new int[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				temparr1[i][j] = tmap[i][j];
			}
		}
		return temparr1;
	}
}
