import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int N;
	static int[][] mat;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		String s;
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<N;j++) {
				mat[i][j] = s.charAt(j)-48;
			}
		}
		divcon(0,0,N);
		System.out.println(sb.toString());
	}

	static void divcon(int row,int col,int size) {
		
		if(size ==1) {
			sb.append(mat[row][col]);
			return;
		}
	
		int temp = mat[row][col];
		boolean tf =false;
		for(int i=row; i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(mat[i][j] !=temp) {
					sb.append('(');
					divcon(row,col,size/2); //왼위
					divcon(row,col+size/2,size/2); //오른위
					divcon(row+size/2,col,size/2); //왼밑
					divcon(row+size/2,col+size/2,size/2); //오른밑
					sb.append(')');
					return;
				}
			}
		}
		sb.append(temp);
	}
}
