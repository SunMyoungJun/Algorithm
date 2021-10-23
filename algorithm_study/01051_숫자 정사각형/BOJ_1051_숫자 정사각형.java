import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		int num = Math.min(N, M);
		int len1 =0,len2=0,max=1;
		int num1=0,num2=0,num3=0,num4=0;
		for(int t=1; t<=num; t++) {
			len1 = N-t;
			len2 = M-t;
			for(int i=0; i<=len1; i++) {
				for(int j=0; j<=len2; j++) {
					num1 = map[i][j];
					num2 = map[i][j+t-1];
					num3 = map[i+t-1][j];
					num4 = map[i+t-1][j+t-1];
					if(num1 ==num2 && num1 == num3 && num1 == num4) {
						max = (max > t) ? max : t;
					}
				}
			}
		}
		System.out.println(max*max);
		
		
	}

}
