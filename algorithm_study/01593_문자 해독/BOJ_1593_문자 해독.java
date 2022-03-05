import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int g=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		int n1=0,n2=0,cnt=0,result=0;
	
		String W = br.readLine();
		String S = br.readLine();

		int[] check = new int[101];
		boolean[] check2 = new boolean[101];
		for(int i=0; i<g; i++) {
			check[W.charAt(i)-'A']++;
			check2[W.charAt(i)-'A'] = true;
		}

		for(int i=0; i<s; i++) {
			n1 =S.charAt(i)-'A';
			
			if(i < g) {
				if(check2[n1] && check[n1] <=0) {
					check[n1]--;
				}
				else if(check[n1] > 0) {
					cnt++;
					check[n1]--;
					if(cnt == g) {
						result++;
					}
				}
				continue;
			}
			
			n2 = S.charAt(i-g)-'A';
			if(check2[n2]) {
				check[n2]++;
				if(check[n2]>0){
					cnt--;
				}
			}
			if(check2[n1] && check[n1] <=0) {
				check[n1]--;
			}
			else if(check[n1]>0) {
				cnt++;
				check[n1]--;
				if(cnt == g) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}