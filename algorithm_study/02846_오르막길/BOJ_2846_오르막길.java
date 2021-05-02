import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int MAX = 0;
		int first = Integer.parseInt(st.nextToken());
		int real=first;
		int num=0;
		for(int i=1; i<N;i++) {
			num = Integer.parseInt(st.nextToken());
			if(num > real) {
				MAX = Math.max(MAX,num - first);
				real = num;
			}
			else {
				first = num;
				real = num;
			}
		}	
		System.out.println(MAX);
	}
}