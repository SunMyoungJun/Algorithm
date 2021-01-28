package com.ssafy;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {
	MySortComparator comparator = new MySortComparator();
	class MySortComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1.intValue() - o2.intValue(); //앞에서 뒤빼면 오름차순 / 뒤에서 앞에 뺴면 내림차순
		}
	}
		
	public CompareTest() {
		Integer[] arr = {1,4,7,5,2};
//		순서로 정렬하라
//		[1,2,4,5,7] : 오름차순
//		[7,5,4,2,1] : 내림차순
//		Arrays.sort(arr);
//		Arrays.sort(arr, comparator);
		Arrays.sort(arr,new Comparator<Integer>() {
			public int compare(Integer o1,Integer o2)
			{
				return -(o1 - o2);   //o1.intValue 이건데 생략됨 어짜피 1개 밖에 없어서 생략해도 오토로 됨.
			}
		});
		System.out.println(Arrays.toString(arr));
	}
	

	public static void main(String[] args) {
			new CompareTest();
	}

}
