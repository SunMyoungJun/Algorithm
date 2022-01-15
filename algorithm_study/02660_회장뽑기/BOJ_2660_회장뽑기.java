import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n1=0,n2=0,sum=0;
		
		int[][] map = new int[N+1][N+1];
		int[] result = new int[N+1];
		
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(i==j) {
					map[i][j] = 0;
					continue;
				}
				map[i][j] = 987654321;
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			if(n1 == -1 && n2 == -1) {
				break;
			}
			map[n1][n2] = 1;
			map[n2][n1] = 1;
		}
		
		
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				for(int z=1;z<N+1;z++) {
					sum =map[j][i] + map[i][z];
					if(sum < map[j][z]) {
						map[j][z] = sum;
					}
				}
			}
		}
		
		int cnt=0;
		int max=0,min = Integer.MAX_VALUE;
		for(int i=1; i<N+1; i++) {
			max = -1;
			for(int j=1; j<N+1; j++) {
				if(i==j)
					continue;
				max = Math.max(max, map[i][j]);
			}
			result[i] = max;
			if(min > max) {
				min = max;
				cnt=1;
			}
			else if(min == max) {
				cnt++;
			} 
		}
		
		sb.append(min).append(" ").append(cnt).append("\n");
		int count=0;
		for(int i=1; i<N+1; i++) {
			if(result[i] == min) {
				count++;
				if(count == cnt) {
					sb.append(i);
				}
				else {
					sb.append(i).append(" ");
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}