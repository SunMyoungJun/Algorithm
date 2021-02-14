import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main{
	static int[] soo,tsoo; //수
	static char[] san; //연산자
	static char[] tsan; //연산자
	static boolean[] check;
	static int N,MAX = Integer.MIN_VALUE, MIN=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		soo = new int[N];
		tsoo = new int[N];
		san = new char[N-1];
		tsan = new char[N-1];
		check = new boolean[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			soo[i] = Integer.parseInt(st.nextToken());
			tsoo[i] = soo[i];
		}
		st = new StringTokenizer(br.readLine());
		int sannum=0,cnt =0;
		for(int i=0;i<4;i++) {
			sannum = Integer.parseInt(st.nextToken());
			if(i == 0) {
				for(int j=0;j< sannum;j++) {
					san[cnt] = '+';
					cnt++;
				}
			}
			if(i == 1) {
				for(int j=0;j< sannum;j++) {
					san[cnt] = '-';
					cnt++;
				}
			}
			if(i == 2) {
				for(int j=0;j< sannum;j++) {
					san[cnt] = '*';
					cnt++;
				}
			}
			if(i == 3) {
				for(int j=0;j< sannum;j++) {
					san[cnt] = '/';
					cnt++;
				}
			}
		}
		
		
		dfs(0);
		System.out.println(MAX);
		System.out.println(MIN);
		
		
	}
	
	static void dfs(int cnt) {
		if(cnt == N-1) {

			compare();
			for(int i=0;i<N;i++) {
				tsoo[i] = soo[i];
			}
			return;
		}
		
		for(int i=0;i<N-1;i++) {
			if(check[i] ==true)
				continue;
			
			check[i] = true;
			tsan[cnt] = san[i];
			dfs(cnt+1);
			check[i] = false;
		}
	}
	
	static void compare() {
		int temp1=0,temp2=0;
		for(int i=0; i<N-1;i++) {
			temp1 = tsoo[i];
			temp2 = tsoo[i+1];
			
			if(tsan[i] == '+') {
				tsoo[i+1] = temp1 +temp2;
			}
			if(tsan[i] == '-') {
				tsoo[i+1] = temp1 -temp2;
			}
			if(tsan[i] == '*') {
				tsoo[i+1] = temp1 *temp2;
			}
			if(tsan[i] == '/') {
				if(temp1 <0) {
					temp1 = -temp1;
					tsoo[i+1] = -(temp1/temp2);
				}
				else
					tsoo[i+1] = temp1 /temp2;
			}
		}
		MAX = (MAX > tsoo[N-1]) ? MAX : tsoo[N-1];
		MIN = (MIN < tsoo[N-1]) ? MIN : tsoo[N-1];
	}
}
