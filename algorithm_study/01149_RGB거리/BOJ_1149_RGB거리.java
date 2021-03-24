import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] house = new int[N+1][3];
		for(int i=1; i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=2;i<N+1;i++) {
			for(int j=0;j<3;j++) {
				int temp =Integer.MAX_VALUE;
				for(int t=0;t<3;t++) {
					if(j!=t)
						temp = Math.min(temp, house[i-1][t]);
				}
				house[i][j] = temp + house[i][j]; 
			}
		}
		int MIN = Math.min(house[N][0], Math.min(house[N][1], house[N][2]));
		System.out.println(MIN);
	}
}