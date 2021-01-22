package com.ssafy.ws02.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t=0;t<test;t++)
		{
			String temp;
			int rowcol = Integer.parseInt(br.readLine()); 
			char[][] arr1 = new char[rowcol+2][rowcol+2];   //입력 받은 가로 세로 길이 만큼 할당
			for(int i=0;i < rowcol+2;i++)
			{
				arr1[0][i] = 'B';
				arr1[rowcol+1][i] = 'B';
				arr1[i][0] ='B';
				arr1[i][rowcol+1] ='B';
			}
			
			for(int i=1; i<rowcol+1;i++) //배열에 입력되는 문자 저장
			{
				temp = br.readLine();
				for(int j=1;j<rowcol+1;j++)
					arr1[i][j] = temp.charAt(j-1);
			}
						
			int sum=0,max =0;
			for(int i=1;i<rowcol+1;i++)
			{
				for(int j=1;j<rowcol+1;j++)
				{
					sum=0;
					if(arr1[i][j] == 'G')   //방문 좌표 G면 생략
						continue;
					
					if(arr1[i][j-1] =='B' && arr1[i-1][j-1] =='B' && arr1[i-1][j] =='B' && arr1[i-1][j+1] =='B'
					&& arr1[i][j+1] =='B' && arr1[i+1][j+1] =='B' && arr1[i+1][j] =='B' && arr1[i+1][j-1] =='B')
					{
						for(int z=1;z<rowcol+1;z++)
						{
							if(arr1[i][z] == 'B')
								sum = sum+1;			
							if(arr1[z][j] =='B')
								sum = sum+1;
						}
						
						if(sum-1 > max)
							max = sum-1;
					}
					else if(max < 2)
						max =2;
				}
			}

			System.out.println("#"+(t+1)+" "+max);	
		
		}

	}
}
