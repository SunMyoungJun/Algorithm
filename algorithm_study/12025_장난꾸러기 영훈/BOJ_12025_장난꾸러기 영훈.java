import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static String lownum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String password = br.readLine();
		long k = Long.parseLong(br.readLine());
		
		int password_len = password.length();
		StringBuilder sb1 = new StringBuilder();
		for(int i=0; i<password_len; i++) {
			if(password.charAt(i) =='1' || password.charAt(i) =='6') {
				sb1.append(1);
			}
			else if(password.charAt(i) =='2' || password.charAt(i) =='7') {
				sb1.append(2);
			}
		}
		
		
		
		lownum = sb1.toString();
		
		long a = (long) Math.pow(2, lownum.length());

		if(a < k) {
			System.out.println("-1");
			return;
		}
		
		
		int len = lownum.length();
		StringBuilder sb2 = new StringBuilder(); //결과
		for(int i=0; i<len; i++) {
			if((k-1 & (1<<i)) !=0) {
				if(lownum.charAt(len-i-1) == '1') {
					sb2.append(6);
				}
				else {
					sb2.append(7);
				}
			}
			else {
				sb2.append(lownum.charAt(len-i-1));
			}
		}
		
		lownum = sb2.reverse().toString();
		
		sb2 = new StringBuilder();
		char temp = 0;
		int idx=0;
		for(int i=0; i<password_len;i++) {
			temp = password.charAt(i);
			if(temp =='1' || temp =='6' || temp =='2' || temp =='7') {
				sb2.append(lownum.charAt(idx++));
			}
			else {
				sb2.append(temp);
			}
		}
		
		System.out.println(sb2.toString());
		
	}

	
	
	
}
