import java.util.Scanner;

public class Main{
	static int[] arr1;
	static int N;
	static int count=0;
	
	public static boolean isRight(int[] arr1,int row)
	{
		for(int i=1; i<row;i++)
		{
			if(arr1[i] == arr1[row])
			{
				return false;
			}
			if(Math.abs(i-row) == Math.abs(arr1[i] - arr1[row]))  //같은대각선일떄 (절대값 계산)
			{
				return false;
			}
		}
		return true;
	}
	
	public static void arr1_func(int[] arr1, int row)
	{
		if(row ==N)
		{
			count++;
			return;
		}
		else
		{
			for(int i=1;i<=N;i++)
			{
				arr1[row+1] =i;
				if(isRight(arr1,row+1))
				{
					arr1_func(arr1,row+1);
				}
			}
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		arr1 = new int[N+1];
		
		
		for(int i=1;i<=N;i++)
		{
			arr1[1] = i;
			
			arr1_func(arr1,1);
		}
		
		
		System.out.println(count);
	}

}
