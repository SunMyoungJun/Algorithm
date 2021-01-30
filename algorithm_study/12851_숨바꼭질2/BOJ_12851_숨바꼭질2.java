import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
	static int[]arr1;
	static int min = Integer.MAX_VALUE,dong=0,count=0;
	static class node{
		int type; // 0: 뺄셈 / 1 : 덧셈 / 2: 곱셈
		int value;
		int sec;
		
		public node(int type,int value,int sec)
		{
			this.type = type;
			this.value = value;
			this.sec = sec;
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int subin = Integer.parseInt(st.nextToken());
		dong = Integer.parseInt(st.nextToken());
		arr1 = new int[200000];
		
		node n = new node(2,subin,0);
		node tempn;
		node tempn0,tempn1,tempn2;
		Queue<node> q = new LinkedList<>();
		
		q.add(n);
		while(!q.isEmpty())
		{
			tempn = q.poll();
			if(min < tempn.sec || tempn.value <0 || tempn.value >arr1.length)
				continue;
			if(arr1[tempn.value] !=0 && arr1[tempn.value] <tempn.sec)
				continue;
			if(arr1[tempn.value] ==0)
				arr1[tempn.value] = tempn.sec;
			if(tempn.value == dong)
			{  
				if(min > tempn.sec)
				{
					min = tempn.sec;
					count =1;
				}
				else if(min ==tempn.sec)
					count++;
				
			 continue;
			}
			else{
				tempn0 = new node(0,tempn.value-1,tempn.sec+1);
				tempn1 = new node(1,tempn.value+1,tempn.sec+1);
				tempn2 = new node(2,tempn.value*2,tempn.sec+1);
				if(tempn.type != 1 && tempn0.value <arr1.length)    //전에께 덧셈이 아니면 빼기 작업
					q.add(tempn0);
				if(tempn.type != 0 && tempn1.value <arr1.length)    //전에께 뺄셈이 아니면 덧셈 작업
					q.add(tempn1);
			
				if(tempn2.value < arr1.length)
					q.add(tempn2);
			
			}
		}

		System.out.println(min);
		System.out.println(count);
	}

}
