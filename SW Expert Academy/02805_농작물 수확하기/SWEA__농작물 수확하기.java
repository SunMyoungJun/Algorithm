import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	static int[][] arr1;
	static boolean[][] check;
	static int sum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		int test = Integer.parseInt(br.readLine());

		for(int t=1;t<test+1;t++){
			int size = Integer.parseInt(br.readLine());
			arr1 = new int[size][size];
			check = new boolean[size][size];
			for(int i=0;i<size;i++)
			{
				st = br.readLine();
				for(int j=0;j<size;j++)
					arr1[i][j] = st.charAt(j) -48;
			}

			int count=0,count2=0;
			int center=size/2;
			for(int j=0;j<size;j++)
			{
				if(j <= size/2)
				{
					sum += arr1[center][count];
					for(int i=1; i<count+1;i++)
					{
						sum += arr1[center+i][count];
						sum += arr1[center-i][count];
					}
					count++;
					
					if(j ==size/2) count2 = count -2;

				}
				else
				{
					sum += arr1[center][size-1-count2];
					for(int i=1;i<count2+1;i++) 
					{
						sum +=arr1[center+i][size-1-count2];
						sum +=arr1[center-i][size-1-count2];
					}				
					count2--;
				}	
			}
			
			System.out.println("#"+t+" "+sum);
			sum=0;
			
		}
	}
}
