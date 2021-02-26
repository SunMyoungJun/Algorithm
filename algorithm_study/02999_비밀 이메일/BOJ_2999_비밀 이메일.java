import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		int num = s.length();
		int maxr=0,maxc=0;
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=num;j++) {
				if(i*j == num && i<=j) {
					if(maxr < i) {
						maxr = i;
						maxc = j;
					}
				}
			}
		}
		char[][] arr1 = new char[maxr][maxc];
		int cnt=0;
		for(int i=0;i<maxc;i++) {
			for(int j=0;j<maxr;j++) {
				arr1[j][i] = s.charAt(cnt);
				cnt++;
			}
		}

		for(int i=0;i<maxr;i++) 
			for(int j=0;j<maxc;j++) 
				sb.append(arr1[i][j]);	
		System.out.println(sb.toString());
	}
}