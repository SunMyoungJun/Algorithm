import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ham = sc.nextInt(); //햄 갯수
		int person = sc.nextInt(); //사람 수
		int[][] arr1 = new int[ham][1];
		
		for(int i=0; i<ham;i++)
			arr1[i][0] = person;
		
		int count =0;
		int amount = ham;
		int sum=0;
		int sizenum =arr1.length;
		while(true) //칼질 끝날때까지\
		{
			if(amount >= person)
			{
				sizenum = sizenum - person * (amount/person);
				amount = amount %person;
			}
			else if(amount ==0)
				break;
			else if(arr1[0][0] > amount)
			{
				for(int i=0;i<sizenum;i++)
				{
					arr1[i][0] -=amount;
					count++;
				}
			}
			else
			{
				while(true)
				{
					sum=0;
					for(int i=0;i<sizenum;i++)
					{
						if(arr1[i][0] ==-1)
							continue;
						sum =sum + arr1[i][0];
						arr1[i][0] = -1;
						if(sum>amount)
						{
							count++;
							arr1[i][0] = sum-amount;
							sum =0;
							i =i-1;
						}
						else if(sum == amount)
						{
							arr1[i][0] =-1;
							sum=0;
						}
							
					}
					sum=0;
					for(int i=0;i<sizenum;i++)
					{
						if(arr1[i][0] == -1)
							continue;
						sum += arr1[i][0];
					}
					if(sum >amount)
						continue;
					break;
				}
				break;
			}

		} 
		System.out.println(count);

	}	
		

}
