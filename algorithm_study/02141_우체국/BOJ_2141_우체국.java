import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		long total=0,sum=0;
		long[][] arr1 = new long[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr1[i][0] = Long.parseLong(st.nextToken());
			arr1[i][1] = Long.parseLong(st.nextToken());
			total +=arr1[i][1];
		}
		
		Arrays.sort(arr1,new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return (o1[0] > o2[0]) ? 1: -1;
			}
		});
		
		total = (total+1)/2;
		
		
		
		
		
		for(int i=0; i<N; i++) {
			sum += arr1[i][1];
			if(sum >=total) {
				System.out.println(arr1[i][0]);
				return;
			}
			
		}
		
		

	}

}
