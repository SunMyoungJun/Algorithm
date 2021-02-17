package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ색종이2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		int row=0,col=0,sum=0;
		int[][]check = new int[101][101];
		int[] dx = {-1,0,1,0}; 
		int[] dy = {0,1,0,-1};

		for(int t=0; t<num;t++) {
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());		

			for(int i=row;i<row+10;i++) {
				for(int j=col; j<col+10;j++) 
					check[i][j] =1;
			}

		}
		int tx=0,ty=0;
		for(int i=0; i<101;i++) {
			for(int j=0;j<101;j++) {
				if(check[i][j] ==1) {
					for(int k=0;k<4;k++) {
						tx = i+dx[k];
						ty  = j+dy[k];
						if(tx <0 || tx >100 ||ty<0 || ty>100)
							continue;
						if(check[tx][ty] == 0) 
							sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}


