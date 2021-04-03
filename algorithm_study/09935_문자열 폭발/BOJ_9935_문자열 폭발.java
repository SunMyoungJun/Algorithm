import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Character> arr1 = new ArrayList<Character>();
		String s1= br.readLine();
		String s2 = br.readLine();
		int s2size = s2.length();
		int s1size = s1.length();
		int stacksize =0,cnt=0,start=0;
		Stack<Character> sk1 = new Stack<Character>();
		for(int i=0; i<s1size;i++) {
			sk1.push(s1.charAt(i));
			
			stacksize = sk1.size();
			boolean tf = false;
			if(stacksize >= s2size) {
				cnt =0;
				start = stacksize-s2size;
	
				for(int j= start; j<stacksize; j++) {
					if(sk1.get(j) != s2.charAt(cnt++)) {
						tf = true;
						break;
					}
					
				}
				
				
				if(!tf) {  //일치할 때 
					for(int j=0; j<s2size; j++) {
						sk1.pop();
					}
				}				
			}	
		}
		
		StringBuilder sb = new StringBuilder();
		stacksize = sk1.size();

		if(stacksize ==0) {
			sb.append("FRULA");
			
		}
		else {
			for(int i=0; i<stacksize;i++) {
				sb.append(sk1.get(i));
			}
		}
		System.out.println(sb.toString());
		
	}

}
