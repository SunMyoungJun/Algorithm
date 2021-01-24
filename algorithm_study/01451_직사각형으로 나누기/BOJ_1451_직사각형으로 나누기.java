import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] arr1;
	
	
	public static long arr1_func(int row,int col,int drow, int dcol)
	{
		long sum=0;
		for(int i=row; i<drow; i++)
			for(int j=col; j<dcol;j++)
				sum = sum+arr1[i][j];
		return sum;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		arr1 = new int[row+1][col+1];
		long sum1,sum2,sum3 =0;
		String s;
		for(int i=0;i<row;i++)
		{
			s = br.readLine();
			for(int j=0;j<col;j++)
				arr1[i][j] = s.charAt(j)-48;
		
		}
			
	 	 long max = Integer.MIN_VALUE;
		for(int i=1;i<row;i++)              ///  1
		{
			for(int j=1; j<col;j++)
			{
				sum1 = arr1_func(0,0,i,col);
				sum2 = arr1_func(i,0,row,j);
				sum3 = arr1_func(i,j,row,col);
				max = (max < sum1*sum2*sum3) ? sum1*sum2*sum3 :max;
			}
		}
		
		
		for(int i=row-1;i>=0;i--)              ///  2
		{
			for(int j=0; j<col;j++)
			{
				sum1 = arr1_func(i,0,row,col);
				sum2 = arr1_func(0,0,i,j+1);
				sum3 = arr1_func(0,j+1,i,col);
				max = (max < sum1*sum2*sum3) ? sum1*sum2*sum3 :max;
			}
		}	
		
		
		for(int i=1;i<col;i++)              ///  3
		{
			for(int j=1; j<row;j++)
			{
				sum1 = arr1_func(0,0,row,i);
				sum2 = arr1_func(0,i,j,col);
				sum3 = arr1_func(j,i,row,col);
				max = (max < sum1*sum2*sum3) ? sum1*sum2*sum3 :max;
			}
		}
		
		
		for(int i=col-1;i>=0;i--)              ///  4
		{
			for(int j=1; j<row;j++)
			{
				sum1 = arr1_func(0,i,row,col);
				sum2 = arr1_func(0,0,j,i);
				sum3 = arr1_func(j,0,row,i);
				max = (max < sum1*sum2*sum3) ? sum1*sum2*sum3 :max;
			}
		}
		
		
		for(int i=1;i<row-1;i++)              ///  5
		{
			for(int j=i+1; j<row;j++)
			{
				sum1 = arr1_func(0,0,i,col);
				sum2 = arr1_func(i,0,j,col);
				sum3 = arr1_func(j,0,row,col);
				max = (max < sum1*sum2*sum3) ? sum1*sum2*sum3 :max;
			}
		}
	
		for(int i=1;i<col;i++)              ///  6
		{
			for(int j=i+1; j<col;j++)
			{
				sum1 = arr1_func(0,0,row,i);
				sum2 = arr1_func(0,i,row,j);
				sum3 = arr1_func(0,j,row,col);
				max = (max < sum1*sum2*sum3) ? sum1*sum2*sum3 :max;
			}
		}
		
		System.out.println(max);
	}

}
