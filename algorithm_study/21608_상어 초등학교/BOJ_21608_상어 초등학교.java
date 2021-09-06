import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int n,one,two,three,four;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] mat;
	static int[][] like;
	static Queue<Node> q1;
	static class Node{
		int x;
		int y;
		int w; // 인접 원하는 칸이 가장 많을 때
		int b; //
		
		public Node(int x,int y,int w,int b) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.b = b;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = N * N;
		StringTokenizer st = null;
		mat = new int[N][N];
		like = new int[M+1][4];
		for(int i=0; i< M; i++) {
			q1 = new LinkedList<Node>();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			one = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());
			three = Integer.parseInt(st.nextToken());
			four = Integer.parseInt(st.nextToken());
			
			like[n][0] = one;
			like[n][1] = two;
			like[n][2] = three;
			like[n][3] = four;
			
			likeOne();
			Node n1 = q1.poll();
			mat[n1.x][n1.y] = n;
		}
				
		
		int sum = likeSum();
		System.out.println(sum);
		
	}
	
	static int likeSum() {
		int sum =0,num1=0,cnt=0, tx=0,ty=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cnt=0;
				num1 = mat[i][j];
				for(int d=0; d<4; d++) {
					tx = i+dx[d];
					ty = j+dy[d];
					if(tx<0 || tx>=N || ty<0 || ty>=N) {
						continue;
					}
					if(mat[tx][ty] == like[num1][0] || mat[tx][ty] == like[num1][1]
							|| mat[tx][ty] == like[num1][2] || mat[tx][ty] == like[num1][3]){
						cnt++;
					}
				}
				
				if(cnt ==1) {
					sum += 1;
				}
				else if(cnt == 2) {
					sum += 10;
				}
				else if(cnt == 3) {
					sum += 100;
				}
				else if(cnt == 4) {
					sum += 1000;
				}
			}
		}
		
		
		
		
		return sum;
	}
	
	static void likeOne() {		
		int tx=0,ty=0,cnt=0,cnt2=0,max=-1,max2=-1,min= 500,min2 = 500;
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				if(mat[i][j] !=0) {
					continue;
				}
				cnt = 0; cnt2=0;
				for(int d=0; d<4; d++) {
					tx = i+dx[d];
					ty = j+dy[d];
					
					if(tx<0 || tx>=N || ty<0 || ty>=N) {
						continue;
					}
					
					
					if(mat[tx][ty] == one || mat[tx][ty] == two
							|| mat[tx][ty] == three || mat[tx][ty] == four){
						cnt++;
					}
					if(mat[tx][ty] == 0) {
						cnt2++;
					}
				}
				
				if(cnt > max) {
					max = cnt;
					max2 = cnt2;
					min = i;
					min2 = j;
					q1.clear();
					q1.offer(new Node(i,j,cnt,cnt2));
				}
				else if(cnt == max) {
					if(cnt2 > max2) {
						max2 = cnt2;
						min = i;
						min2 = j;
						q1.clear();
						q1.offer(new Node(i,j,cnt,cnt2));
					}
					else if(cnt2 == max2) {
						if(min >i) {
							min = i;
							min2 = j;
							q1.clear();
							q1.offer(new Node(i,j,cnt,cnt2));
						}
						else if(min == i) {
							if(min2 > j) {
								min2 = j;
								q1.clear();
								q1.offer(new Node(i,j,cnt,cnt2));
							}
						}
					}
				}
			}
		}
		
		
		
	}
}
