import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N,M,Q;
	static long sum;
	static int[][] val;
	static boolean[] check;
	static Stack<int[]> sk = new Stack<>();
	static ArrayList<int[]> arr1 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		int n1=0,n2=0;
		val = new int[N+1][2];
		
		for(int i=1; i<N+1; i++) {
			val[i][0] = i;
			val[i][1] =1;
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			arr1.add(new int[] {n1,n2});

		}
		check = new boolean[M];
		
		for(int i=0; i<Q; i++) {
			int A = Integer.parseInt(br.readLine());
			sk.push(arr1.get(A-1));
			check[A-1] = true;
		}
		int [] p1;
		for(int i=0; i<M; i++) {
			if(check[i] == false) {
				p1 = arr1.get(i);
				union(p1[0],p1[1]);
			}
		}
		sum=0;
		
		
		while(!sk.isEmpty()) {
			p1 = sk.pop();
			union(p1[0],p1[1]);
		}
		
		System.out.println(sum);
		
		
		
		
	}
	static int[] findSet(int num) {
		if(val[num][0] == num) {
			return val[num];
		}
		return val[num] = findSet(val[num][0]);
		
	}
	static void union(int n1, int n2) {
		int[] num1 = findSet(n1);
		int[] num2 = findSet(n2);
		
		if(num1[0] == num2[0]) {
			return;
		}
		
		sum += (num1[1] * num2[1]);
		
		int temp2 = num2[1];
		val[num1[0]][1] += temp2;
		val[num2[0]][1] = val[num1[0]][1];
		val[num1[0]][0] = num2[0];
		return;
	
	}
}