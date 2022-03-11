import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] roll = new int[M+2];
		
		for(int i=1; i<M+1; i++) {
			roll[i] = Integer.parseInt(br.readLine());
		}
		roll[M+1] = L;
		
		int Q=0,right=L,mid=0,left=0,prev=0,cnt=0,max=0,cnt2=0,minValue=0;
		while(N-- !=0) {
			Q = Integer.parseInt(br.readLine());
			right=L; mid=0; left=0;
			max = Integer.MIN_VALUE;
			while(left <= right) {
				mid = (right+left)/2;
				cnt=0; cnt2=0;
				prev = roll[0];
				for(int i=1; i<M+2; i++) {
					if(roll[i] - prev >= mid) {
						cnt++;
						prev = roll[i];
					}
				}
				
				if(cnt > Q) {
					left = mid+1;
					max = Math.max(max, mid);
				}
				else{
					right = mid-1;
				}
			}
			
			System.out.println(max);
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		

	}

}
