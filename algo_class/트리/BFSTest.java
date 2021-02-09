package com.ssafy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTest {
	static int[][] map;
	public static void main(String[] args) {
		map = new int[9+1][9+1]; // 0번쨰 버림.
		map[1][2] =1;
		map[1][3] =1;
		map[1][4] =1;
		
		map[2][5] =1;
		map[2][6] =1;
		map[4][7]= 1;
		map[4][8]= 1;
		map[4][9]= 1;
		
		bfs(1); //0번은 버림. 1번부터
		System.out.println();
	}
	
	static void bfs(int start) {
//		큐 생성
//		반복하면서 바뀌어야할 값 저장. 지금은 1개니까 Integer, 2개이상이면 int[]=>class
		Queue<Data>  q = new LinkedList<>();
//		첫번째 무조건 삽입
		q.offer(new Data(start));

//		큐가 빌 때 까지 할일 진행(그 위치의 문자열 출력)
		Data cur;
		while(!q.isEmpty()) {
//			큐에서 하나 빼서 할일 진행.
			cur = q.poll();
			System.out.print(datas[cur.num]+" ");
			
			for(int i=1; i<9+1;i++) {
				if(map[cur.num][i] ==1) {
					q.offer(new Data(i));
				}
				
				
			}
			
		}
		
//		경우에 따라선 목표 완료하면 중간에 빠져 나오기.
	}
	
	static String[] datas = {"","A","B","C","D","E","F","G","H","I","J"};
	
	
	
	static class Data {
		int num;

		public Data(int num) {
			this.num = num;
		}
		
		
	}
}
