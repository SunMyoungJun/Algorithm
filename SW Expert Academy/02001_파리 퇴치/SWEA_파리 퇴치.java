import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int N,M;
	static int[][] arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		int max=0,sum=0;
		for(int t=1; t<test+1;t++) {
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  //행렬 크기
			M = Integer.parseInt(st.nextToken());  //파리채 크기
			arr1 = new int[N][N];
			 sum=0;
			for(int i=0;i<N;i++) {  			//입력
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr1[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					sum = arr1_func(i,j,M);
					max = (sum > max) ? sum : max;
				}
			}
			
			System.out.println("#"+t+" "+max);
		}

	}

	static int arr1_func(int row,int col,int size) {   //시작 행 , 렬 , 파리채크기
		int sum=0;
		for(int i=row; i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				sum +=arr1[i][j];
			}
		}
	
		return sum;
	}
	
	
}
