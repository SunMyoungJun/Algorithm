package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_서로소집합 {
	static int N,M;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int t=1;t<test+1;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			for(int i=1;i<N+1;i++) {
				parents[i] = i;
			}
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			boolean flag=false;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int what = Integer.parseInt(st.nextToken());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				
				if(what == 0) {  // 합집합
					flag = union(num1,num2);
				}
				else if(what ==1) { //같은 집합 여부
					if(findSet(num1) == findSet(num2)) {
						sb.append("1");
					}
					else {
						sb.append("0");
					}
				}
				
		
				
			}
			
			System.out.println(sb.toString());
		}
	}
	 static int findSet(int num1) {
		 if(parents[num1] == num1) {
			 return num1;
		 }
		 
		 return parents[num1] = findSet(parents[num1]);
		 
		
	}
	 static boolean union(int num1, int num2) {
		 int tnum1 = findSet(num1);
		 int tnum2 = findSet(num2);
		 if(tnum1 == tnum2) {
			 return false;
		 }
		 
		 
		 parents[tnum2] = parents[tnum1];
		 return true;
		
	}

}
