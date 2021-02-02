
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		String st1 = sc.next();
		String st2 = sc.next();
		
		long sum =0;
		for(int i=0;i<st1.length();i++)
			for(int j=0;j<st2.length();j++)
			{
				sum = sum + (st1.charAt(i)-48) * (st2.charAt(j)-48);
			}
			
		System.out.println(sum);
	}
}
