import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		for(int i=0; i<n; i++) 
			arr1[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr1);
		int start =0;
		int end = n-1;
		int sum=0,cnt=0;
		while(start < end) {
			sum = arr1[start]+arr1[end];
			if(sum == x) {
				cnt++;
				start++;
				end--;
			}
			else if(sum > x) 
				end--;
			else 
				start++;
		}
		System.out.println(cnt);
	}
}