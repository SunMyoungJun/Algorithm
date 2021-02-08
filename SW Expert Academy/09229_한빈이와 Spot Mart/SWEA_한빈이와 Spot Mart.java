import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int N,M,MAX;
	static int[] snack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t<test+1;t++) {
			MAX = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 M = Integer.parseInt(st.nextToken());
			 snack = new int[N];
			 
			 st = new StringTokenizer(br.readLine());
			 for(int i=0;i<N;i++) {
				 snack[i] = Integer.parseInt(st.nextToken());
			 }
			 
			 dfs(0,0,0);
			 if(MAX ==Integer.MIN_VALUE)
				 MAX=-1;
			 sb.append("#").append(t).append(" ").append(MAX).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int cnt,int start, int Msum) {
		if(cnt == 2 ) {
			MAX = (MAX > Msum) ? MAX : Msum;
			return;
		}
		
		for(int i=start;i<N;i++) {
			
			if(Msum+snack[i] <=M)
				dfs(cnt+1,i+1,Msum+snack[i]);
		}
	}

}







