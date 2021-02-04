package com.ssafy.subset_statck_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_Mychew {

	public static void main(String[] args) {

		int N=20;  //마이쮸 갯수
		int person =1; //사람번호
		
		
		int[] p;
		int availableCnt =0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {person,1});
		while(N >0) {
			p = queue.poll();
			availableCnt = (N>=p[1]) ? p[1] : N;  //남은 마이쭈개수가 원하는 개수보다 많냐 ? 작냐?
			
			N -= availableCnt;
			if(N ==0) {
				System.out.println("마지막 마이쮸를 가져간 사람 : "+p[0]+","+availableCnt+"개");
			}
			else {
				System.out.println(p[0]+"번 사람이 마이쮸를 가져갑니다. 남은개수 : "+N+"개");
				p[1]++;
				queue.offer(p);
				queue.offer(new int[] { ++person ,1});
			}
		}
	
	}

}
