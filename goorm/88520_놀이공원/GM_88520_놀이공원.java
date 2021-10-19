import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	static int min,N,K;
	static int[][] wastes;
	public static void testCase(int caseIndex) {
		N = scanner.nextInt();  // 지도의 크기 
		K = scanner.nextInt();  // 놀이공원의 크기
		min = Integer.MAX_VALUE;
		wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부 
		for (int r = 0; r < N; r += 1) {
			for (int c = 0; c < N; c += 1) {
				wastes[r][c] = scanner.nextInt();
			}
		}
		
		int len = N-K;
		
		for(int i=0; i<=len; i++) {
			for(int j=0; j<=len; j++) {
				check(i,j,len);
			}
		}
				
		
		System.out.println(min);
	}
	
	public static void check(int row,int col,int len) {
		int sum=0;
		for(int i=row; i<row+K; i++) {
			for(int j=col; j<col+K; j++) {
				if(wastes[i][j] == 1) {
					sum += 1;
				}
			}
		}
		
		min = (min < sum) ? min : sum;
	}
	
	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();
		
		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
		
	}
	
}