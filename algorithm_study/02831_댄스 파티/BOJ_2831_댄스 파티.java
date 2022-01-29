package year2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2831댄스파티 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] man = new int[N];
		int[] women = new int[N];
		int cnt=0,idx1=0,idx2=N-1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) 
			man[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			women[i] = Integer.parseInt(st.nextToken());
		
		
		Arrays.sort(man);
		Arrays.sort(women);
		
		
		while(idx1 !=N && idx2 !=-1) {
			if(man[idx1] >0 && women[idx2] <0) {
				if(Math.abs(man[idx1]) < Math.abs(women[idx2])) {
					cnt++;
					idx1++;
				}
				idx2--;
			}
			else if(man[idx1] <0 && women[idx2] >0) {
				if(Math.abs(man[idx1]) > Math.abs(women[idx2])) {
					cnt++;
					idx1++;
				}
				idx2--;
				
			}
			else if(man[idx1] >0 && women[idx2] >0) 
				idx2--;
			
			else if(man[idx1] <0 && women[idx2] <0) 
				idx1++;
		}
		System.out.println(cnt);
	}
}