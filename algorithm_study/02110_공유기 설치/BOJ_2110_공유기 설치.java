import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++)
			arr1[i] = Integer.parseInt(br.readLine());	
		Arrays.sort(arr1);
		
		int start =1;
		int end =arr1[arr1.length-1]-arr1[0];
		
		
		while(start <=end) {
			int mid = (start+end)/2;
			int cnt=1;
			int temp = arr1[0];
			for(int i=1;i<arr1.length;i++)
			{
				if(arr1[i] - temp >mid)
				{
					cnt++;
					temp = arr1[i];
				}
			}
			
			if(cnt >=C)  //간격줄이기
				start = mid+1;
			else  //다 설치못할경우
				end = mid-1;
			
		}
		
		System.out.println(start);
		
	}

}
