import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sn = null;
		while((sn = br.readLine())!=null && sn.length() >0) {
			int n = Integer.parseInt(sn); 
			String sNum = "1";
			int cnt=1;
			long num = Long.parseLong(sNum);
			while(true) {				
				if(num%n == 0) {
					break;
				}
				cnt++;
				num = (num*10+1)%n;
			}
			System.out.println(cnt);
		}
	}
}