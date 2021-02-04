package com.ssafy.subset_statck_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q1_QueueAPITest {

	public static void main(String[] args) {
//		 LinkedList<String> queue = new LinkedList<String>(); //이렇게 안쓰는이유 큐말고 다른 인터페이스들을 많이 구현중이라서 큐만쓸거면 밑에처럼사용
		 Queue<String> queue = new LinkedList<String>();
		 System.out.println(queue.isEmpty()+"//"+queue.size());
		 queue.offer("김태희");
		 queue.offer("윤이진");
		 queue.offer("노효진");
		 queue.offer("변성문");
		 queue.offer("최우선");
		 
		 System.out.println(queue.isEmpty()+"//"+queue.size());
		 System.out.println(queue.peek());
		 System.out.println(queue.isEmpty()+"//"+queue.size());
		 
		 while(!queue.isEmpty()) {
			 System.out.println(queue.poll());
		 }
		 System.out.println(queue.poll());
	}

}
