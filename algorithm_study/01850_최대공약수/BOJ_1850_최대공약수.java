import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		long num1 = Math.max(A, B);
		long num2 = Math.min(A, B);
		
		long cnt = result(num1,num2);
		
		long choi = 1;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=cnt; i++) {
			sb.append("1");
		}
		System.out.println(sb.toString());
	}
	
	
	static long result(long num1,long num2) {
		if(num1 % num2 ==0) {
			return num2;
		}
		return result(num2,num1%num2);
	}

}
