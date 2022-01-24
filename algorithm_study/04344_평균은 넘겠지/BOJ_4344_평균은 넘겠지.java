import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C= Integer.parseInt(br.readLine());
		StringTokenizer st= null;
		StringBuilder sb = new StringBuilder();
		while(C-- !=0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			double sum=0;
			int[] arr1 = new int[N];
			int cnt=0;
			for(int i=0; i<N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
				sum += arr1[i];
			}
			sum = sum/N;
			for(int i=0; i<N;i++) {
				if(arr1[i] >sum) 
					cnt++;
			}
			double result = (double)cnt/N * 100;
			sb.append(String.format("%.3f", result)).append("%\n");
		}
		System.out.println(sb.toString());
	}
}