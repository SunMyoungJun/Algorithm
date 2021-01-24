import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int temp =1;
		int plus =6;
		int count=0;
		for(int i=0;i<num;i++)
		{
			if(temp >= num)
			{
				count++;
				break;				
			}
			else
			{
				count++;
				temp = temp +plus;
				plus = plus+6;
			}
			
		}
		System.out.println(count);
	}

}
