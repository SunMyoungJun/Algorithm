import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int D,P,N;
	static int max=-1;
	public static void main(String[] args) throws IOException	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		D = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		N= (int)Math.pow(10, D);
		dfs(1,0,9);
		System.out.println(max);
	}

	static void dfs(int num,int cnt,int idx) {
		if(cnt==P) {
			max = Math.max(max, num);
			return;
		}

		int n1=0;
		for(int i=idx; i>=2; i--) {
			n1 = num*i;
			if(n1 >= N) {
				continue;
			}
			dfs(num*i,cnt+1,i);
		}
	}
}