import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class Main {
	static int N,M;
	static int[] result,num;
	static boolean[] check;
	static TreeSet<String> treeSet = new TreeSet<>();
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[N];
		num = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		dfs(0,0);
		System.out.println(sb2.toString());
	}
	static void dfs(int cnt,int idx) {
		if(cnt == M) {
			sb.setLength(0);
			for(int i=0; i<M; i++) 
				sb.append(result[i]).append(" ");
			if(!treeSet.contains(sb.toString())) 
				sb2.append(sb.toString()).append("\n");
			treeSet.add(sb.toString());
			return;
		}

		for(int i=idx; i<N; i++) {
			if(check[i] == true)
				continue;
			check[i] = true;
			result[cnt] = num[i];
			dfs(cnt+1,i+1);
			check[i] = false;
		}
	}
}