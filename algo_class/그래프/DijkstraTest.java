import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int start = 0;  //출발점
		int end = V-1;  //도착점
		
		int[][] adjMatrix = new int[V][V]; // 인접행렬
		
		StringTokenizer st= null;
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<V;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
	
		Arrays.fill(distance, Integer.MAX_VALUE);  //거리 큰값으로 초기값 줌.
		distance[start] = 0;  //출발지점은 0
		
		
		for(int i=0; i<V; i++) {
			int min = Integer.MAX_VALUE;
			int current =0; // min 최소 비용에 해당하는 정점 번호
			// step1.  : 처리하지 않은 정점 중에 출발지에서 가장 가까운 정점 선택
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > distance[j]) { //방문하지않았으면서 자기로 오는 거리중 최소값.
					min = distance[j];
					current = j;  //min값 일때의 정점번호
				}
			}
			
			visited[current] = true;
			if(current == end)  //답으로 알고싶은 end지점의 정점일때 탐색 종료.
				break;
			// step2. 선택된 current를 경유지로 하여 아직 처리하지 않은 다른 정점으로의 최소 비용 따져본다.
			
			for(int j=0; j< V; j++) {
				if(!visited[j] && adjMatrix[current][j] !=0 && distance[j] > min + adjMatrix[current][j]) {
					distance[j] = min + adjMatrix[current][j];
				}
			}
			
			
			
			
		}
		
		
		
		System.out.println(distance[end]);
		
		
		
		
		
		
	}

}
