import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,san,a,b;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			san = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(san == 0) { //합집합
				union(a,b);
			}
			else { // 둘이 같은 집합인지
				a = findSet(a);
				b = findSet(b);
				if(a==b) {
					sb.append("YES\n");
				}
				else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb.toString());
		
	}
	static int findSet(int num) {
		if(parent[num] == num) {
			return num;
		}
		return parent[num] = findSet(parent[num]);
	}
	
	static void union(int num1, int num2) {
		num1 = findSet(num1);
		num2 = findSet(num2);
		
		if(num1 == num2) {
			return;
		}
		parent[num1] = num2;
		return;
	}
}