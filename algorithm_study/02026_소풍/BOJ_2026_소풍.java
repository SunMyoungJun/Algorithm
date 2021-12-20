import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
	static int K,N,F;
	static boolean flag=false;
	static boolean[] check;
	static boolean[][] relation;
	static int[] result;
	static ArrayList<Integer>[] arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		arr1 = new ArrayList[N+1];
		check = new boolean[N+1];
		relation = new boolean[N+1][N+1];
		result = new int[K];
		for(int i=1; i<N+1; i++) {
			arr1[i] = new ArrayList<Integer>();
		}
		int n1=0,n2=0;
		for(int i=0; i<F; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
		
			
			arr1[n1].add(n2);
			arr1[n2].add(n1);
		
			relation[n1][n2] = true;
			relation[n2][n1] = true;
		
		}
		
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(arr1[i],new Comparator<Integer>() {
				
				@Override
				public int compare(Integer o1, Integer o2) {
					return (o1 > o2) ? 1:-1;
				}
			});
 		}
		
		for(int i=1; i<N+1; i++) {
			result[0] = i;
			check[i] = true;
			dfs(1,i);
			check[i] = false;
			if(flag)
				break;
		}
		
		if(flag) {
			for(int i=0; i<K; i++) {
				System.out.println(result[i]);
			}
		}
		else {
			System.out.println("-1");
		}
	
	}
	
	static void dfs(int cnt,int num) {
		if(cnt == K) {
			flag = true;
			return;
		}
		
		
		int size = arr1[num].size();
		int n = 0;
		for(int i=0; i<size; i++) {
			boolean flag2=true;
			n = arr1[num].get(i);
			if(check[n] == true) {
				continue;
			}
			
			if(num > n) {
				continue;
			}
			
			for(int j=0; j<cnt;j++) {
				if(!relation[n][result[j]]) {
					flag2 = false;
					break;
				}
			}
			
			if(!flag2) {
				continue;
			}
			
			check[n] = true;
			result[cnt] = n;
			dfs(cnt+1,n);
			check[n] = false;
			
			if(flag) {
				return;
			}
		}
		
		
	}
}
