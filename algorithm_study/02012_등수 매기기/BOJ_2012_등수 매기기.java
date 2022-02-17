import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N+1];
		int[] result = new int[N+1];
		for(int i=0; i<N;i++) {
			arr1[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr1);
		int start = 1;
		long sum=0;
		for(int i=1; i<N+1; i++) {
			result[start] = arr1[i];
			sum += Math.abs(start - arr1[i]);
			start++;
		
		}
		System.out.println(sum);
		
		
		
	}

}
