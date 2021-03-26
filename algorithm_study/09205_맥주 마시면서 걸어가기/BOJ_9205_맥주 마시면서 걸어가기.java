import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		while(test-- !=0) {
			int n = Integer.parseInt(br.readLine());
			int[][] store = new int[n+2][n+2];
			boolean[][] check = new boolean[n+2][n+2];
			
			for(int i=0;i<n+2;i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			int sum=0;

			for(int i=0;i<n+2;i++) {
				for(int j=0; j<n+2; j++) {
					if(i==j){
						continue;
					}
					sum = Math.abs(store[i][0] - store[j][0]) + Math.abs(store[i][1] - store[j][1]);
					if(sum <=1000) {
						check[i][j] = true;
					}
				}
			}


			for(int k=0;k<n+2;k++) {
				for(int i=0;i<n+2;i++) {
					for(int j=0;j<n+2;j++) {
						if(check[i][k] ==true && check[k][j] == true) {
							check[i][j] = true;
						}
					}
				}
			}

			if(check[0][n+1] == true) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
	}
}