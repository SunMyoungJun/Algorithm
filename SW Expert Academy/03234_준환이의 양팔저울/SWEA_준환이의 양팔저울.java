import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int N,sum;
	static int[] arr1;
	static boolean[] check;
	static int[]arr2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<test+1;t++) {
			N = Integer.parseInt(br.readLine());
			arr1 = new int[N];
			arr2 = new int[N];
			check = new boolean[N];
			sum =0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}	
			
			dfs(0);
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void dfs(int cnt) {
				
		if(cnt ==N) {
			compare(0,0,0);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(check[i] ==true)
				continue;
			
			arr2[cnt] = arr1[i];
			check[i] = true;
			dfs(cnt+1);
			check[i] = false;
		}
		
		
	}
	
	static void compare(int left,int right,int start) {
	
		if(left < right) {
			return;
		}
		
		if(start ==N) {
			sum++;
			return;
		}
		
		compare(left+arr2[start],right,start+1);
		compare(left,right+arr2[start],start+1);		
	}
}