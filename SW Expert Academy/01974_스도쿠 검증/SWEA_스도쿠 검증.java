import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		boolean tf =false;
		for(int t=1;t<test+1;t++) {
			int[][] mat = new int[9][9];
			for(int i=0;i<9;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(t).append(" ");
			
			int sum=0;
			for(int k=0;k<9;k++) {
				sum=0;
				for(int i=(k/3)*3; i<(k/3)*3 +3;i++) {
					for(int j=(k%3)*3; j<(k%3)*3+3;j++) {
						sum += mat[i][j];
					}
				}
				if(sum !=45) {
					sum =0;
					tf =true;
					sb.append("0").append("\n");
					break;
				}
			}
			
			for(int i=0;i<9;i++) {
				sum=0;
				for(int j=0;j<9;j++) {
					sum += mat[i][j];
				}
				if(sum !=45) {
					sum =0;
					tf =true;
					sb.append("0").append("\n");
					break;
				}
			}
			
			for(int i=0;i<9;i++) {
				sum=0;
				for(int j=0;j<9;j++) {
					sum += mat[j][i];
				}
				if(sum !=45) {
					sum =0;
					tf =true;
					sb.append("0").append("\n");
					break;
				}
			}
			
			if(tf ==false) {
				sb.append("1").append("\n");
			}
			tf = false;
		}
		System.out.println(sb.toString());
	}

}
