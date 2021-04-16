import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int count;
	static Queue<int[]> q1;
	static Character[][] map;
	static boolean[][] check = new boolean[5][5];
	static ArrayList<int[]> arr1 = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		map = new Character[5][5];
		for(int i=0;i<5;i++) {
			s = br.readLine();
			for(int j=0;j<5;j++) {
				map[i][j] = s.charAt(j);
				arr1.add(new int[] {i,j});
			}
		}

		dfs(0,0,0,0);

		System.out.println(count);


	}

	static void dfs(int cnt,int S,int Y,int idx) {
		int[] p1;
		if(cnt == 7) {
			if(near()) {
				count++;
			}
			return;
		}


		for(int t=idx;t<arr1.size();t++) {
			p1 = arr1.get(t);
			int i = p1[0];
			int j = p1[1];
			if(map[i][j] == 'Y') {
				if(Y+1 >=4) {
					continue;
				}
				check[i][j] = true;
				dfs(cnt+1,S,Y+1,t+1);
			}
			else {
				check[i][j] = true;
				dfs(cnt+1,S+1,Y,t+1);
			}
			check[i][j] = false;
		}

	}

	private static boolean near() {
		q1 = new LinkedList<int[]>();	
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(check[i][j] == true) {
					q1.offer(new int[] {i,j});
					if(bfs()) {
						return true;
					}
					else {
						return false;
					}

				}
			}
		}
		return false;
	}

	private static boolean bfs() {
		boolean[][] check2 = new boolean[5][5];
		int[] p1;
		int tx=0,ty=0;
		int cnt2 =1;
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			check2[p1[0]][p1[1]] = true;
			for(int d=0;d<4;d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];

				if(tx<0 || tx>=5 || ty<0 || ty>=5 || check2[tx][ty] == true) {
					continue;
				}

				if(check[tx][ty] == false) {
					continue;
				}

				check2[tx][ty] = true;
				q1.offer(new int[] {tx,ty});
				cnt2++;
			}
		}

		if(cnt2 == 7) {
			return true;
		}
		else
			return false;
	}
}