package com.ssafy.day10;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQTest {

	public PQTest() {


		// 스택, 큐, 데큐, 리스트, 링크드리스트 => 자료구조 구현(B, C)
		//      자료구조 활용 (IM, A) 
			// 큐  (선입선출) 무조건 먼저들어온놈을 먼저활용하고 끝 (재활용X)
			//A,B,C  list.get(1) ,poll()
			//우선순위 큐 내부가 정렬되어 있다(힙Tree로 정렬).

			//숫자를 넣어서 정렬 오름 차순으로 
			//넣을때는 순서 무시 , 뺄때(얻어온다X)는 순서대로 출력

			//5,3,4,7,6,2 
			//출력 순서(오름차순)대로 빼오고 싶다.
			//일반적인 콜렉션 만들어서 정렬하고 출력하면되겠네요
//			PriorityQueue<Integer> pq = new PriorityQueue<>();  //기본 오름차순
			//시간복잡도, 삽입 => logN, 출력(poll) => 1
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
				
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return (o1 > o2) ? 1 : -1;
				}
				
			});
			pq.offer(5);
			pq.offer(3);
			pq.offer(4);
			pq.offer(7);
			pq.offer(6);
			pq.offer(2);
			System.out.println(String.format("현재 갯수 : %d", pq.size()));
			System.out.println(pq.poll());
			System.out.println(String.format("현재 갯수 : %d", pq.size()));
			System.out.println(pq.poll());
			System.out.println(pq.poll());
			System.out.println(pq.poll());
			System.out.println(pq.poll());
			System.out.println(pq.poll());
			System.out.println("end");

			if(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}

			System.out.println("end1");
		}

		public static void main(String[] args) {
			new PQTest();
		}

	}
