import java.util.Scanner;

public class Main {
	static int N;
	static long count,temp1;
	static long[][] arr1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr1 = new long[10][N];
		
		for(int i=1;i<10;i++)
			count = (count+dfs(i,1)) %1000000000;

		System.out.println(count);
	}
	
	static long dfs(int num,int cnt) {
		long sum =0;
		if(cnt ==N)
			return 1;
		
		if(arr1[num][N-cnt] !=0)
			return arr1[num][N-cnt];
		
		if(num-1 >=0) {
			temp1 = dfs(num-1,cnt+1) %1000000000;
			sum = sum +temp1;
			arr1[num][N-cnt] = (arr1[num][N-cnt] + temp1) %1000000000;
		}
		if(num+1 <10) {
			temp1 = dfs(num+1,cnt+1) %1000000000;
			sum = sum + temp1;
			arr1[num][N-cnt] = (arr1[num][N-cnt] + temp1) %1000000000;
		}
		return sum;
	}
}