import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,R;
	static long[] f;
	static final long M = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());			

		f = new long[N+1];

		f[1] = 1;

		for(int i=2;i<=N;i++) {
			f[i] = f[i-1] *i % M;
		}

		long result = nCr();
		System.out.println(result);
	}

	static long nCr() { // ex) N=7, R=5, M= 11(p)
		if(R== 0) {
			return 1;
		}
		return f[N] * power(f[N-R], M-2)%M * power(f[R],M-2)%M;
	}

	static long power(long n,long cnt) {
		long res = 1;
		n = n%M;
		while(cnt >0) {
			if(cnt%2 ==1) {
				res = res * n %M;
			}
			cnt = cnt/2;
			n = (n*n)%M;
		}
		return res;
	}
}