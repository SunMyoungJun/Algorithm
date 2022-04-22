
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt=0,num=0;
		for(int i=n; i>0;i--) {
			if(i%5==0) {
				num=i;
				while(num%5==0) {
					cnt++;
					num=num/5;
				}
			}
		}
		System.out.println(cnt);
	}
}

