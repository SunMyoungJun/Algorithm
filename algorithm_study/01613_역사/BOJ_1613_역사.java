import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int[][] result;
	static int[][] arr1;
	static Queue<Integer> q1 = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr1 = new int[n+1][n+1];
		result = new int[n+1][n+1];
		int n1=0,n2=0;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			result[n1][n2] =1;
		}
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				if(i==k)
					continue;
				for(int j=1; j<n+1; j++) {
					if(i==j || k==j) {
						continue;
					}
					if(result[i][k] >0 && result[k][j]>0) {
						result[i][j] = result[i][k]+result[k][j];
					}
				}
			}
		}
		int s= Integer.parseInt(br.readLine());
		for(int i=0; i<s; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			if(result[n1][n2] == result[n2][n1]) {
				sb.append("0").append("\n");
			}
			else if(result[n1][n2] > result[n2][n1]) {
				sb.append("-1").append("\n");
			}
			else {
				sb.append("1").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}