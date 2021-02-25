import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {   //카운팅 정렬 사용해봄.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max=0,min=10002;
		for(int i=0;i<N;i++) {
			P[i] = Integer.parseInt(st.nextToken());
			max = (max > P[i]) ? max : P[i];
			min = (min < P[i]) ? min : P[i];
		}
		
		int[] count = new int[max+1];
		for(int i=0;i<N;i++) 
			count[P[i]]++;
		
		int[] result = new int[N];
		
		for(int i=min+1;i<max+1;i++) 
			count[i] = count[i] + count[i-1];
		
		for(int i=N-1;i>=0;i--) 
			result[--count[P[i]]] = P[i];

		int sum =0,tsum=0;
		for(int i=0;i<N;i++) {
			tsum = tsum + result[i];
			sum = sum+tsum;
		}
		System.out.println(sum);
	}
}