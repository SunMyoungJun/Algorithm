import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] alpa = new int[26];
		int size=0,max=9;
		char al;
		long result=0;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			size = s.length();
			for(int j=0; j<size; j++) {
				al = s.charAt(j);
				alpa[al-'A'] += (int)Math.pow(10, (size-j-1));
			}
		}
		Arrays.sort(alpa);
		for(int i=25;i>=0; i--) {
			if(alpa[i] ==0) 
				break;
			result += alpa[i]*max;
			max-=1;
		}
		System.out.println(result);
	}
}