import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,count;
	static int cnt,singer;
	static int[] val;
	static ArrayList<Integer>[] arr1;
	static Queue<Integer> q1 = new LinkedList<>();	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr1 = new ArrayList[N+1];
		for(int i=1; i<N+1; i++)
			arr1[i] = new ArrayList<>();
		
        val = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			int[] line = new int[cnt];
			
			for(int j=0; j<cnt; j++) {
				singer = Integer.parseInt(st.nextToken());
				line[j] = singer;
				val[singer] += j;
			}
			
			for(int a=0; a<cnt; a++)
				for(int b=a+1; b<cnt; b++)
					arr1[line[a]].add(line[b]);
		}
		
		for(int i=1; i<N+1; i++) {
			if(val[i] == 0) {
				q1.offer(i);
				count++;
				sb.append(i).append("\n");
			}
		}
		while(!q1.isEmpty()) {
			int n = q1.poll();
			int size = arr1[n].size();
			for(int i=0; i<size; i++) {
				int idx= arr1[n].get(i);
				val[idx]--;
				if(val[idx] == 0) {
					q1.offer(idx);
					count++;
					sb.append(idx).append("\n");
				}
			}
		}
		if(count == N)
			System.out.println(sb.toString());
		else
			System.out.println("0");
	}
}