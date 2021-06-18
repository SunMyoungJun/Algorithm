import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] water = new long[N];
		long[] selectWater = new long[3];
		for(int i=0; i<N; i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(water);
		
		int start=0,end=0;
		long gojung=0,sum=0;
//		long result=water[0]+water[1]+water[2];
//		long result2 = water[N-1]+water[N-2]+water[N-3];
//		result = (Math.abs(result) < Math.abs(result2)) ? result : result2;
		long result = 99999999999999L;
		for(int i=0; i<N-2;i++) {
			gojung = water[i];
			start = i+1;
			end = N-1;
			while(start <end) {
				sum = gojung + water[start] + water[end];
				
				if(Math.abs(sum) < Math.abs(result)) {
					result = sum;
					selectWater[0] = gojung;
					selectWater[1] = water[start];
					selectWater[2] = water[end];
				}
				
				if(sum > 0) {
					end--;
				}
				else {
					start++;
				}
			}
		}
		Arrays.sort(selectWater);
		
		System.out.println(selectWater[0]+" "+selectWater[1]+" "+selectWater[2]);
	}
	
	
	

}
