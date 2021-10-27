import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<Node> q1 = new LinkedList<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class Node {
		int x;
		int y;
		int die;

		public Node(int x,int y,int die) {
			this.x = x;
			this.y = y;
			this.die = die;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][] check = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j)-'0';
				check[i][j] = Integer.MAX_VALUE;
			}
		}
		check[0][0] = 0;
		q1.offer(new Node(0,0,0));
		Node e;
		int tx=0,ty=0,min=Integer.MAX_VALUE;
		while(!q1.isEmpty()) {
			e = q1.poll();
			if(e.x == n-1 && e.y == n-1) {
				min = (min > e.die) ? e.die : min;
			}
			for(int i=0; i<4; i++) {
				tx = e.x + dx[i];
				ty = e.y + dy[i];
				
				if(tx<0 || tx>=n || ty<0 || ty>=n) {
					continue;
				}
				if(map[tx][ty] == 1 && check[tx][ty] > e.die) {
					check[tx][ty] = e.die;
					q1.offer(new Node(tx,ty,e.die));
				}
				else if(map[tx][ty] ==0 && check[tx][ty] > e.die+1) {
					check[tx][ty] = e.die+1;
					q1.offer(new Node(tx,ty,e.die+1));
				}
			}
			
			
		}

		System.out.println(min);
	}

}