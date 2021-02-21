import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] arr1;
	static boolean[] check = new boolean[10];
	static String inputs;
	static int N,temp,T,tN;
	static int MIN= 999_999_99;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputs = br.readLine();
		N = inputs.length();
		tN = N;
		T = Integer.parseInt(inputs);
		arr1 = new int[N+1];
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		if(num !=0)
			st = new StringTokenizer(br.readLine());

		for(int i=0; i<num;i++) {
			check[Integer.parseInt(st.nextToken())] = true;  //고장난 버튼 인덱스 true
		}
		
		dfs(0,0);
		if(MIN == Integer.MAX_VALUE) {
			MIN = Math.abs(T - 100);
		}
		else {
			MIN +=tN;
			MIN = (MIN < Math.abs(T-100)) ? MIN : Math.abs(T-100);
		}
		System.out.println(MIN);
		
	}
	
	static void dfs(int cnt,int num) {
		if(cnt !=0) {
			temp = Math.abs(T-num);
			if(MIN > temp) {
				MIN = temp;
				tN = cnt;
			}
			else if(MIN == temp) {
				tN = (tN < cnt) ? tN : cnt;
			}
		
		}
		
		if(cnt ==N+1) {
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(check[i] ==true)
				continue;

			dfs(cnt+1,num*10 +i);
		}
	}
}