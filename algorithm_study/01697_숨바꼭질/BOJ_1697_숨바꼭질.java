import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int max = (N > K) ? N*2+1 : K*2+1;
		int size=0,cnt=0,num=0;
		boolean[] street = new boolean[max];
		Queue<Integer> q1 = new LinkedList<>();
		street[N] = true;
		q1.offer(N);
		while(!q1.isEmpty()) {
			size = q1.size();
			while(size-- !=0) {
				num = q1.poll();
				if(num == K) {
					System.out.println(cnt);
					return;
				}
				if(num+1 <max && street[num+1] == false) {
					street[num+1] = true;
					q1.offer(num+1);
				}
				if(num-1 >=0 && street[num-1] == false) {
					street[num-1] = true;
					q1.offer(num-1);
				}
				if(num*2 <max && street[num*2] == false) {
					street[num*2] = true;
					q1.offer(num*2);
				}
			} 
			cnt++;
		}
	}
}