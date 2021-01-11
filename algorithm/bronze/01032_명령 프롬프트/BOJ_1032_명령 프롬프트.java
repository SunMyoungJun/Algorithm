
import java.util.*;
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		String tsentence1 = sc.nextLine();
		String sentence1 = sc.nextLine();
		char[] arr1 = new char[sentence1.length()];
		for(int i=0;i<sentence1.length();i++)
			arr1[i] = sentence1.charAt(i);
		for(int i=0;i<test-1;i++)
		{
			String sentence2 = sc.nextLine();
			for(int j=0;j<sentence2.length();j++)
			{
				if(arr1[j] == sentence2.charAt(j))
					continue;
				else
					arr1[j] ='1';
			}

		}
		
		for(int i=0;i<arr1.length;i++)
		{
			if(arr1[i] =='1')
			{
				System.out.print("?");
			}
			else
			{
				System.out.print(arr1[i]);
			}
		}
		System.out.println("");
	}

}
