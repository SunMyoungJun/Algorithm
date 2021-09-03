import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Queue<Integer>q1 = new LinkedList<>();
		for(int i=1;i<num+1;i++)
			q1.offer(i);
		
		int temp=0;
		while(q1.size() !=1) {
			temp = q1.poll();
			temp = q1.poll();
			q1.offer(temp);
		}
		System.out.println(q1.poll());
	}
}
