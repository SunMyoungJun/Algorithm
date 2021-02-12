import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] switch1;
	static int switchnum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 switchnum = Integer.parseInt(br.readLine());
		switch1 = new int[switchnum+1];  //1번 인덱스부터 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<switchnum+1;i++)
			switch1[i] = Integer.parseInt(st.nextToken());
		
		int personnum = Integer.parseInt(br.readLine());
		
		int person=0,num=0;
		while(personnum-- !=0)
		{
			st = new StringTokenizer(br.readLine());
			person = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			if(person == 1)   //남자일때
				change1(num);
			else
			{
				if(num-1 >0 && num+1 <switchnum+1 && (switch1[num-1] == switch1[num+1]))
					change2(num-1,num+1);
				switch1[num] = (switch1[num] ==0) ? 1 : 0;
				
			}		
		}
		for(int i=1;i<switch1.length;i++)
		{
			
			System.out.print(switch1[i]+" ");
			if(i %20 ==0)
				System.out.println();
		}
			
	}
	
	static void change1(int num) {   //남자일 때 스위치변화
		for(int i=1;i<switch1.length;i++){
			if(i % num ==0)
				switch1[i] = (switch1[i] ==0) ? 1 : 0;		
		}
	}
	
	static void change2(int num1,int num2) {   //여자일떄 스위치변화
		if(num1 <=0 || num2 >=switchnum+1 || (switch1[num1] != switch1[num2]))
			return;
	
		switch1[num1] = (switch1[num1] ==0) ? 1 : 0;
		switch1[num2] = (switch1[num2] ==0) ? 1 : 0;
		change2(num1-1,num2+1);
	}
}