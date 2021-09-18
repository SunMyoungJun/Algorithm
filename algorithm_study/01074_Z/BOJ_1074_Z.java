import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	static int count=0,Row=0,Col=0,N=0;
	static boolean a=false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 Row = Integer.parseInt(st.nextToken());
		 Col = Integer.parseInt(st.nextToken());
		N = (int)Math.pow(2,N);
		dfs(N,0,0,0);
	}	
	
	public static void dfs(int size,int row,int col,int count) {
		if(a ==true)
			return;
		
		if(size ==1)
		{
			if(row == Row && col ==Col)
			{
				System.out.println(count);
				a = true;
			}
			return;
		}
		if(row<=Row && Row<row+size/2 && col<=Col && Col< col+size/2)
			dfs(size/2,row,col,count);  //왼위
		else if(row<=Row && Row<row+size/2 && col+size/2<=Col && Col<N)
			dfs(size/2,row,col+size/2,count+(size/2)*(size/2));
		else if(row+size/2 <=Row && Row<N && col<=Col && Col<col+size/2)
			dfs(size/2,row+size/2,col,count+(size/2)*(size/2)*2);  
		else if(row+size/2 <=Row && Row<N && col+size/2 <=Col && Col<N)
			dfs(size/2,row+size/2,col+size/2,count+(size/2)*(size/2)*3);
	}
}
