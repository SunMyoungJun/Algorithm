import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Queue<Long> q1 = new LinkedList<Long>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt=0,size=0;
		if(N==0) {
			System.out.println(cnt);
			return;
		}
		for(int i=1;i<10;i++) {
			q1.offer((long) i);
			cnt++;
			if(N == cnt) {
				System.out.println(i);
				return;
			}
		}
		long temp=0,single=0; 
		while(!q1.isEmpty()) {
			size = q1.size();
			
			for(int i=0;i<size;i++) {
				temp = q1.poll();
				single = temp % 10;
				
				for(int j=0; j<single; j++) {
					q1.offer(temp*10 + j);
					cnt++;
					if(N == cnt) {
						System.out.println(temp*10 +j);
						return;
					}
				}
			}
		}
		System.out.println("-1");
	}
}