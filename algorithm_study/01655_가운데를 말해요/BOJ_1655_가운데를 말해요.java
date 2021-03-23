import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main{
	static int N;
	static PriorityQueue<Integer> q1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	static PriorityQueue<Integer> q2 = new PriorityQueue<Integer>();

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int num=0,div=0,cnt=0;
		int temp1=0,temp2=0;
		StringBuilder sb = new StringBuilder();
		while(N-- !=0) {
			num = Integer.parseInt(br.readLine());
			
			if(cnt ==0) {
				q1.offer(num);
				cnt =1;
			}
			else  {
				q2.offer(num);
				cnt =0;
			}
			
			if(!q2.isEmpty() && q1.peek() > q2.peek()) {
				temp1 = q1.poll();
				temp2 = q2.poll();
				q1.offer(temp2);
				q2.offer(temp1);
			}
			sb.append(q1.peek()).append("\n");
		}
		System.out.println(sb.toString());
	}
}