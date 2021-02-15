import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr1 = new int[9];
	static int[] arr2 = new int[7];
	static boolean tf;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<9;i++) {
			arr1[i] = Integer.parseInt(br.readLine());
		}
		boolean tf = dfs(0,0,0);
	}
	
	static boolean dfs(int cnt,int start,int sum) {
		if(cnt ==7) {
			if(sum == 100) {
				for(int i=0;i<7;i++) {
					System.out.println(arr2[i]);
				}
				return true;
			}
			return false;
		}
		
		for(int i=start; i<9;i++) {
			arr2[cnt] = arr1[i];
			tf = dfs(cnt+1,i+1,sum+arr1[i]);
			if(tf ==true) {
				return true;
			}
		}
		return false;
	}
}