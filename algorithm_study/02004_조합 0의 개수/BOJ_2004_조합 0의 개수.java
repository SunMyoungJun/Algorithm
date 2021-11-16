import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt1=0,cnt2=0;
		
		int num1 = mode5(n);
		int num2 = mode2(n);
		
		int num3 = mode5(n-m);
		int num4 = mode2(n-m);
		
		int num5 = mode5(m);
		int num6 = mode2(m);
		
		num1 = num1 - num3 - num5;
		num2 = num2 - num4 - num6;
		
		System.out.println(Math.min(num1, num2));
		
	}
	
	static int mode2(int num) {
		int cnt=0;
		for(long i=2; i<=num; i=i*2) {
			cnt += num/i;
		}
		return cnt;
	}
	
	static int mode5(int num) {
		int cnt=0;
		for(long i=5; i<=num; i=i*5) {
			cnt += num/i;
		}
		return cnt;
	}

}
