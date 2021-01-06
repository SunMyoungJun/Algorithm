package testProject;

import java.util.*;

public class pratice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arrA = new ArrayList<>();
		ArrayList<Integer> arrB = new ArrayList<>();
		int A = sc.nextInt();
		int B = sc.nextInt();

		for(int i=0; i<A;i++)
			arrA.add(sc.nextInt());
		for(int i=0;i<B;i++)
			arrB.add(sc.nextInt());
		int tempj=0;
		int count=0;
		
		Collections.sort(arrA);
		Collections.sort(arrB);
		
		for(int i=0; i<A;i++)
			for(int j=tempj;j<B;j++)
			{
				if(arrA.get(i).intValue() == arrB.get(j).intValue())
				{
					count++;
					tempj = j+1;
				}
				else if(arrA.get(i).intValue() < arrB.get(j).intValue())
				{
					tempj =j;
					break;
				}
					
			}
		System.out.println(arrA.size()-count+arrB.size()-count);
	}
}
