import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] mat = new int[101][101];
		int t = cnt;
		int x=0,y=0,width=0,height=0;
		int count=1;
		while(cnt-- !=0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			for(int i=100-y; i > 100-y-height ; i--) {
				for(int j=x; j < x+width ; j++) {
					mat[j][i] = count; 
				}
			}
			count++;
		}
		int sum=0;
		for(int k=1;k<t+1;k++) {
			sum =0;
			for(int i=0;i<101;i++) {
				for(int j=0; j<101;j++) {
					if(mat[i][j] ==k) {
						sum++;
					}
				}
			}
			System.out.println(sum);
		}
		
		
	}

}
