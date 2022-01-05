import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[] val;
	public static void main(String[] args) throws IOException	 {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1=0,num2=0;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		val = new int[n];
		
		for(int i=0; i<n; i++) {
			val[i]= i;
		}
		
		
		for(int i=1; i<m+1; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			
			
			if(!union(num1,num2)) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println("0");

	}
	
	
	static int findSet(int num) {
		if(val[num] == num) {
			return num;
		}
		
		return val[num] = findSet(val[num]);
		
		
	}
	
	
	static boolean union(int num1, int num2) {
		num1 = findSet(num1);
		num2 = findSet(num2);
		
		if(num1 == num2) {
			return false;
		}
		
		val[num1] = num2;
		return true;
		
		
	}

}
