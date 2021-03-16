import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ADJListTest {
	static int N;
	
	
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
		public Node(int vertex) {
			this.vertex = vertex;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
	}
	
	static Node[] adjlist;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 정점수
		int C = Integer.parseInt(br.readLine()); // 간선수

		adjlist = new Node[N];
		StringTokenizer st= null;
		for(int i=0; i<C; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
														//무향 그래프
														//연결리스트의 첫부분에 계속 넣음.
			adjlist[from] = new Node(to,adjlist[from]); //from노드가 가르키는 주소를 넣어서 생성.
			adjlist[to] = new Node(from,adjlist[to]);
		
		}
		bfs();
	}
	
	
/*	
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6*/
	
	
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		int start =0;
		queue.offer(0);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+65));
			
			for(Node temp = adjlist[current]; temp != null; temp = temp.next) {
					
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
			
			
		}
		
		
	}
	
	
	
	
	
	
}
