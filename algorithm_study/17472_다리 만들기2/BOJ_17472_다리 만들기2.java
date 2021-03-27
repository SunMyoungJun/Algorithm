import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,len;
	static int ttx,tty;
	static int cnt=2;
	static int[] dx  = {-1,0,1,0};
	static int[] dy  = {0,1,0,-1};
	static boolean[] check;
	static int[][] check2;
	static int[] parents;
	static int MIN = Integer.MAX_VALUE;
	static Queue<int[]> q1 = new LinkedList<int[]>();
	static PriorityQueue<int[]> q2 = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return (o1[2] > o2[2]) ? 1: -1;
		}
	});
	static ArrayList<ArrayList<land>> arr1 = new ArrayList<ArrayList<land>>();
	static int[][] map;
	static class land {
		int x,y;

		public land(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {  //입력
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] ==1) {
					q1.offer(new int[] {i,j});
					map[i][j] = cnt;
					bfs(cnt);
					cnt++;
				}
			}
		}
		check = new boolean[cnt];	
		check2 = new int[cnt][cnt];
		for(int i=0;i<cnt;i++) {
			arr1.add(new ArrayList<land>());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] !=0) {
					arr1.get(map[i][j]).add(new land(i,j));
				}
			}
		}
		
		for(int i=2; i<arr1.size();i++) {
			street(i);
			check[i] = true;
		}
		
		parents = new int[cnt];
		
		for(int i=0;i<cnt;i++) {
			parents[i] =i;
		}
		int sums =0;
		int ccount=0;
		while(!q2.isEmpty()) {
			int n1=0,n2=0;
			
			int [] p1 = q2.poll();
			n1 = p1[0];
			n2 = p1[1];
			
			if(union(n1,n2)) {
				sums += p1[2];
				ccount++;
			}
			
		}
		if(ccount == cnt-3) {
			System.out.println(sums);
		}
		else {
			System.out.println("-1");
		}

	}

	 static boolean union(int n1, int n2) {
		int nn1 = findSet(n1);
		int nn2 = findSet(n2);
		
		
		 if(nn1 ==nn2) {
			 return false;
		 }
		 parents[nn2] = nn1;
		 return true;
	}

	 static int findSet(int n2) {
		 if(parents[n2] == n2) {
			 return n2;
		 }
		return parents[n2] = findSet(parents[n2]);
	}

	static void street(int num) {
		
		int lens=1;
		int MIN = Integer.MAX_VALUE;
		boolean flag = false;
		for(int i=0;i<arr1.get(num).size(); i++) {
			
			for(int d=0;d<4;d++) {
				lens=0;
				ttx=arr1.get(num).get(i).x;
				tty=arr1.get(num).get(i).y;
				flag = false;
				while(true) {
					ttx =ttx + dx[d];
					tty = tty + dy[d];
					if(ttx<0 | ttx>= N || tty <0 || tty>=M) {
						flag = false;
						break;
					}
					else if(map[ttx][tty] >0) {
						flag = true;
						break;
					}
					lens++;
				}
				
				if(flag && lens >1 && !check[map[ttx][tty]]) {
					int t1 = map[ttx][tty];
					if(check2[num][t1]!=0 && check2[num][t1] >lens) {
						q2.offer(new int[] {num,t1,lens});
						check2[num][t1] = lens;
					}
					else if(check2[num][t1] ==0) {
						q2.offer(new int[] {num,t1,lens});
						check2[num][t1] = lens;
					}
					
				}
			}
		}	
	}
	
	static void bfs(int cnt) {

		int tx =0,ty=0;
		int[] p1;
		while(!q1.isEmpty()) {
			p1 = q1.poll();
			for(int i=0;i<4;i++) {
				tx = p1[0] +dx[i];
				ty = p1[1] + dy[i];
				if(tx<0 || tx>=N || ty<0 || ty>=M || map[tx][ty] !=1) {
					continue;
				}
				map[tx][ty] = cnt;
				q1.offer(new int[] {tx,ty});
			}
		}
	}
}