import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,M,L;
	static int[] arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr1 = new int[N];

		int start = 0,cnt=0;
		arr1[0] +=1;
		
		while(true) {
			
			if(arr1[start] %2 ==0) { //짝
				start = (start+(N-L)) %N;
				arr1[start] ++;
			}
			else { //홀
				start = (start+L) % N;
				arr1[start] ++;
			}
			
			cnt++;
			
			if(arr1[start] ==M) {
				break;
			}
		}
		System.out.println(cnt);
	}
}