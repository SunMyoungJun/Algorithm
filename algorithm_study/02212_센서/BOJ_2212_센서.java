import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] map = new int[N];
		for(int i=0; i<N; i++) 
			map[i] = Integer.parseInt(st.nextToken()); 
		Arrays.sort(map);
		int[] map2 = new int[N-1];
		for(int i=0;i<N-1;i++) 
			map2[i] = map[i+1]-map[i];
		Arrays.sort(map2);
		int size = N-K;
		int sum=0;
		for(int i=0; i<size;i++) 
			sum += map2[i];
		System.out.println(sum);
	}
}