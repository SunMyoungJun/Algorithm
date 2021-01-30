import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main{
	static boolean check[];  //메인문에서 확인할 떄 (내가 여기 사람을 이미 판단했는지)
	static boolean check2[];  //팀을 이뤘는지 여부
	static ArrayList<Integer> t_arr1 = new ArrayList<>();  
	static int[] arr1;
	static BitSet bs;        //재귀 돌때 고리 구조 만들어지는지 여부
	
	static public void arr1_func(int start,int end) {
		
		
		
		
		check[start] = true;
		t_arr1.add(start);
		bs.set(start);
		
		if(start == end)
			check2[start] =true;
		
		else if(bs.get(end) == false && check[end] ==false)
			arr1_func(end,arr1[end]);
		
		else if(bs.get(end) == true)
		{
			for(int i=0;i<t_arr1.size();i++)
			{
				if(t_arr1.get(i) == end)
				{
					for(int j=i; j<t_arr1.size();j++)
						check2[t_arr1.get(j)] = true;
					
					break;
				}
					
			}
		}
	
		else if(check[end] == true)   //타고 들어갓는데 이미 봤던거였을 떄 (이거안넣어서 시간초과같기도)
			return;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test= Integer.parseInt(br.readLine());
		int person=0;
		bs = new BitSet(person+1);
		
		while(test-- >0)
		{
			int sum=0;
			person = Integer.parseInt(br.readLine());
			arr1 = new int[person+1];  //1부터 저장
			check = new boolean[person+1];
			check2 = new boolean[person+1];
			st = new StringTokenizer(br.readLine());
			
			for(int i=1;i<person+1;i++)
				arr1[i] = Integer.parseInt(st.nextToken());
			
			for(int i=1;i<person+1;i++)
			{
				if(check[i] ==true || check[arr1[i]] ==true)  //내가 이미 방문했거나, 내가 갈 애가 방문했으면 안봄.
					continue;
				arr1_func(i,arr1[i]);
				bs.clear();
				t_arr1.clear();
			}
			for(int i=1;i<check2.length;i++)
			{
				if(check2[i] == false)
					sum ++;
			}
			System.out.println(sum);
		}
		
	}
}
