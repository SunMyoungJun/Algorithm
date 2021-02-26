import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int space=0;
		boolean tf= false;
		for(int i=0;i<s.length();i++) {
			space=s.length();
			
			if(s.charAt(i) ==' ') {
				sb.append(" ");
			}
			
			else if(s.charAt(i) =='<') {
				tf = true;
				sb.append("<");
			}
			else if(s.charAt(i) =='>') {
				tf = false;
				sb.append(">");
			}
			
			
			else if(tf ==true) {
				sb.append(s.charAt(i));
			}
			
			else if(tf ==false) {
				for(int j=i;j<s.length();j++) {
					if(s.charAt(j) ==' ') {
						space = j-1;
						break;
					}
					else if(s.charAt(j) =='<') { 
						space = j-1;
						break;
					}
				}
				
				space = (space ==s.length()) ? space-1 : space;
				for(int j=space; j>=i; j--) {
					sb.append(s.charAt(j));
				}
				
				i = space;
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
