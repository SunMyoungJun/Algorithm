import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		String s;
		int count=0;

		for(int t=1;t<test+1;t++)
		{
			s = br.readLine();
			int[] check = new int[s.length()];
			count=0;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)-48 == 1 && check[i] !=1){
					for(int j=i; j<check.length;j++) {
						check[j] =1;
					}
					count++;
				}
				else if(s.charAt(i)-48 == 0 && check[i] !=0) {
					for(int j=i; j<check.length;j++) {
						check[j] =0;
					}
					count++;
				}
			}
			
			System.out.println("#"+t+" "+count);
			
			
		}

	}
}
