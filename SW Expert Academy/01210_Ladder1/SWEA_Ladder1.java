import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test =10,num =0;
		int[][] arr1 = new int[100][100];
		for(int t=0;t<test;t++)
		{
			int tnum = Integer.parseInt(br.readLine());
			int temp =0;
			for(int i=0;i<100;i++)
			{
				st = new StringTokenizer(br.readLine());

				for(int j=0;j<100;j++)
				{
					arr1[i][j] = Integer.parseInt(st.nextToken());
					if(arr1[i][j] == 2)
					{
						temp = j;
					}
				}
			}
			int row =99;
			int col =temp;
			boolean[][] check = new boolean[100][100];

			while(true) {

				if(row==0)
				{
					num = col;
					break;
				}

				//0까지 가면 종료 무조건 해야함.
				check[row][col] = true;
				if((col-1) >=0 && arr1[row][col-1] ==1 && check[row][col-1] == false)
				{
					col = col-1;
				}
				else if((col+1)<100 && arr1[row][col+1] ==1 && check[row][col+1] == false)
				{
					col = col+1;
				}
				else if((row-1) >=0 && arr1[row-1][col] ==1 && check[row-1][col] ==false)
				{
					row = row-1;
				}

			}
			System.out.println("#"+tnum+" "+col);
		

		}
	}

}
