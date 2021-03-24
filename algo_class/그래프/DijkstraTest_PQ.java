import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*5 0 2 2 5 9 2 0 3 4 8 2 3 0 7 6 5 4 7 0 5 9 8 6 5 0
 */
public class DijkstraTest_PQ {
	static int V;
	static int[][] map;
	private static class Node implements Comparable<Node>{
		int vertex;
		int totalDistance;

		public Node(int vertex, int totalDistance) {
			this.vertex = vertex;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Node o) {
			return this.totalDistance-o.totalDistance;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", distance=" + totalDistance + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int start = 0; // 출발점
		int end = V-1; // 마지막 정점

		map = new int[V][V];

		for(int i = 0 ; i < V; i++) {
			for(int j = 0; j < V; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] D = new int[V]; //정점까지의 최소 비용

		boolean[] v = new boolean[V];
		//        D배열은 최소갑을 구하기 위해서 최대값으로 초기화
		Arrays.fill(D, Integer.MAX_VALUE);
		//        출발지의 위치비용은 0으로 설정
		D[start] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(start,D[start]));

		Node current = null;
		while(!queue.isEmpty()){

			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			current = queue.poll();
			if(v[current.vertex])continue;

			v[current.vertex] = true; // 선택 정점 방문 처리
			if(current.vertex == end) break; // 선택 정점이 도착정점이면 탈출.

			//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(!v[c] && map[current.vertex][c] != 0
						&&  D[c] >current.totalDistance+map[current.vertex][c]){
					D[c] = current.totalDistance+map[current.vertex][c];
					queue.offer(new Node(c,D[c]));

				}
			}
		}
		System.out.println(D[end]);

	}
}

