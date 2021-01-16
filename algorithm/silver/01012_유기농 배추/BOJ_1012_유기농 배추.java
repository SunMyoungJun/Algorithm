import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
static int[][] arr1;
	public static void four(int x,int y)
	{
		if(arr1[x-1][y] ==1)
		{
			arr1[x-1][y] =2;
			four(x-1,y);
		}
		if(arr1[x][y+1] ==1)
		{
			arr1[x][y+1] =2;
			four(x,y+1);
		}
		if(arr1[x+1][y] ==1)
		{
			arr1[x+1][y] =2;
			four(x+1,y);
		}
		if(arr1[x][y-1] ==1)
		{
			arr1[x][y-1] =2;
			four(x,y-1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int test= Integer.parseInt(br.readLine());
		
		
		while(test !=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int horiz =Integer.parseInt(st.nextToken());
			int verti = Integer.parseInt(st.nextToken());
			int cabbage =Integer.parseInt(st.nextToken());
			arr1 = new int[verti+2][horiz+2];
			int count=0;
			for(int i=0;i<cabbage;i++)
			{
				 st = new StringTokenizer(br.readLine());
				 int x = Integer.parseInt(st.nextToken());
				 int y = Integer.parseInt(st.nextToken());
				arr1[y+1][x+1] =1;
			}
			
			for(int i=1; i<verti+1;i++)
				for(int j=1;j<horiz+1;j++)
				{
					if(arr1[i][j] ==1)
					{
						arr1[i][j] =2;
						count++;
						four(i,j);
					}
						
				}
			System.out.println(count);
			test--;
		}
	}

}
