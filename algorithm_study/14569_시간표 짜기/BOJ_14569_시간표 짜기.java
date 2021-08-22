import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] subject = new int[N][];
		int M =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			subject[i] = new int[M];
			for(int j=0;j<M;j++) {
				subject[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		
		boolean[][] student = new boolean[m][51];
		
		int n =0,n2=0;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<n;j++) {
				n2 = Integer.parseInt(st.nextToken());
				student[i][n2] = true;
			}
		}
		int[] students = new int[m];
		
		StringBuilder sb = new StringBuilder();
		int cnt =0;
		boolean flag = false;
		
		for(int y=0;y<m;y++) {
			for(int i =0; i<N;i++) {
				flag = false;
				M = subject[i].length;
				for(int j =0; j<M;j++) {
					if(student[y][subject[i][j]] == false) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					students[y]++;
				}
			} 
		}
	
		for(int i=0;i<m;i++) {
			sb.append(students[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
