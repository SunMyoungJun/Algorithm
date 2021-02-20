import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] dx = {-1,0,1,0};  //  북 동 남 서
	static int[] dy = {0,1,0,-1};
	static int N,M;
	static int sr,sc,sd;
	static int[][] mat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int tx=0,ty=0;
		int dircount=0;
		mat[sr][sc] = 2;
		int cnt =1;
		while(true) {
			tx = sr + dx[(sd+3)%4];
 			ty = sc + dy[(sd+3)%4];
			
 			if(dircount ==4) {  //4방향 모두 청소할 수 없을때
				tx = sr + dx[(sd+2) %4];
				ty = sc + dy[(sd+2) %4]; 
				
				if(mat[tx][ty] ==1) { //후진도 안될 떄 
					break;
				}
				else {  //후진 
					dircount =0;
					sr = tx;
					sc = ty;
					continue;
				}
			}
			
			
 			if(mat[tx][ty] == 0) {  //왼쪽에 청소할 공간 있으면 청소
 				sr = tx;
				sc = ty;
				sd = (sd+3) %4;
				cnt++;
				mat[tx][ty] =2;
				dircount=0;
				continue;
			}
			if(mat[tx][ty] !=0) {  // 왼쪽 방향에 청소 공간 x 
				sd = (sd+3) %4;
				dircount++;
				continue;
			}
			
		}
		
		System.out.println(cnt);
	}

}
