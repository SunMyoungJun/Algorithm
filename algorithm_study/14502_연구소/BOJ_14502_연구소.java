import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] mat,mat2;
	static boolean[][] check;
	static int[] virus;
	static Queue<int[]> q1,q2;
	static int row,col,max =Integer.MIN_VALUE,sum=0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int virusnum,viruscount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q1 = new LinkedList<int[]>();
		q2 = new LinkedList<int[]>();
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		mat = new int[row][col];
		mat2 = new int[row][col];
		check = new boolean[row][col];
		for(int i=0;i<row;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<col;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				mat2[i][j] = mat[i][j];
				if(mat[i][j] ==2) {
					q1.offer(new int[] {i,j});
					q2.offer(new int[] {i,j}); // 복사본 //
					virusnum++;
				}
			}
		}


		dfs(0);
		System.out.println(max);

	}

	static void dfs(int cnt) {
		viruscount=0;
		if(cnt == 3) {
			
			bfs();
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					if(mat2[i][j] ==0) {
						sum++;
					}
					else if(mat2[i][j] == 2) {
						viruscount++;
					}
				}
			}
			
			max = (max > sum) ? max : sum;
			sum=0;
			viruscount=0;
			check = new boolean[row][col];
//			System.arraycopy(q1,0, q2, 0, q1.size());        
			for(int i=0;i<row;i++) {  //기존입력 배열 복사.
				for(int j=0;j<col;j++) {
					if(mat2[i][j] !=1) {     //바이러스(2)로 덮어진  지역 다시 원래대로 초기화
						mat2[i][j] = mat[i][j];
					}
				}
			}
			int[] p1;
			int size = q1.size();
			
			for(int i=0;i<size;i++) {
				p1 = q1.poll();
				q1.offer(p1);
				q2.offer(p1);
			}
			return;
		}

		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(mat2[i][j] == 0) {
					mat2[i][j] =1;
					dfs(cnt+1);
					mat2[i][j] =0;
				}
			}
		}
	}

	static void bfs() {
		int tx=0,ty=0;
		while(!q2.isEmpty()) {
			int size = q2.size();


			for(int i=0;i<size;i++) {
				virus = q2.poll();
				check[virus[0]][virus[1]] = true;
				for(int j=0; j<4;j++) {
					tx = virus[0] +dx[j];
					ty = virus[1] +dy[j];
					if(tx <0 || tx >=row ||ty <0 ||ty >=col || mat2[tx][ty] !=0 || check[tx][ty] ==true) {  //행열 범위 벗어나거나 바이러스퍼질공간 아니면
						continue;
					}
					q2.offer(new int[]{tx,ty});
					check[tx][ty] = true;  //바이러스가 퍼졋다고 설정
					mat2[tx][ty] =2;       // 퍼진구역 바이러스가있다고 2로 설정.
				}
			}
		}
	}

}
