import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<int[]> arr1 = new ArrayList<>();
	static int end,K,D,start=0;
	static long cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		end = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int left=0,right=0,dis=0,mid=0,size=0;
		for(int i=0; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken());
			right = Integer.parseInt(st.nextToken());
			dis = Integer.parseInt(st.nextToken());
			arr1.add(new int[] {left,right,dis});
		}
		
		size = arr1.size();
		int[] p1;
		int tend=0;
		
		int result = search();
		System.out.println(result);
		
	}
	
	static int search() {
		int result=0;
		while(start<=end) {
			cnt=0;
			int mid = (start+end)/2;
			int[] p1;
			int size=arr1.size(),tend=0;
			
			for(int i=0; i<size; i++) {
				p1 = arr1.get(i);
				
				if(p1[0] > mid) {
					continue;
				}
				
				tend = (p1[1] > mid) ? mid : p1[1];
				cnt += (tend - p1[0]) / p1[2] +1;
			}
			
			if(cnt < D) {
				start = mid+1;
			}
			else {
				end = mid-1;
				result = mid;
			}
		}
		return result;
	}
}