import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
static int personnum;
static int[][] arr1;
static boolean[] check;
static int min=Integer.MAX_VALUE;
	
	public static void arr1_func(int x, int count) {
		if(count != personnum /2)
		{
			for(int i=x;i<personnum+1;i++)
			{
				if(check[i] !=true)
				{
					check[i] = true;
					arr1_func(i,count+1);
					check[i] = false;	
				}
				
			}
		}
		else
			arr1_func2();
	}

	public static void arr1_func2() {
		int a=0;
		int b=0;
		for(int i=1;i<personnum+1;i++)
		{
			for(int j=i+1;j<personnum+1;j++)
			{
				if(check[i] ==true && check[j] == true && i!=j)
					a  = a + arr1[i][j] + arr1[j][i];
				else if(check[i] ==false && check[j] == false && i!=j)
					b = b + arr1[i][j] +arr1[j][i];
			}
		}
			
		
		
		int temp = (a-b >0) ? a-b : b-a;
		min = (min <temp) ? min : temp;
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		personnum = Integer.parseInt(br.readLine());
		arr1 = new int[personnum+1][personnum+1];
		check = new boolean[personnum+1];
		int num1 =0;
		for(int i=1;i<personnum+1;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<personnum+1;j++)
			{
				num1 = Integer.parseInt(st.nextToken());
				arr1[i][j] = num1;
			}
		}
		
		num1 =0;
		
		arr1_func(1,0);
		System.out.println(min);
	}
	
	
	

}
