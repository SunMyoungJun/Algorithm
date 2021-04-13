import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static ArrayList<Integer>[][] arr1;
	
	
	static Queue<int[]> q1;


	static int M,BC;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st= null;
		int test = Integer.parseInt(br.readLine());


		for(int t =1; t<test+1;t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());  // 시간
			BC = Integer.parseInt(st.nextToken()); //충전기

			int[] A = new int[M];
			int[] B = new int[M];
			int[] charge = new int[BC+1];
			arr1 = new ArrayList[11][11];
			for(int i=1;i<11;i++) {
				for(int j=1;j<11;j++) {
					arr1[i][j] = new ArrayList<Integer>();
					arr1[i][j].add(0);
				}
			}



			st = new StringTokenizer(br.readLine());  // A번 사용자
			for(int i=0; i<M;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());  // B번 사용자
			for(int i=0; i<M;i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			int result =0;
			for(int i=1; i<BC+1;i++) {
				
				st = new StringTokenizer(br.readLine());
				int row=0,col=0,area=0,P=0;
				col = Integer.parseInt(st.nextToken());
				row = Integer.parseInt(st.nextToken());
				area = Integer.parseInt(st.nextToken());
				P = Integer.parseInt(st.nextToken());
				charge[i] = P;  // i번째 충전량
				q1 =  new LinkedList<int[]>();

				arr1[row][col].add(i);
				q1.offer(new int[] {row,col});

				bfs(area,row,col,i);
				
			}
			int Ax =1,Ay=1, Bx=10,By=10;
			int mmax=0;
			for(int j=0;j<arr1[Ax][Ay].size();j++) {
				mmax = (mmax < charge[arr1[Ax][Ay].get(j)]) ? charge[arr1[Ax][Ay].get(j)]: mmax;
			}
			result += mmax;
			mmax=0;
			
			for(int j=0;j<arr1[Bx][By].size();j++) {
				mmax = (mmax < charge[arr1[Bx][By].get(j)]) ? charge[arr1[Bx][By].get(j)]: mmax;
			}
			result += mmax;
			
			for(int j=0;j<M;j++) {
				Ax = Ax + dx[A[j]];
				Ay = Ay + dy[A[j]];

				Bx = Bx + dx[B[j]];
				By = By + dy[B[j]];

				int Asize = arr1[Ax][Ay].size();
				int Bsize = arr1[Bx][By].size();
				int Amax =0,Bmax=0;
				int Anum =0,Bnum=0;
				int Apremax=0,Aprenum=0;
				int Bpremax=0,Bprenum=0;
				if(Asize !=1) {
					for(int k =0; k<Asize;k++) {
						if(Amax < charge[arr1[Ax][Ay].get(k)]) {
							Apremax = Amax;
							Amax = charge[arr1[Ax][Ay].get(k)];
							Aprenum = Anum;
							Anum = arr1[Ax][Ay].get(k);
						}
						else if(Apremax < charge[arr1[Ax][Ay].get(k)]) {
							Apremax = charge[arr1[Ax][Ay].get(k)];
							Aprenum = arr1[Ax][Ay].get(k);
						}
					}
				}
				if(Bsize !=1) {
					for(int k =0; k<Bsize;k++) {
						if(Bmax < charge[arr1[Bx][By].get(k)]) {
							Bpremax = Bmax;
							Bmax = charge[arr1[Bx][By].get(k)];
							Bprenum = Bnum;
							Bnum = arr1[Bx][By].get(k);
						}
						else if(Bpremax < charge[arr1[Bx][By].get(k)]) {
							Bpremax = charge[arr1[Bx][By].get(k)];
							Bprenum = arr1[Bx][By].get(k);
						}
					}
				}
				int kk=0;
				if(Anum == Bnum){
					result += Amax + Math.max(Apremax, Bpremax);
				}
				else {
					result += Amax + Bmax;
				}
			}


			sb.append("#").append(t).append(" ").append(result).append("\n");			
		}
		
		System.out.println(sb.toString());


	}

	static void bfs(int area, int charx, int chary,int cnt) {
		boolean[][] check = new boolean[11][11];
		check[charx][chary] = true;
		int tx=0,ty=0;

		while(!q1.isEmpty()) {

			int[] p1 = q1.poll();


			for(int i=1; i<=4;i++) {
				tx = p1[0] + dx[i];
				ty = p1[1] + dy[i];


				if(tx<=0 || tx>=11 || ty<=0 || ty>=11 || check[tx][ty] ==true) {
					continue;
				}

				int num= Math.abs(tx - charx) + Math.abs(ty - chary);
				if(area < num) {
					continue;
				}

				check[tx][ty] = true;
				q1.offer(new int[] {tx,ty});
				arr1[tx][ty].add(cnt);	 
			}
		}
	}

}
