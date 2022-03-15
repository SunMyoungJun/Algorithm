package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class PG60063블록이동하기 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] board={{0,0,1,0},{0,0,0,0},{1,0,0,0},{1,1,1,0}};

		System.out.println(solution.solution(board));



	}
	static class Solution {
		int[] dx1 = {-1,0,1,0};
		int[] dy1 = {0,1,0,-1};
		int[] dx2 = {0,1,0,-1};
		int[] dy2 = {1,0,-1,0};
		int[][][] check;
		Queue<Node> q1 = new LinkedList<>();
		class Node {
			int[] n1;
			int[] n2;
			int dis;
			int dir;
			public Node(int[] n1, int[] n2,int dis,int dir) {
				this.n1 = n1;
				this.n2 = n2;
				this.dis = dis;
				this.dir = dir;
			}
		}
		public int solution(int[][] board) {
			int answer =0,tx=0,ty=0,tx2=0,ty2=0;
			q1.offer(new Node(new int[] {0,0},new int[] {0,1},0,0));
			int N = board.length;
			check = new int[N][N][2]; // 수평, 수직
			check[0][1][0] = -1;

			boolean flag = false,flag2=false;
			while(!q1.isEmpty()) {
				flag = true;
				flag2 = true;
				Node e1 = q1.poll();
				if(e1.n2[0] == N-1 && e1.n2[1] == N-1) {
					answer = e1.dis;
					break;
				}
				for(int d=0; d<3; d++) {
					if(e1.dir == 0) {
						tx = e1.n1[0] + dx1[d];
						ty = e1.n1[1] + dy1[d];
						tx2 = e1.n2[0] + dx1[d];
						ty2 = e1.n2[1] + dy1[d];
					}
					else {
						tx = e1.n1[0] + dx2[d];
						ty = e1.n1[1] + dy2[d];
						tx2 = e1.n2[0] + dx2[d];
						ty2 = e1.n2[1] + dy2[d];
					}

					if(tx<0 || tx2<0 || tx>=N || tx2 >=N || ty<0 || ty2<0 || ty>=N || ty2>=N) {
						continue;
					}
					if(check[tx2][ty2][e1.dir] !=0 && check[tx2][ty2][e1.dir] <= e1.dis+1) {
						continue;
					}
					if(board[tx][ty] == 1 || board[tx2][ty2] == 1) {
						continue;
					}
					check[tx2][ty2][e1.dir] = e1.dis+1;
					System.out.println(tx2+" "+ty2+" "+ (e1.dis+1)+ " "+ e1.dir);
					q1.offer(new Node(new int[] {tx,ty},
							new int[] {tx2,ty2},e1.dis+1,e1.dir));
				}
				
				if(e1.dir == 0) {
					tx = e1.n1[0] + dx1[3];
					ty = e1.n1[1] + dy1[3];
					tx2 = e1.n1[0];
					ty2 = e1.n1[1];
				}
				else {
					tx = e1.n1[0] + dx2[3];
					ty = e1.n1[1] + dy2[3];
					tx2 = e1.n1[0];
					ty2 = e1.n1[1];
				
				}
				if(tx<0 || tx2<0 || tx>=N || tx2 >=N || ty<0 || ty2<0 || ty>=N || ty2>=N) {
					flag = false;
				}
				else if(board[tx][ty] == 1 || board[tx2][ty2] == 1) {
					flag = false;
				}
				else if(check[tx2][ty2][e1.dir] ==0 || check[tx2][ty2][e1.dir] > e1.dis+1) {
					check[tx2][ty2][e1.dir] = e1.dis+1;
					System.out.println(tx2+" "+ty2+" "+ (e1.dis+1)+ " "+ e1.dir);
					q1.offer(new Node(new int[] {tx,ty},e1.n1,e1.dis+1,e1.dir));
				}		
				
				flag = true;
				flag2 = true;
				if(e1.dir == 0) { // 회전 보기
					tx = e1.n1[0] +1;
					ty = e1.n1[1];

					tx2 = e1.n2[0] +1;
					ty2 = e1.n2[1];

					if(tx<0 || tx2<0 || tx>=N || tx2 >=N || ty<0 || ty2<0 || ty>=N || ty2>=N) {
						flag = false;
					}
					else if(board[tx][ty] == 1 || board[tx2][ty2] == 1) {
						flag = false;
					}
					if(flag && (check[tx][ty][1] ==0 || check[tx][ty][1] > e1.dis+1)) {
						System.out.println(tx+" "+ty+" "+ (e1.dis+1)+ " "+ 1);
						check[tx][ty][1] = e1.dis+1;
						q1.offer(new Node(e1.n1,new int[] {tx,ty},e1.dis+1,1));
					}
					if(flag && (check[tx2][ty2][1] ==0 || check[tx2][ty2][1] > e1.dis+1)) {
						System.out.println(tx2+" "+ty2+" "+ (e1.dis+1)+ " "+ 1);
						check[tx2][ty2][1] = e1.dis+1;
						q1.offer(new Node(e1.n2,new int[] {tx2,ty2},e1.dis+1,1));
					}
					
					tx = e1.n1[0]-1;
					tx2 = e1.n2[0]-1;
					if(tx<0 || tx2<0 || tx>=N || tx2 >=N || ty<0 || ty2<0 || ty>=N || ty2>=N) {
						flag2=false;
					}
					else if(board[tx][ty] == 1 || board[tx2][ty2] == 1) {
						flag2=false;
					}
					if(flag2 && (check[e1.n1[0]][e1.n1[1]][1] ==0 || check[e1.n1[0]][e1.n1[1]][1] > e1.dis+1)) {
						check[e1.n1[0]][e1.n1[1]][1] = e1.dis+1;
						System.out.println(e1.n1[0]+" "+e1.n1[1]+" "+ (e1.dis+1)+ " "+ 1);
						q1.offer(new Node(new int[] {tx,ty},e1.n1,e1.dis+1,1));
					}
					if(flag2 && (check[e1.n2[0]][e1.n2[1]][1] ==0 || check[e1.n2[0]][e1.n2[1]][1] > e1.dis+1)) {
						check[e1.n2[0]][e1.n2[1]][1] = e1.dis+1;
						System.out.println(e1.n2[0]+" "+e1.n2[1]+" "+ (e1.dis+1)+ " "+ 1);
						q1.offer(new Node(new int[] {tx2,ty2},e1.n2,e1.dis+1,1));
					}
				}
				else {
					tx = e1.n1[0];
					ty = e1.n1[1]+1;
					tx2 = e1.n2[0];
					ty2 = e1.n2[1]+1;
					if(tx<0 || tx2<0 || tx>=N || tx2 >=N || ty<0 || ty2<0 || ty>=N || ty2>=N) {
						flag2 = false;
					}
					else if(board[tx][ty] == 1 || board[tx2][ty2] == 1) {
						flag2 = false;
					}
					if(flag2 && (check[tx][ty][0] ==0 || check[tx][ty][0] > e1.dis+1)) {
						check[tx][ty][0] = e1.dis+1;
						System.out.println(tx+" "+ty+" "+ (e1.dis+1)+ " "+ 0);
						q1.offer(new Node(e1.n1,new int[] {tx,ty},e1.dis+1,0));
					}
					if(flag2 && (check[tx2][ty2][0] ==0 || check[tx2][ty2][0] > e1.dis+1)) {
						check[tx2][ty2][0] = e1.dis+1;
						System.out.println(tx2+" "+ty2+" "+ (e1.dis+1)+ " "+ 0);
						q1.offer(new Node(e1.n2,new int[] {tx2,ty2},e1.dis+1,0));
					}
					
					ty = e1.n1[1]-1;
					ty2 = e1.n2[1]-1;
					flag2 = true;
					if(tx<0 || tx2<0 || tx>=N || tx2 >=N || ty<0 || ty2<0 || ty>=N || ty2>=N) {
						flag2 = false;
					}
					else if(board[tx][ty] == 1 || board[tx2][ty2] == 1) {
						flag2 = false;
					}
					if(flag2 && (check[e1.n1[0]][e1.n1[1]][0] ==0 || check[e1.n1[0]][e1.n1[1]][0] > e1.dis+1)) {
						check[e1.n1[0]][e1.n1[1]][0] = e1.dis+1;
						System.out.println(e1.n1[0]+" "+e1.n1[1]+" "+(e1.dis+1)+ " "+ 0);
						q1.offer(new Node(new int[] {tx,ty},e1.n1,e1.dis+1,0));
					}
					if(flag2 && (check[e1.n2[0]][e1.n2[1]][0] ==0 || check[e1.n2[0]][e1.n2[1]][0] > e1.dis+1)) {
						check[e1.n2[0]][e1.n2[1]][0] = e1.dis+1;
						System.out.println(e1.n2[0]+" "+e1.n2[1]+" "+ (e1.dis+1)+ " "+0);
						q1.offer(new Node(new int[] {tx2,ty2},e1.n2,e1.dis+1,0));
					}
				}
			}




			return answer;
		}


	}

}
