import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		BigInteger[][] bi = new BigInteger[n+1][m+1];
		for(int i=0; i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				bi[i][j] = new BigInteger("0");
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1; j<=m;j++) {
				if(j >i) {
					break;
				}
				else if(j ==1) {
					bi[i][j] = new BigInteger(Integer.toString(i));
				}
				else if(i==j) {
					bi[i][j] = bi[i][j].add(new BigInteger("1"));
				}
				else{
					bi[i][j] = bi[i][j].add(bi[i-1][j-1]).add(bi[i-1][j]);
				}
			}
		}
		System.out.println(bi[n][m]);
	}
}