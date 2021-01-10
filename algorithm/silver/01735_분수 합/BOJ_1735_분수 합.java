

import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 =sc.nextInt();
		int num2 =sc.nextInt();
		int num3 =sc.nextInt();
		int num4 =sc.nextInt();
		
		int xnum = num1*num4 + num2*num3;
		int ynum = num2*num4;
		
		int t=2;
		for(int i=2; i<20002;i++)
		{
			if(xnum < i || ynum <i)
				break;
			if(xnum %i ==0 && ynum %i ==0)
			{
				xnum = xnum /i;
				ynum = ynum /i;
				i =1;
			}
		}
		
		System.out.println(xnum+" "+ ynum);
	}

}
