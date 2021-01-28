package com.ssafy;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest2 {

	public CompareTest2() {
		int[][] arr = {{2,50},{5,57},{1,53},{4,59},{3,56}};
//	sort하는데 1열의 값을 가지고 오름차순하라.
		
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j] + "\t");
			System.out.println();
		}
		
	
	
	}

	public static void main(String[] args) {
		new CompareTest2();

	}

}
