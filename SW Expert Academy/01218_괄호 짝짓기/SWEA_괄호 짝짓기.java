import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<>();
		int test=10;
		int len=0;
		int result =1;
		for(int t=1;t<test+1;t++) {
			len = Integer.parseInt(br.readLine());
			String g = br.readLine();
			
			for(int i=0;i<g.length();i++) {
				if(g.charAt(i) == '(' || g.charAt(i) =='[' || g.charAt(i) =='{' || g.charAt(i) =='<') {
					s.push(g.charAt(i));
				}
				else {
					char temp = s.pop();
					if(temp =='(' && g.charAt(i) ==')') {
						continue;
					}
					else if(temp =='[' && g.charAt(i) ==']') {
						continue;
					}
					else if(temp =='<' && g.charAt(i) =='>') {
						continue;
					}
					else if(temp =='{' && g.charAt(i) =='}') {
						continue;
					}
					else {
						result =0;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+result);
			result =1;
		}

	}

}
