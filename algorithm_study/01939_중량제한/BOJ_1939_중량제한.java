import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,S,E;
	static ArrayList<Node>[] arr1;
	static Queue<Node> q1 = new LinkedList<>();

	static class Node{
		int s_val;
		int e_val;
		int edge;
		
		public Node(int s_val,int e_val,int edge) {
			this.s_val = s_val;
			this.e_val = e_val;
			this.edge = edge;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr1 = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			arr1[i] = new ArrayList<Node>();
		}
		
		int A=0,B=0,C=0;
		int start=0,end=0,mid=0,max=-1;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr1[A].add(new Node(A,B,C));
			arr1[B].add(new Node(B,A,C));
			if(max < C) {
				max = C;
			}
			
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		end = max;
		
		
		while(start<=end) {
			mid = (start+end)/2;
			
			if(isCheck(mid)) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		
		System.out.println(start-1);
		
	}
	
	static boolean isCheck(int n) {
		q1.clear();
		boolean[] check = new boolean[N+1];
		check[S] = true;
		Node e1,e2;
		int size = arr1[S].size();
		
		for(int i=0; i<size; i++) {
			e1 = arr1[S].get(i);
			
			if(e1.edge < n) {
				continue;
			}
			check[e1.e_val] = true;
			q1.offer(e1);
		}
		
		
		while(!q1.isEmpty()) {
			
			e1 = q1.poll();
			size = arr1[e1.e_val].size();
			
			for(int i=0; i<size; i++) {
				e2 = arr1[e1.e_val].get(i);
				
				if(e2.edge < n || check[e2.e_val] == true) {
					continue;
				}
				
				check[e2.e_val] = true;
				q1.offer(e2);
			}
			
			
			if(check[E] == true) {
				return true;
			}
		}
		
		return false;
	}

}
