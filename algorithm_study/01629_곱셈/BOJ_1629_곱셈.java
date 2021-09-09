import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		long num = func1(A,B,C) % C;
		System.out.println(num);
	}
	
	static long func1(long A,long B,long C) {
		long num1=0,num2=0;
		if(B ==1)
			num1 = A * B %C;
		
		else if(B %2 ==0) { //짝수 
			num1 =  func1(A,B/2,C) %C;
			num1 = num1*num1 %C;
		}
		else if(B%2==1) { //홀수
			num1 = func1(A,B/2,C) %C;
			num1= (num1*num1%C) *A %C;
		}
		return num1;
	}
}
