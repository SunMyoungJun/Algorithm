import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int N,MIN,sum;
	static int[][] arr1;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		
		for(int t =1; t<test+1;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr1 = new int[N][N];
			check = new boolean[N];
			MIN = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr1[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0);
			sb.append("#").append(t).append(" ").append(MIN).append("\n");
		}
		System.out.println(sb.toString());
		
	}

	static void dfs(int cnt,int start) {
		if(cnt ==N/2) {
			compare();
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(check[i] ==true)
				continue;
			
			check[i] =true;
			dfs(cnt+1,i+1);
			check[i] =false;
		}
		
	}
	
	static void compare() {
		int temp1=0,temp2=0;
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(check[i] ==true && check[j] == true) {
					temp1 = temp1 + arr1[i][j];
				}
				else if(check[i] ==false && check[j] ==false) {
					temp2 = temp2 + arr1[i][j];
				}
			}
		}
		sum = Math.abs(temp1-temp2);
		MIN = (MIN < sum ) ? MIN : sum;
	}
}
