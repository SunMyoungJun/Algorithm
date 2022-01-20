import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr1 = new int[N];
		double max = -1,sum=0;
		for(int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
			max = (max > arr1[i]) ? max : arr1[i];
		}
		for(int i=0; i<N; i++)
			sum = sum + (arr1[i] /max * 100);
		System.out.println(sum/N);
	}
}