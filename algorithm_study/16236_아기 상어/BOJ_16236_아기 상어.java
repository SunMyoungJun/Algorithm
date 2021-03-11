import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,fishx,fishy,resultx,resulty,sec,eat;
	static int MIN=100,fishsize=2;
	static boolean tf;
	static int[][] map;
	static boolean[][] check;
	static Queue<int[]> q1 = new LinkedList<int[]>();
	static Queue<int[]> q2 = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==9) {
					fishx =i;
					fishy =j;
				}
			}
		}
		map[fishx][fishy] =0;
		while(true) {
			resultx =-1;
			resulty =-1;
			MIN = Integer.MAX_VALUE;

			if(!Search()) { //최소거리 작은물고기까지 갈수 있는 경우까지
				System.out.println(sec);
				return;
			}

		}

	}

	static boolean Search() {
		int tfs=0;
		int temp=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0 && map[i][j] <fishsize) {
					temp=checkmin(i,j);
					
					if(MIN > temp) {  //거리가 더 짧을 때
						MIN = temp;
						resultx = i;
						resulty=  j;
						tfs=1;
					}
					else if(MIN == temp) { //거리 같으면 
						if(resultx > i) {   //더 위에있는 물고기
							resultx = i;
							resulty = j;
						}
						else if(resultx == i) {  //같은 높이일 때 더 왼쪽에 있는 물고기
							if(resulty > j) {
								resultx =i;
								resulty =j;
							}
						}
					}
				}
			}
		}

		if(tfs==0) {
			return false;
		}
		
		sec +=MIN;
		eat++;
		if(eat == fishsize) {
			eat =0;
			fishsize++;
		}
		map[resultx][resulty]=0;
		fishx = resultx;
		fishy = resulty;
		
		return true;
	}

	static int checkmin(int row,int col) {
		int size =0,tx=0,ty=0,distance=0;
		int[] p1;

		check = new boolean[N][N];
		q1.offer(new int[] {fishx,fishy});
		while(!q1.isEmpty()) {
			size = q1.size();


			for(int t=0;t<size;t++) {
				p1 = q1.poll();

				if(p1[0] == row && p1[1] ==col) {
					q1.clear();
					return distance;
				}		
				for(int i=0;i<4;i++) {
					tx = p1[0] + dx[i];
					ty = p1[1] + dy[i];
					if(tx<0 || ty<0 || tx>=N || ty >=N || check[tx][ty] ==true ||map[tx][ty]>fishsize) {
						continue;
					}

					check[tx][ty] = true;
					q1.offer(new int[] {tx,ty});
				}
			}
			distance++;	
		}
		return Integer.MAX_VALUE;	
	}
}
