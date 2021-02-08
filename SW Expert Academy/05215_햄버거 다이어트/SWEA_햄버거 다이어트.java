package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_햄버거다이어트 {
	static int[][] arr1;
	static int N,L,MAX=Integer.MIN_VALUE,SUM=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t<test+1;t++) {
			st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 L = Integer.parseInt(st.nextToken());
			arr1 = new int[N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr1[i][0] = Integer.parseInt(st.nextToken());
				arr1[i][1] = Integer.parseInt(st.nextToken());
				SUM += arr1[i][1];
			}
			
			dfs(0,0,0);
			System.out.println("#"+t+" "+MAX);
			MAX = Integer.MIN_VALUE;
		}
	}
	
	static void dfs(int Tsum,int Ksum , int start) {
		int temp=0;
		if(Ksum >=L) {
			return; 
		}
		
		for(int i=start;i<N;i++) {			
			for(int j=start;j<N;j++) {
				temp += arr1[j][0];
			}
			
			if(Tsum + temp <MAX) {
				return;
			}
			Tsum = Tsum+arr1[i][0];
			Ksum = Ksum+arr1[i][1];
		
			if(Ksum <=L) {
				MAX = (MAX > Tsum) ? MAX : Tsum;
				dfs(Tsum,Ksum,i+1);
			}
			
			Tsum = Tsum -arr1[i][0];
			Ksum = Ksum -arr1[i][1];
			if(Ksum <=L) {
				MAX = (MAX > Tsum) ? MAX : Tsum;
				dfs(Tsum,Ksum,i+1);
			}
		}
	}

}
