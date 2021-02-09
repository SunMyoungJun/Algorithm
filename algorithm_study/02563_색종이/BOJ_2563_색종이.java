import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] check = new int[101][101];
		int count = Integer.parseInt(br.readLine());
		int row=0,col=0,sum=0;
		while(count -- !=0) {
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			
			for(int i=row; i<row+10;i++) 
				for(int j=col; j<col+10; j++)
					check[i][j]++;				
		}
	
		for(int i=0;i<101;i++) 
			for(int j=0;j<101;j++) 
				if(check[i][j] >=1) 
					sum++;
		
		System.out.println(sum);
	}

}
