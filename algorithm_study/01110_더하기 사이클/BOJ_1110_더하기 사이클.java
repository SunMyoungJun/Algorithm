import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n1=0,n2=0,result=0,cnt=1,temp=N;
		while(true) {
			n1 = temp%10;
			n2 = temp%10 + temp/10;
			result = n1*10+n2%10;
			if(result == N)
				break;
			temp = result;
			cnt++;
		}
		System.out.println(cnt);
	}
}