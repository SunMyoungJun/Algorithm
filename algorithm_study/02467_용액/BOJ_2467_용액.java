package year2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467용액 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr1 = new int[N+1];
		
		for(int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		int start=0,end=N-1;
		int minN1=0,minN2=0;
		int min=Integer.MAX_VALUE;
		while(start<end) {
			int sum = arr1[start] + arr1[end];
			
			if(sum >0) {
				if(min > sum) {
					min = sum;
					minN1 = arr1[start];
					minN2 = arr1[end];
				}
				end--;
			}
			else if(sum == 0) {	
				System.out.println(arr1[start]+" "+arr1[end]);
				return;
			}
			else {
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					minN1 = arr1[start];
					minN2 = arr1[end];
				}
				start++;
			}
		}
		
		
		System.out.println(minN1+" "+minN2);
		
		

	}

}
