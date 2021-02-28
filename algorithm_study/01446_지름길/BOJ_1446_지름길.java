import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int N,D,MIN=Integer.MAX_VALUE;
	static List<street> str = new ArrayList<street>();
	static class street{
		int start;
		int end;
		int distance;

		public street(int start,int end,int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int temp1=0,temp2=0,temp3=0;
		int temp=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			temp3 = Integer.parseInt(st.nextToken());
			if(temp2 <= D) {
				str.add(new street(temp1,temp2,temp3));
				temp++;
			}
		}
		N = temp;
		Collections.sort(str,( o1, o2)-> o1.start - o2.start);

		dfs(0,0,0);
		System.out.println(MIN);
	}

	static void dfs(int cnt,int end,int distance) {
		if(cnt == N) {
			distance = distance + (D - end);
			MIN = (MIN < distance) ? MIN : distance;
			return;
		}

		street st1 = str.get(cnt);

		if(st1.start >= end) {
			int temp = distance +(st1.start - end);
			dfs(cnt+1,st1.end, temp+st1.distance);
			
		}

		dfs(cnt+1,end,distance);
	}
}