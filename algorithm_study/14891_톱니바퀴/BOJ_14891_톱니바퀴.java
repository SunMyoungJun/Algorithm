import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<ArrayList<Integer>> arr1 = new ArrayList<ArrayList<Integer>>();
	
	public static void dir_left(int number,int dir) {
		dir = -dir;
		if(arr1.get(number+1).get(6) == arr1.get(number).get(2))
			return;
		
		else if(number-1 >0)
			dir_left(number-1,dir);

		rotate(number,dir);

	}
	///////////////////////////////////////////////////////////////   두개 합칠수있는데 귀찮아서 그냥 두개 나눔 함수 ..
	public static void dir_right(int number,int dir) {
		dir = -dir;

		if(arr1.get(number-1).get(2) == arr1.get(number).get(6))
			return;
		
		else if(number+1 <5)
			dir_right(number+1,dir);
		
		rotate(number,dir);
		
	}
	
	public static void rotate(int number,int dir) {
		
		if(dir == 1)
		{
			int last = arr1.get(number).size()-1;
			int temp = arr1.get(number).get(last);
			arr1.get(number).remove(last);
			arr1.get(number).add(0,temp);	
		}
		else
		{
			int first = arr1.get(number).get(0);
			arr1.get(number).remove(0);
			arr1.get(number).add(arr1.get(number).size(),first);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = new String[5];
		arr1.add(new ArrayList<Integer>());
		for(int i=1;i<5;i++)   //입력 
		{
			s[i] = br.readLine();
			arr1.add(new ArrayList<Integer>());
			
			for(int j=0;j<s[i].length();j++)
				arr1.get(i).add(s[i].charAt(j)-48);
		}
		
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int number=0,dir=0;    // 1: 시계방향 / -1 : 반시계방향
		for(int i=0;i<test;i++)
		{
			st= new StringTokenizer(br.readLine()); 
			number =Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			
			
			if(number != 1)   //1번 톱니바퀴 아니면 왼쪽
				dir_left(number-1, dir);
			
			if(number != 4)    //4번 톱니바퀴 아니면 오른쪽
				dir_right(number+1,dir);
			
			rotate(number,dir);
		}
		
		int sum=0;
		
		if(arr1.get(1).get(0) ==1)
			sum +=1;
		if(arr1.get(2).get(0) ==1)
			sum +=2;
		if(arr1.get(3).get(0) ==1)
			sum +=4;
		if(arr1.get(4).get(0) ==1)
			sum +=8;
		
		System.out.println(sum);
	}
}
