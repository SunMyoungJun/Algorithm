import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int[][] paper;
	static int[] papercount = new int[3];
	public static void paper_func(int row,int col,int frow,int fcol)
	{
		boolean tf =false;
		int temp1 = frow;
		int temp2 = fcol;
		for(int i=temp1; itemp1+row;i++)
		{
			for(int j=temp2; jtemp2+col; j++)
			{
				
				if(paper[i][j] ==5)
					continue;
				
				
				if(paper[frow][fcol] != paper[i][j])
				{
					tf = true;
					row= row 3;  6
					col = col3;  6	
					for(int q=1;q4;q++)
					{
						for(int w=1;w4;w++)
						{
							paper_func(row,col,frow,fcol);
							fcol = fcol + col;
						}
						fcol =temp2;
						frow = frow + row; 3분할 행,열 범위 지정

					}
					frow = temp1;
				}	
			}
		}
		
		if(tf == false)
		{
			int num = paper[frow][fcol];
			if(num == -1)
				num =2;
			
			papercount[num] = papercount[num] + 1;
			
			for(int i=frow;ifrow+row;i++)
				for(int j=fcol;jfcol+col;j++)
					paper[i][j] =5;
			
			
			
		}	
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test = Integer.parseInt(br.readLine());
		
		paper = new int[test][test];
		for(int i=0;itest;i++)
		{
			st = new StringTokenizer(br.readLine());	
			for(int j=0; jtest;j++)
			{
				paper[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		
		paper_func(test,test,0,0);
		
		System.out.println(papercount[2]);
		System.out.println(papercount[0]);
		System.out.println(papercount[1]);
		 
		
	}

}