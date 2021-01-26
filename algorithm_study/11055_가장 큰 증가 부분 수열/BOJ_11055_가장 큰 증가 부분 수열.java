import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int num = Integer.parseInt(br.readLine());
		int[] arr1 = new int[num];
		int[] arr2 = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++)
			arr1[i] = Integer.parseInt(st.nextToken());
			
		
		for(int i=0; i<num; i++)
		{
			arr2[i] = arr1[i];
			for(int j=0; j<i; j++)
			{
				if(arr1[j] < arr1[i] && arr2[j] + arr1[i] > arr2[i])
				{
					arr2[i] = arr2[j]+arr1[i];
				}
				
			}
		}
		
		int max =0;
		for(int i=0;i<arr2.length;i++)
			max = (max < arr2[i]) ? arr2[i] : max ;
		
			
			System.out.println(max);
	}

}
