import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461파도반수열 {

	public static void main(String[] args) throws IOException	 {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		long[] arr1 = new long[101];
		arr1[1] =1;
		arr1[2] =1;
		arr1[3] =1;
		
		for(int i=4; i<101; i++) {
			arr1[i] = arr1[i-2]+arr1[i-3];
		}
		
		
		
		while(test-- !=0) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(arr1[N]);
			
			
			
			
		}
		
		

	}

}
