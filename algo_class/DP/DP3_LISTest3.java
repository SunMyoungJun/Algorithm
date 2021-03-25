package DP;

import java.util.Arrays;
import java.util.Scanner;

public class DP3_LISTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // 원소들 저장
		int[] LIS = new int[N];  // 각 위치 ==> LIS 길이를 만족하는 원소의 최소값
		
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		int size =0;
		for(int i=0; i<N;i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]); //binarySearch 따로 찾아보기
			temp = Math.abs(temp) -1; //중복 값이 없으므로 탐색에 실패하고 음수값이 리턴됨 / 우리가 원하는 삽입 위치 인덱스
			LIS[temp] = arr[i];  //맨뒤에 추가되거나(사이즈 증가될예정) , 기존위치에 덮어써지거나(사이즈 변화 없음)
			
			if(temp == size) { //수열마지막에 추가되면서 길어진거임.
				++size;
				
			}
			System.out.println(size);
		}
		
	}

}
