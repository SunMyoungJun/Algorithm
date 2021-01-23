import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main{

	static class Node {
		int sval;
		int eval;
		int edge;
		
		public Node() {}
		
		public Node(int sval,int eval,int edge)
		{
			this.sval = sval;
			this.eval = eval;
			this.edge = edge;
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<ArrayList<Node>> arr1 = new ArrayList<ArrayList<Node>>();
		int input_V = Integer.parseInt(st.nextToken());
		int input_E = Integer.parseInt(st.nextToken());
		int start_V = Integer.parseInt(br.readLine());
		int s_V=0;
		int e_V=0;
		int edge=0;
		int[] arr2 = new int[input_V+1];
		
		for(int i=1;i<arr2.length;i++)
			arr2[i] = Integer.MAX_VALUE;
		for(int i=0; i<input_V+1; i++)
			arr1.add(new ArrayList<Node>());        //정점갯수만큼 생성
		
		for(int i=1;i<input_E+1;i++)
		{
			st = new StringTokenizer(br.readLine());
			s_V = Integer.parseInt(st.nextToken());
			e_V = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			arr1.get(s_V).add(new Node(s_V,e_V,edge));
			
		}
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				
				return (o1.edge > o2.edge) ? 1:-1;
			};
		});

		for(Node e : arr1.get(start_V))
			pq.offer(e);
		
		while(pq.isEmpty() != true)
		{
			Node n = pq.poll();
			
			if(arr2[n.eval]> n.edge)
			{
				arr2[n.eval] = n.edge;
				for(Node a :arr1.get(n.eval))
				{
					Node n2 = new Node(a.sval,a.eval,a.edge + n.edge);
					pq.offer(n2);
				}
			}
		}
		
		for(int i=1;i<arr2.length;i++)
		{
			if(i == start_V)
				System.out.println("0");
			else if(arr2[i] ==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(arr2[i]);
		}
			
		
		
		
	}

}
