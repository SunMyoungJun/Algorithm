import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,A,B,C,D,min=Integer.MAX_VALUE;
	static boolean[] temp1,temp2;
	static int[][] map;
	public static void main(String[] args) throws IOException	 {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int a=0,b=0,c=0,d=0,e=0;
		map = new int[N+1][5];
		temp1 = new boolean[N+1];
		temp2 = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			map[i][0] = a;
			map[i][1] = b;
			map[i][2] = c;
			map[i][3] = d;
			map[i][4] = e;
		}
		
		
		dfs(0,0,0,0,0,1);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println("-1");
			return;
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(min).append("\n");
		for(int i=1; i<N+1; i++) {
			if(temp1[i]) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb.toString());
		
	}
	static void dfs(int a,int b,int c,int d,int sum,int cnt) {
		
		if(a>=A && b>=B && c>=C && d>=D) {
			if(min > sum) {
				min = sum;
				for(int i=1; i<N+1; i++) {
					if(temp2[i]) 
						temp1[i] = true;
					else 
						temp1[i] = false;
				}
			}
			return;
		}
		
		if(cnt == N+1 || sum>=min) {
			return;
		}

		temp2[cnt] = true;
		dfs(a+map[cnt][0],b+map[cnt][1],c+map[cnt][2],d+map[cnt][3],sum+map[cnt][4],cnt+1);
		temp2[cnt] = false;
		dfs(a,b,c,d,sum,cnt+1);
	}

}
