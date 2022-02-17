import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,ai,pi;
	static char who;
	static ArrayList<int[]>[] arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr1 = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			arr1[i] = new ArrayList<int[]>();
		}
		
		for(int i=2; i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			who = st.nextToken().charAt(0);
			ai = Integer.parseInt(st.nextToken());
			pi = Integer.parseInt(st.nextToken());
			
			if(who=='S') {
				arr1[pi].add(new int[] {i,ai,0}); // 자식 노드, 동물 수 , 어떤 동물(0=양)
			}
			else {
				arr1[pi].add(new int[] {i,ai,1}); // 자식 노드, 동물 수 , 어떤 동물(01=늑대)
			}
		}
		long result = dfs(1,0,0);
		System.out.println(result);
	}
	
	static long dfs(int idx,int share, int wolf) {
		long num=0,sum=0;
		boolean flag = false;
		int size = arr1[idx].size();
		int[] p1;
		for(int i=0; i<size; i++) {
			p1 = arr1[idx].get(i);
			if(p1[2] == 0) {
				num = dfs(p1[0],p1[1],0);
			}
			else {
				num = dfs(p1[0],0,p1[1]);
			}
			if(num >0) {
				sum += num;
			}
		}
		return share-wolf+sum;
	}
}