import java.util.Scanner;

public class Main {
	static long SUM;
	static int N;
	static long[][] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		check = new long[10][N];
		SUM =dfs(0,0);
		for(int i=0;i<10;i++) {
			
		}
		System.out.println(SUM % 10007);
	}
	
	static long dfs(int cnt,int start) {  //DP
		long tempsum =0,tempnum=0;
		if(cnt == N)	
			return 1;
		
		for(int i= start;i<10;i++) {			// 이미 check배열에 저장되있으면 dfs안들어감.
			if(check[i][N-1-cnt] !=0) {        //[n][m] n->1~10   ㅡ  m -> 뒤에 남은 자리수
				tempsum+= check[i][N-1-cnt];
				continue;
			}
			tempnum = dfs(cnt+1,i) %10007;
			check[i][N-1-cnt] = tempnum;
			tempsum +=tempnum;
		}
		return tempsum;
	}
}