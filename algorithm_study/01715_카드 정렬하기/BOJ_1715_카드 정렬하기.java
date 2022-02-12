import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++) 
			pq1.offer(Integer.parseInt(br.readLine()));
		int num1=0,num2=0,num3=0,sum=0;
		while(!pq1.isEmpty()) {
			if(pq1.size() ==1) 
				break;
			num1 = pq1.poll();
			num2 = pq1.poll();
			num3 = num1+num2;
			sum += num3;
			pq1.offer(num3);
		}
		System.out.println(sum);
	}
}