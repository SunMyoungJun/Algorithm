import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] check;
	static int[][] arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int n =0,m=0;
		check = new int[N+1][N+1];
		int[][] arr1 = new int[N+1][N+1];
		
		for(int i=1;i<M+1;i++)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr1[n][m] = 1; arr1[m][n] =1;
		}


		for(int t=1;t<N+1;t++)
			for(int i=1;i<N+1;i++)
				for(int j=1;j<N+1;j++)
				{
					if(i ==j)
						continue;
					
					else if(arr1[i][t] >0 && arr1[t][j]>0)     //한계 거쳐가는거 존재할 떄 
					{
						if(arr1[i][j] ==0)
							arr1[i][j] = arr1[i][t]+arr1[t][j];
						else if(arr1[i][j] > arr1[i][t] + arr1[t][j])
							arr1[i][j] = arr1[i][t] + arr1[t][j];
					}
				}
		
		int sum=0,num=0;
		int min = Integer.MAX_VALUE;
		for(int i=1; i<N+1;i++)
		{
			for(int j=1;j<N+1;j++)
			{
				sum +=arr1[i][j];
			}
			if(min >sum)
			{
				min =sum;
				num =i;
			}
			
			sum=0;
		}

		System.out.println(num);
	
	}

}
