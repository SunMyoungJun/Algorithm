import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st1 = br.readLine();
		String st2 = br.readLine();
		br.close();
		int[][] arr1 = new int[st1.length()+1][st2.length()+1]; //입력 문자들 만큼 배열 크기 선언.
		Integer max=0;
		int icount=1;
		int iicount=0;
		for(int i=1;i<st1.length()+1;i++)
		{
			for(int j=1;j<st2.length()+1; j++)
			{
				if(st1.charAt(i-1) == st2.charAt(j-1))
					arr1[i][j] = arr1[i-1][j-1] +1;
				else
					{
						if(arr1[i-1][j] > arr1[i][j-1] )
							arr1[i][j] = arr1[i-1][j];
						else
							arr1[i][j] = arr1[i][j-1];
					}
				
					
			}
		}
		
		System.out.println(arr1[st1.length()][st2.length()]);
	}

}
