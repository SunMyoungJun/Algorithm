import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
	static BitSet bs1;
	static BitSet bs2;
	static int count=0;
	static int[] arr1;
	static ArrayList<Integer> A_arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		while(test-- !=0)
		{
			int N = Integer.parseInt(br.readLine());
			bs1 = new BitSet(N+1);
			bs2 = new BitSet(N+1);
			A_arr1 = new ArrayList<Integer>();
			arr1 = new int[N+1];  //1번 ~ N번
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=1;i<N+1;i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
				if(i == arr1[i])
				{
					bs1.set(i);
					count++;
				}		
			}
			for(int i=1;i<N+1;i++){
				
				if(bs1.get(i) ==true)
					continue;
				
				arr1_func(1,arr1[i]);
				bs2.clear();
				A_arr1.clear();
			}
			System.out.println(count);
			count=0;
			bs1.clear();
		}
		
	}
	
	static void arr1_func(int start,int end) {
		
		A_arr1.add(start);
		bs2.set(start);
		if(bs1.get(end) == true)
			return;
		
		if(bs2.get(end) == true)
		{
			for(int i=0;i<A_arr1.size();i++)
			{
				if(A_arr1.get(i) == end)
				{
					for(int j=i;j<A_arr1.size();j++)
					{
						bs1.set(A_arr1.get(i));
					}
				}
			}
			count++;
		}
		
		else
			arr1_func(end,arr1[end]);
	}
}