package com.ssafy.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*  회의신청갯수 / 회의번호,시작시간,종료시간
10 
1 1 4  
2 1 6
3 6 10
4 5 7
5 3 8
6 5 9
7 3 5
8 8 11
9 2 13
10 12 14  
 
 */
public class MeetingRoomTest {
	static class MeetingRoom implements Comparable<MeetingRoom>{
		int no,start,end;

		public MeetingRoom(int no, int start, int end) {
			this.no = no;
			this.start = start;
			this.end = end;
		}
		
		
//		(1,1,2) (2,2,3) (3,3,3)  -->정답 : 3개 (종료시간 기준 1차정렬)
//		(1,1,2) (3,3,3) (2,2,3) -->입력이 이렇게되버리면 정답 2개 가 되버림. 따라서 따로 2번째 정렬처리(종료시간 같으면 시작시간 빠른순정렬)를 해줘야함. 
		@Override
		public int compareTo(MeetingRoom o) {
			int diff = this.end - o.end;
			
			return diff!=0 ? diff : this.start - o.start ;
		}


		@Override
		public String toString() {
			return "MeetingRoom [no=" + no + ", start=" + start + ", end=" + end + "]";
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		MeetingRoom[] m = new MeetingRoom[N];
		
		for(int i=0; i<N; i++) {
			m[i] = new MeetingRoom(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		List<MeetingRoom> list = getSchedule(m);
		
		for(MeetingRoom meetingRoom : list) {
			System.out.println(meetingRoom);
		}
	}
	
	public static List<MeetingRoom> getSchedule(MeetingRoom[] m) {
		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>();
		
		Arrays.sort(m); //종료시간이 빠른순으로, 종료시간 같으면 시작시간이 빠른순으로 정렬됨.
		list.add(m[0]); //첫번째 회의는 무조건 넣음.
	
		for(int i=1; i<m.length;i++) {
			if(list.get(list.size()-1).end <= m[i].start) {  //배정된 회의의 종료시간보다 시작시간이 큰 회의를 리스트에 넣어서 배정.
				list.add(m[i]);
			}
		}
		
		return list;
		
		
		
		
		
		
		
		
		
	
	}

}
