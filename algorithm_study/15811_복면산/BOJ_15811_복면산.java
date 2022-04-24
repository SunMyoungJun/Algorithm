import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[] s = new String[3];
	static boolean[] alpa = new boolean[27];
	static int[] number = new int[3];
	static int[] alpabet = new int[27];
	static boolean[] isNumber = new boolean[10];
	static int N;
	static ArrayList<Character> arr1 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		s[0] = st.nextToken();
		s[1] = st.nextToken();
		s[2] = st.nextToken();
		
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<s[i].length(); j++) {
				char a = s[i].charAt(j);
				if(!alpa[a-'A']) {
					alpa[a-'A'] = true;
					arr1.add(a);
				}
			}
		}
		N = arr1.size();
		
		
		if(dfs(0)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	static boolean dfs(int cnt) {
		if(cnt == N) {
			for(int i=0; i<3; i++) {
				int num=0;
				for(int j=0; j<s[i].length(); j++) {
					int n = alpabet[s[i].charAt(j)-'A'];
					num = num*10 +n;
				}
				number[i] = num;
			}
			
			if(number[0]+number[1] == number[2]) {
				return true;
			}
			return false;
		}
		
		for(int i=0; i<10; i++) {
			if(!isNumber[i]) {
				isNumber[i] = true;
				alpabet[arr1.get(cnt)-'A'] = i;
				if(dfs(cnt+1)) {
					return true;
				}
				isNumber[i] = false;
			}
		}
		return false;
	}
}