package com.ssafy.recursive;

public class R2_ArrayTest {

	static int arr[] = {10,20,30};
	
	
	// 배열의 현재 원소를 출력
	private static void printArray1(int i) {
		if(i ==arr.length)
		{
			System.out.println(); //줄바꿈
			return;
		}
		
		
		System.out.print(arr[i]+"\t");
		printArray1(i+1);
	}
	
	
	static int arr2[][] = {{11,12,13},{20,30,40}};        //얘를 행단위로 출력하는걸로 재귀 만들었는데 개인 과제 : 원소 하나씩 출력하는걸 재귀적으로 해결해봐라.
															// 단 , 11,12,13 출력되면 줄바꿈 되게 해야함.
	
	//배열의 현재행 원소를 모두 출력
	private static void printRowArray(int i) {
	
		if(i == arr2.length) return;
		
		for (int j = 0; j < arr2[i].length; j++) {
			System.out.print(arr2[i][j]+"\t");
		}
		System.out.println();
		
		printRowArray(i+1);  //유도 파트
	}
	
		
	public static void main(String[] args) {
		
		printArray1(0);
		System.out.println("------------------");
		printRowArray(0);
	}

}
