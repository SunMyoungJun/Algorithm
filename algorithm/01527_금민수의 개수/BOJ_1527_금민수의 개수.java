import java.util.Scanner;
public class Main{
	static int count=0;
	static int num1=0,num2=0;
	public static void plus(long a)
	{
		long temp1 = a*10 +4;
		long temp2 = a*10 +7;
		
		if(a >num2)
			return;
		if(temp1 <=num2)
		{
			if(temp1 < num1)
				plus(temp1);
			else
			{
				count++;
				plus(temp1);	
			}
			
		}
		if(temp2 <=num2)
		{
			if(temp2 < num1)
				plus(temp2);
			else
			{
				count++;
				plus(temp2);	
			}
		}
		else
			return;
	}
	
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	 num1 = sc.nextInt();
	 num2 = sc.nextInt();

	 if(4 >= num1 && 4<=num2)
		 count++;
	 if( 7>=num1 && 7<=num2)
		 count++;
	
	plus(4);
	plus(7);
	System.out.println(count);

}
}
