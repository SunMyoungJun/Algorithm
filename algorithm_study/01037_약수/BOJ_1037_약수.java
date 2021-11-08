import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] soo = new int[N];
		int max = -1;
		int min = 1000001;
		for(int i=0;i<N;i++) {
			soo[i] = Integer.parseInt(st.nextToken());
			max = (max > soo[i]) ? max : soo[i];
			min = (min < soo[i]) ? min : soo[i];
		}
		System.out.println(max*min);
		

	}

}
