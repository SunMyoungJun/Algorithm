import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] arr1;
	static boolean[] check;
	static int town;
	static int stop,ccount;
	static int min =Integer.MAX_VALUE;
	
	
	public static void arr1_func(int start,int next,int towncount,int sum) {
		if(towncount == town && start ==next)
		{
			min = (min < sum) ? min :sum;
			return;
		}
		
		else
		{
			for(int i=0;i<town;i++)
			{
				if(check[i] == false && arr1[next][i] >0)
				{
					check[i] = true;
					sum += arr1[next][i];
					arr1_func(start,i,towncount+1,sum);
					check[i] = false;
					sum -=arr1[next][i];
				}
				
				
			}
			
		}
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		 town = Integer.parseInt(br.readLine());
		check = new boolean[town];
		arr1 = new int[town][town];
		for(int i=0;i<town;i++)
		{
			st  = new StringTokenizer(br.readLine());
			for(int j=0;j<town;j++)
			{
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<town;i++)
			arr1_func(i,i,0,0);
		
		
		System.out.println(min);
	}

}
