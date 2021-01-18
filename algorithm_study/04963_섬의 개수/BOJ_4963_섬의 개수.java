import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] arr1;
	
	static void area(int row,int col)
	{
		
		arr1[row][col] =-1;  //카운터 이미 끝난 지역
		if(arr1[row][col+1] == 1) //오른쪽
			area(row,col+1);
		if(arr1[row][col-1] == 1) // 왼쪽
			area(row,col-1);
		if(arr1[row+1][col] == 1) //아래쪽
			area(row+1,col);
		if(arr1[row-1][col] == 1) //위쪽
			area(row-1,col);
		if(arr1[row+1][col+1] == 1) // 오른쪽아래로
			area(row+1,col+1);
		if(arr1[row+1][col-1] == 1) // 왼쪽아래로
			area(row+1,col-1);
		if(arr1[row-1][col-1] == 1) // 왼쪽위로
			area(row-1,col-1);
		if(arr1[row-1][col+1] ==1) // 오른쪽위로
			area(row-1,col+1);
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			arr1 = new int[height+2][width+2];
			int count =0;
			
			if(width ==0 && height ==0)
				break;
			
			for(int i=1;i<height+1;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<width+1;j++)
				{
					arr1[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i=1; i<height+1;i++)
			{
				for(int j=1;j<width+1;j++)
				{
					if(arr1[i][j] == 1)
					{
						count++;
						area(i,j);
						
					}
				}
			}
			
			
			System.out.println(count);
			
			
			
			
			
			
		}

	}

}
