import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Long A,B;
	static int cnt;
	static Queue<Long> q1 = new LinkedList<Long>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		
		q1.offer(A);
		if(!bfs())
			cnt =-2;
		System.out.println(cnt+1);
	}
	
	static boolean bfs() {
		long temp=0;
		int size=0;
		
		while(!q1.isEmpty()) {
			size = q1.size();		
			for(int i=0;i<size;i++) {
				temp = q1.poll();
				
				if(temp == B)
					return true;
				if(temp > B)
					continue;
				
				q1.offer(temp*2);
				q1.offer(temp*10+1);
			}
			cnt++;
		}
		return false;
	}
}