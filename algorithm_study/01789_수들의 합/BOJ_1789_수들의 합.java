import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long num = sc.nextLong();
		long cnt=0;
		long idx=1;
		if(num ==1) {
			System.out.println(num);
			return;
		}
		while(num >-1) {
			num = num -idx++;
			cnt++;
		}
		System.out.println(cnt-1);

	}

	
}
