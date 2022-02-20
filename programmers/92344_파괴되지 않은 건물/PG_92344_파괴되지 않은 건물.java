package 프로그래머스;

public class PG92344파괴되지않은건물 {

	public static void main(String[] args) {
		int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
		Solution solution = new Solution();
		int answer = solution.solution(board, skill);
		System.out.println(answer);
	}
	
	static class Solution {
		int[][] tempBoard;
		int N,M;
		public int solution(int[][] board, int[][] skill) {
	        int answer = 0;
	        N = board.length;
	        M = board[0].length;
	        tempBoard = new int[N+1][M+1];
	        int size = skill.length;
	        int type=0,r1=0,c1=0,r2=0,c2=0,degree=0;
	        
	        for(int i=0; i<size; i++) {
	        	type = skill[i][0];
	        	r1 = skill[i][1];
	        	c1 = skill[i][2];
	        	r2 = skill[i][3];
	        	c2 = skill[i][4];
	        	degree = skill[i][5];
	        	degree = (type == 1) ? -degree : degree;
	        	tempBoard[r1][c1] += degree;
	        	tempBoard[r1][c2+1] += -degree;
	        	tempBoard[r2+1][c1] += -degree;
	        	tempBoard[r2+1][c2+1] += degree;
	        }
	        int sum=0;
	        for(int i=0; i<N+1; i++) {
	        	sum =0;
	        	for(int j=0; j<M+1; j++) {
	        		sum += tempBoard[i][j];
	        		tempBoard[i][j] = sum;
	        	}
	        }
	        
	        for(int i=0; i<M+1; i++) {
	        	sum =0;
	        	for(int j=0; j<N+1; j++) {
	        		sum += tempBoard[j][i];
	        		tempBoard[j][i] = sum;
	        	}
	        }
	        
	        for(int i=0; i<N; i++) {
	        	for(int j=0; j<M; j++) {
	        		board[i][j] += tempBoard[i][j];
	        		if(board[i][j] >0) {
	        			answer++;
	        		}
	        	}
	        }
	        return answer;
	    }
	}
}
