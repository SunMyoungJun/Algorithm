import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int cnt=0,start=0,end=0;
		int[][] arr1 = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr1[i][0] = Integer.parseInt(st.nextToken());
			arr1[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return (o1[0] > o2[0]) ? 1: -1;
				return (o1[1] > o2[1]) ? 1: -1;
			}
		});
		
		for(int i=0; i<N; i++) {
			if(arr1[i][0] >= start) {
				cnt++;
				start = arr1[i][1];
			}
		}
		System.out.println(cnt);
	}
}