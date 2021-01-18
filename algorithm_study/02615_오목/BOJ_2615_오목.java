package sjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ohmok {
	static int[][] arr1;
	static int board_cal(int row, int col, int egg, int direct, int count) {
		int Acount=0;
		
		
		 if(direct ==5) // 오른쪽
		{
			if(arr1[row][col+1] == egg)
				Acount = board_cal(row,col+1,egg,direct,count+1);
			else
				return count;
		}
		else if(direct ==6) //왼쪽 아래
		{
			if(arr1[row+1][col-1] == egg)
				Acount = board_cal(row+1,col-1,egg,direct,count+1);
			else
				return count;
		}
		else if(direct ==7) //아래
		{
			if(arr1[row+1][col] == egg)
				Acount = board_cal(row+1,col,egg,direct,count+1);
			else
				return count;
		}
		else if(direct == 8) //오른쪽 아래
		{
			if(arr1[row+1][col+1] == egg)
				Acount = board_cal(row+1,col+1,egg,direct,count+1);
			else
				return count;
		}
		return Acount;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 arr1 = new int[21][21];
		
		for(int i=1;i<20;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<20;j++)
			{
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count=0,x=0,y=0,realegg=0;
	aaa:for(int i=1;i<20;i++)
		{
			for(int j=1;j<20;j++)
			{
				if(arr1[i][j] !=0)
				{
					//int row, int col, int egg, int direct, int count
					//행,열,바둑알색,방향,연속갯수
					
					count = board_cal(i,j,arr1[i][j],5,1); //오른쪽
					if(count == 5 && arr1[i][j-1] !=arr1[i][j])
						{
						x=i; y=j; realegg = arr1[i][j];
						break aaa;
						}
					
					count = board_cal(i,j,arr1[i][j],6,1); //왼쪽 아래
					if(count == 5 && arr1[i-1][j+1] !=arr1[i][j])
						{
						x = i+4; y = j-4; realegg = arr1[i][j];
						break aaa;
						}
					
					count = board_cal(i,j,arr1[i][j],7,1); //아래
					if(count == 5 && arr1[i-1][j] !=arr1[i][j])
						{
						x=i; y=j; realegg = arr1[i][j];
						break aaa;
						}
					
					count = board_cal(i,j,arr1[i][j],8,1); //오른쪽 아래
					if(count == 5 && arr1[i-1][j-1] !=arr1[i][j])
						{
						x=i; y=j; realegg = arr1[i][j];
						break aaa;
						}
				}
				
			}
		}
		
		if(realegg !=0)
		{
			System.out.println(realegg);
			System.out.println(x+" "+y);
		}
			
		else
			System.out.println("0");
		
		
	}

}
