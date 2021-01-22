package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution22 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		int pnum=1; 
		while(test !=0)
		{
			st  = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int sgm = Integer.parseInt(st.nextToken());
			int[][] arr1 = new int[size][size];			
			int count = sgm;
			for(int i=0; i<sgm;i++)    // 연못에 저장
			{
				int tempx =0,tempy=0;
				int plus3 = 3, minus3 =-3;
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int direct = Integer.parseInt(st.nextToken());
				
				if(arr1[x][y] == 1 )
				{
					count--;
					continue;
				}
				
				for(int j=0;j<3;j++)
				{
					int[] dx = {0,minus3,plus3,0,0};
					int[] dy = {0, 0,0,minus3,plus3};	
					tempx = x + dx[direct];
					tempy = y + dy[direct];
					if(tempx <0 || tempy <0 || tempx >=size || tempy >=size || arr1[tempx][tempy] == 1)
					{
						count--;
						arr1[x][y] =0;
						break;
					}
					arr1[x][y] =0; arr1[tempx][tempy] =1;
					x = tempx;  y = tempy;
					plus3 = plus3 -1;
					minus3 = minus3 +1;
				}
				
			}
			
			System.out.println("#"+pnum+" "+count);
			pnum++;
			test--;
		}
	
	}

}


