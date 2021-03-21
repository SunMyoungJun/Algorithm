import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,MAX = Integer.MIN_VALUE;
	static String s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = br.readLine();
		dfs(0,0,0,'^');
		System.out.println(MAX);
	}

	static void dfs(int cnt,int sum,int gal,char giho) {
		int temp=0;
		if(cnt >=s.length()) {
			MAX = (MAX > sum) ? MAX : sum;
			return;
		}
		
		if(cnt ==0) {
			dfs(cnt+2,s.charAt(0)-48,0,'^');
			dfs(cnt+2,0,1,'^');
			
			return;
		}
		
		if(gal ==1) {  //앞에 괄호엿다면
			switch(s.charAt(cnt-1)) {
			case '+':
				temp =(s.charAt(cnt-2)-48) + (s.charAt(cnt)-48); 
				break;
			case '-':
				temp =(s.charAt(cnt-2)-48) - (s.charAt(cnt)-48); 
				break;
			case '*':
				temp =(s.charAt(cnt-2)-48) * (s.charAt(cnt)-48); 
				break;
			}
			
			switch(giho) {
			case '+':
				temp =sum + temp; 
				break;
			case '-':
				temp =sum - temp; 
				break;
			case '*':
				temp =sum * temp; 
				break;
			case '^':
				break;
			}
			dfs(cnt+2,temp,0,'^');
		}
        
		else{
			switch(s.charAt(cnt-1)) {
			case '+':
				temp =sum + (s.charAt(cnt)-48); 
				break;
			case '-':
				temp =sum - (s.charAt(cnt)-48); 
				break;
			case '*':
				temp =sum * (s.charAt(cnt)-48); 
				break;
			}
			dfs(cnt+2,temp,0,'^');
			
			if(cnt !=s.length()-1)
				dfs(cnt+2,sum,1,s.charAt(cnt-1));
		}		
	}
}