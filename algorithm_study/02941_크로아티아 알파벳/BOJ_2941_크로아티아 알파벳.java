import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String temp ="";
		int length = s.length();
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i) == '=') {
				if(i-1 >=0) {
					if(s.charAt(i-1) == 's' || s.charAt(i-1) =='c')
						length--;
					
					if(s.charAt(i-1) == 'z') {
						if(i-2 >=0) {
							if(s.charAt(i-2) == 'd') {
								length -=2;
							}
							else {
								length --;
							}
						}
						else
							length--;
					}
				}
			}
			
			else if(s.charAt(i) =='-') {
				if(i-1>=0) {
					if(s.charAt(i-1) =='c' || s.charAt(i-1) =='d') {
						length --;
					}
				}
			}
			
			else if(s.charAt(i) =='j') {
				if(i-1 >=0) {
					if(s.charAt(i-1) =='l' || s.charAt(i-1) =='n') {
						length--;
					}
				}
			}
		}
		System.out.println(length);
	}
}