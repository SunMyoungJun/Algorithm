import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F;
	static int[][] val;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int test = Integer.parseInt(br.readLine());
		int idx=0,n1=0,n2=0;
		StringBuilder sb = new StringBuilder();
		while(test-- !=0) {
			Queue<int[]> q1 = new LinkedList<>();
			idx=0; n1=0; n2=0;
			F = Integer.parseInt(br.readLine());
			HashMap<String,Integer> map = new HashMap<>();
			val = new int[F*2+1][2];
			while(F-- !=0) {
				st = new StringTokenizer(br.readLine());
				String s1 = st.nextToken();			
				String s2 = st.nextToken();			
				if(map.get(s1) == null) {
					map.put(s1, idx++);
					val[idx-1][0] = idx-1;
					val[idx-1][1] =1;
				}
				if(map.get(s2) == null) {
					map.put(s2, idx++);
					val[idx-1][0] = idx-1;
					val[idx-1][1] =1;
				}
				n1 = map.get(s1);
				n2 = map.get(s2);
				union(n1,n2);
				sb.append(val[n1][1]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static int[] findSet(int num) {
		if(val[num][0] == num) 
			return val[num];
		return val[num] = findSet(val[num][0]);
	}

	static void union(int n1, int n2) {
		int[] num1 = findSet(n1);
		int[] num2 = findSet(n2);
		if(num1[0] == num2[0]) 
			return;
		val[num1[0]][1] += num2[1];
		val[num2[0]][1] = val[num1[0]][1];
		val[num1[0]][0] = num2[0];
	}
}