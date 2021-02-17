package day10;
import java.util.PriorityQueue;

public class LamdaComparatorTest4 {

	public static void main(String[] args) {
		PriorityQueue<Data> pq = new PriorityQueue<Data>((o1,o2) -> o1.cnt == o2.cnt ? o2.x - o1.x : o1.cnt-o2.cnt);
		
		pq.offer(new Data(3,5,10));
		pq.offer(new Data(30,5,20));
		pq.offer(new Data(31,5,10));
		pq.offer(new Data(40,5,40));
		pq.offer(new Data(22,5,30));
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());	
		}		
	}
}
