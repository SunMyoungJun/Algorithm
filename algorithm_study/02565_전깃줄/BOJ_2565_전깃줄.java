import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		N = Integer.parseInt(br.readLine());
		int[] line = new int[501];
		dp = new int[N+1];
		int n1=0,n2=0;
		for(int i=1;i <N+1;i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			line[n1] = n2;
		}
		
		
		int idx=0;
		for(int i=1;i<501;i++) {
			if(line[i] ==0)
				continue;
			
			if(dp[idx] < line[i]) {
				dp[++idx] = line[i];
				continue;
			}
			search(0,idx,line[i]);
		}
		
		System.out.println(N -idx);
		
		
	}
	 static void search(int start, int end, int value) {
		 int mid =0;
		 
		 
		 while(start <end) {
			 mid = (start +end)/2;
			 if(dp[mid] > value) {
				 end = mid;
			 }
			 else {
				 start = mid+1;
			 }
		 }
		 
		 dp[end] = value;
		 return;
	}

}
