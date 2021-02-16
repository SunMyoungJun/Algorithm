package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,MIN = Integer.MAX_VALUE,temp;
	static int[][] taste1;
	static int[][] taste2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		taste1 = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			taste1[i][0] = Integer.parseInt(st.nextToken());  //신맛
			taste1[i][1] = Integer.parseInt(st.nextToken());  //쓴맛
		}

		dfs(0,0,1,0);
		System.out.println(MIN);

	}
	
	static void dfs(int cnt,int start,int t1,int t2) {
		if(cnt == N) {
			if(t2 !=0) {
				temp = Math.abs(t1-t2);
				MIN = (MIN <temp) ? MIN : temp;
				temp =0;
			}
			return;
		}
		
		if(t2 !=0) {
			temp = Math.abs(t1-t2);
			MIN = (MIN <temp) ? MIN : temp;
		}
		
	
		for(int i=start;i<N;i++) {
			
			dfs(cnt+1,i+1,t1*taste1[i][0],t2+taste1[i][1]);  // 선택
			dfs(cnt+1,i+1,t1,t2);     // 선택 x
			
		}
		
		
		
	}
	

}
