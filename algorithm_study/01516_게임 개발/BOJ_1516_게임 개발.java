import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] val;
	static int[] charge;
	static int[] result;
	static Queue<Integer> q1 = new LinkedList<>();
	static ArrayList<Integer>[] arr1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		val = new int[N+1];
		charge = new int[N+1];
		arr1 = new ArrayList[N+1];
		result = new int[N+1];
		int num=0,size2=0,num2=0;

		for(int i=1; i<N+1; i++) {
			arr1[i] = new ArrayList<Integer>();
		}

		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			charge[i] = Integer.parseInt(st.nextToken());

			while(true) {
				num = Integer.parseInt(st.nextToken());

				if(num == -1) {
					break;
				}
				val[i]++;
				arr1[num].add(i);
			}
		}

		for(int i=1; i<N+1; i++) {
			if(val[i] ==0) {
				q1.offer(i);
			}
		}
		while(!q1.isEmpty()) {
			int max = 0;
			num = q1.poll();

			size2 = arr1[num].size();

			for(int j=0; j<size2; j++) {
				num2 = arr1[num].get(j);
				val[num2]--;
				
				result[num2] = Math.max(result[num2], result[num] + charge[num]);

				if(val[num2] ==0) {
					//charge[num2] += charge[num];
					q1.offer(num2);
				}
			}
		}
		for(int i=1; i<N+1; i++) {
			sb.append(result[i]+charge[i]).append("\n");
		}

		System.out.println(sb.toString());
	}
}