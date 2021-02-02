package testProject;
import java.util.*;
public class pratice5 {
	
static long[][] arr1;
static long sum;
	public static long plus(int a,int b)
	{
		long tsum=0;
		if(arr1[a][b] !=0)
		{
			return arr1[a][b];
		}
		else if(a==1)
		{
			arr1[a][b] = a*b;
			return arr1[a][b];
		}
		else if(a == b)
		{
			arr1[a][b] =1;
			return arr1[a][b];
		}
	
		for(int i=a-1;i<b;i++)   //a-1만큼
		{
			long temp =plus(a-1,i);
			arr1[a-1][i] =(int)temp;
			tsum = tsum + temp;
		}
		return tsum;
	}
	
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int test = sc.nextInt();
	
	for(int i=0;i<test;i++)
	{
		sum=0;
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		arr1 = new long[num1+1][num2+1];		
		 sum = plus(num1,num2);
		 System.out.println(sum);
	}
}
}
