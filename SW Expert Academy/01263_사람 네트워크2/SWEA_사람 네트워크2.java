import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t <test+1; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] mat = new int[N][N];

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && mat[i][j] == 0) {
						mat[i][j] = 999999;
					}
				}
			}

			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(i==j)
							continue;
						mat[i][j] = Math.min(mat[i][j],mat[i][k]+mat[k][j]);
					}
				}
			}

			int MIN = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				int sum =0;
				for(int j=0; j<N;j++){
					sum += mat[i][j];

				}

				MIN = (MIN < sum) ? MIN : sum;
			}

			sb.append("#").append(t).append(" ").append(MIN).append("\n");

		}
		System.out.println(sb.toString());
	}

}
