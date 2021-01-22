package com.ssafy.array;

public class Lotto {

	public static void main(String[] args) {
		int[] arr1 = new int[6];
		boolean[] check = new boolean[46];
		int num,count;
		boolean bf = true;
		for(int i=0; i<arr1.length;i++)
		{	
			num = (int)(Math.random() *45+1);
			if(check[num] == true)
			{
				i--;
				continue;
			}
			check[num] = true;
			arr1[i] = num;

		}
	
		
		for(int a : arr1)
			System.out.print(a+" ");

	}

}
