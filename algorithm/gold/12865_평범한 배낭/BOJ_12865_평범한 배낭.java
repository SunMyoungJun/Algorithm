import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int test = Integer.parseInt(st.nextToken());
		int kg = Integer.parseInt(st.nextToken());
		int[][] arr1 = new int[test+1][2];
		
		for(int i=1;i<test+1;i++)
		{
			st = new StringTokenizer(br.readLine());
			arr1[i][0] = Integer.parseInt(st.nextToken());
			arr1[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<test+1;i++) //배낭 무게 작은거부터 정렬.
		{	
			int temp1=0,temp2=0;
			for(int j=i+1;j<test+1;j++)
			{
				if(arr1[i][0] > arr1[j][0] || (arr1[i][0] == arr1[j][0] &&arr1[i][1] >arr1[j][1]))
				{
					temp1 = arr1[i][0];
					temp2 = arr1[i][1];
					arr1[i][0]= arr1[j][0];
					arr1[i][1] = arr1[j][1];
					arr1[j][0] = temp1;
					arr1[j][1] = temp2;
				}
			}
		}
		int[][] arr2 = new int[test+1][kg+1];
		for(int i=1; i<test+1;i++)
		{
			for(int j=1;j<kg+1;j++)
			{
				if(arr1[i][0] > j)
					arr2[i][j] = arr2[i-1][j];
				else
				{
					if(arr1[i][1] + arr2[i-1][j-arr1[i][0]] >arr2[i-1][j])
						arr2[i][j] = arr1[i][1] + arr2[i-1][j-arr1[i][0]];
			
					else
						arr2[i][j] = arr2[i-1][j];
				}
			}
		}
		System.out.println(arr2[test][kg]);
	}

}
