import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int t=0,count=0,n=0,sum=0,size1=0,size2=0,num1=0,num2=0,max=0;
		ArrayList<Integer>[] arr1 = new ArrayList[N+1];
		int[][] val = new int[N+1][2];
		int[] dp = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr1[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			val[i][0] = t;
			count = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<count; j++) {
				n = Integer.parseInt(st.nextToken());
				arr1[n].add(i);
				val[i][1]++;
			}
		}
		
		Queue<Integer> q1 = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) {
			if(val[i][1] == 0) {
				q1.offer(i);
				dp[i] = val[i][0];
			}
		}
		while(!q1.isEmpty()) {
			size1 = q1.size();
			max=0;
			
			for(int i=0; i<size1; i++) {
				num1 = q1.poll();
				size2 = arr1[num1].size();
				
				for(int j=0; j<size2; j++) {
					num2 = arr1[num1].get(j);
					val[num2][1]--;
					dp[num2] = Math.max(dp[num2], dp[num1]+val[num2][0]);
					
					if(val[num2][1] == 0) {
						q1.offer(num2);
					}
				}
			}
			sum += max;
		}
		max=0;
		for(int i=1; i<N+1; i++) {
			max = (max > dp[i]) ? max : dp[i];
		}
		System.out.println(max);
	}
}