import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		for(int t=1;t<11;t++) {
			int s_len = Integer.parseInt(br.readLine());
			String s = br.readLine();
			for(int i=0;i<s_len;i++) {
				if(s.charAt(i) == '+' || s.charAt(i) =='*') {
					if(s1.isEmpty() || (s1.peek() =='+' && s.charAt(i) =='*')) {
						s1.push(s.charAt(i));
					}
					else if(s1.peek() =='*' && s.charAt(i) =='+') {
						sb.append(s1.pop());
						i--;
					}
					else{
						sb.append(s1.pop());
						s1.push(s.charAt(i));	
					}			
				}
				else{
					sb.append(s.charAt(i));
				}
			}
			while(!s1.isEmpty())
				sb.append(s1.pop());
			int temp1 =0;
			int temp2 =0;
			for(int i=0;i<sb.length();i++) {
				if(sb.charAt(i) !='+' && sb.charAt(i) !='*') {
					s2.push(sb.charAt(i) -48);
				}
				else {
					temp1 = s2.pop();
					temp2 = s2.pop();
					if(sb.charAt(i) =='+')
						s2.push(temp1 +temp2);
					else
						s2.push(temp1*temp2);
					
				}
					
			}
			
			System.out.println("#"+t+" "+s2.pop());
		}



	}

}
