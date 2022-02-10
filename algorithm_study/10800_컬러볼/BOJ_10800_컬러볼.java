
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		ArrayList<int[]> arr1 = new ArrayList<int[]>();
		
		
	
		
		int N = Integer.parseInt(br.readLine());
		int[] sum = new int[200001];
		int[] result = new int[200001];
		int color=0,size=0,sum1=0,sum2=0;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			color = Integer.parseInt(st.nextToken());
			size = Integer.parseInt(st.nextToken());
			
			arr1.add(new int[] {color,size,i});
		}
		
		Collections.sort(arr1,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1,int[] o2) {
				if(o1[1] != o2[1]) {
					return (o1[1] > o2[1]) ? 1: -1;
				}
				else if(o1[0] == o2[0]) {
					return (o1[2] > o2[2]) ? 1: -1;
				}
				return (o1[0] > o2[0]) ? 1: -1;
			}
		});
		
		int realSize = 0,realCnt=0;
		
		int j=0;
		for(int i=0; i<N; i++) {
			int[] p1 = arr1.get(i);
			int[] p2 = arr1.get(j);
			
			
			while(p2[1] < p1[1]) {
				sum1 += p2[1];
				sum[p2[0]] += p2[1];
				p2 = arr1.get(++j);
			}
			
			result[p1[2]] = sum1 - sum[p1[0]];
			
		}
		
		
		for(int i=1; i<N+1; i++) {
			System.out.println(result[i]);
		}
	}

}
