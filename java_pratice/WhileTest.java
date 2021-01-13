package sjava;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		//수를 입력받아 그 합이 30이상이 될 때까지의 횟수를 구하여라
		Scanner sc = new Scanner(System.in);
		int sum=0,count=0;
		
		
		while(sum <30){
		int num =sc.nextInt();
			sum = sum+num;
			count++;
		}
		System.out.println(count +"번입니다.");
	}

}
