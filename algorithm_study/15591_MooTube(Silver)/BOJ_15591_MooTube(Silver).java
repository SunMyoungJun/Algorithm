import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,Q;
	static List<Node>[] list;
	static Queue<Node> q1 = new LinkedList<>();
	static class Node {
		int end;
		int usado;
		public Node(int end,int usado) {
			this.end = end;
			this.usado = usado;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		list = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		int n1=0,n2=0,value=0,k=0,v=0,sum=0;
		for(int i=0; i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			value = Integer.parseInt(st.nextToken());
			list[n1].add(new Node(n2,value));
			list[n2].add(new Node(n1,value));
		}
		
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			int num = bfs(k,v);
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static int bfs(int k,int v) {
		int v1=0;
		boolean[] check = new boolean[N+1];
		int num=0,sum=0,size=0;
		check[v] = true;
		q1.clear();
		Node e1,e2;
		int len = list[v].size();
		
		
		for(int i=0; i<len; i++) {
			e1 = list[v].get(i);
			if(e1.usado >=k) {
				q1.offer(e1);
				check[e1.end] = true;
			}
		}
		
		
		while(!q1.isEmpty()) {
			
			size = q1.size();
			sum += size;
			for(int t=0; t<size; t++) {
				e1 = q1.poll();
				len = list[e1.end].size();
				for(int i=0; i<len; i++) {
					e2 = list[e1.end].get(i);
					if(check[e2.end] == false && e2.usado >=k) {
						q1.offer(e2);
						check[e2.end] = true;
					}
				}
			}
		}
		return sum;
	}

}
