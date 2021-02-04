import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		StringTokenizer st=null;

		for(int t =1 ;t<11;t++) {
			int test = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			int num=0,count=1;
			while(true) {
				num = q.poll();
				num = num - count;
		
				if(num <=0)
				{
					num=0;
					q.offer(num);
					break;
				}
				q.offer(num);
				count++;
				if(count == 6)
					count=1;
			}
			
			sb.append("#"+test+" ");
			while(!q.isEmpty())
				sb.append(q.poll()+" ");
			sb.append("\n");
			q.clear();
		}
		
		System.out.println(sb.toString());
		
	}

}
