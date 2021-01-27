import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
	static boolean[] check;
	static ArrayList<stick> arr1;
	static int max,count;
	static class stick{
		int x;
		int y;
		
		public stick(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static int arr1_func(int start,int height) {
		 max=Integer.MIN_VALUE;
		for(int i=start+1;i<arr1.size();i++)
		{
			if(arr1.get(i).y >= height)  //찾으면
			{
				return i;
			}
			count++;
			max = (max < arr1.get(i).y) ? arr1.get(i).y : max;
		}
		
		return 0;  //임시
	}	
	
	public static void main(String[] args) throws IOException {
		arr1 = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		int x=0,y=0;
		check = new boolean[test];
		for(int i=0;i<test;i++)
		{
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr1.add(new stick(x,y));
		}
		
		Collections.sort(arr1, new Comparator<stick>() {
			@Override
			public int compare(stick s1,stick s2) {
				
				return (s1.x > s2.x) ? 1: -1; 
			}
			
		});
		
		
		int dy=0;
		int a =0;
		int sum =0;
		for(int i=0;i<test;i++)
		{
			 count =0;
			if(check[i] == false)  //방문하지 않앗으면
			{
				check[i] =true;
				dy = arr1.get(i).y;
				a = arr1_func(i,dy);
				
				if(a !=0)   //나보다 큰 높이를 찾앗을 떄 
				{
					sum += ( arr1.get(a).x - arr1.get(i).x ) * arr1.get(i).y;  //넓이 계산
					for(int j=1; j<count+1;j++)
					{
						check[i+j] = true;
					}
				}
				else //나보다 높은게 없을 때는 a=0이나옴
				{
					sum += arr1.get(i).y;
					check[i] = true;
					int tempx = arr1.get(i).x+1;
					for(int j=i+1; j<arr1.size();j++)
					{
						if(arr1.get(j).y == max)
						{
							sum+=max*(arr1.get(j).x - tempx);
							break;
						}
						check[j] = true;
					}			
				}
				
			}
		}

		
		System.out.println(sum);
		
	}

}



