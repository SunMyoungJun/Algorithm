import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int num = 1000 - N;
		int cnt=0;


		while(num /500 !=0) {
			cnt += num/500;
			num = num%500;
		}
		while(num/100 !=0) {
			cnt+=num/100;
			num = num%100;
		}
		while(num/50 !=0) {
			cnt+=num/50;
			num=num%50;
		}
		while(num/10 !=0) {
			cnt+=num/10;
			num=num%10;
		}
		while(num/5 !=0) {
			cnt+=num/5;
			num=num%5;
		}
		cnt+= num;
		System.out.println(cnt);




	}

}
