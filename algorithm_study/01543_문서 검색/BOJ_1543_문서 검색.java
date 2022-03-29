import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int idx=0,idx2=0,cnt=0,answer=0,temp=0;
		int N = s1.length();
		int len = s2.length();
		while(idx != N) {
			if(s1.charAt(idx) == s2.charAt(idx2)) {
				idx2++;
				if(idx2 ==1) 
					temp=idx;
				if(idx2 == len) {
					idx2=0;
					answer++;
				}
			}
			else if(idx2 >0) {
				idx2=0;
				idx = temp;
			}
			idx++;
		}
		System.out.println(answer);
	}
}