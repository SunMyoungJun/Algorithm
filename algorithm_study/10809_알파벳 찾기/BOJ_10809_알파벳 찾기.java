import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alpa = new int[26];
		int size =s.length();
		Arrays.fill(alpa, -1);
		for(int i=0; i<size; i++) {
			char a = s.charAt(i);
			if(alpa[a-'a'] !=-1) 
				continue;
			alpa[a-'a'] = i;
		}
       StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            sb.append(alpa[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

}
