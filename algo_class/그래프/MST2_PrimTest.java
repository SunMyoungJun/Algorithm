import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MST2_PrimTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		/*5
		0 5 10 8 7    //입력 예시  - 인접행렬
		5 0 5 3 6 
		10 5 0 1 3 
		8 3 1 0 1 
		7 6 3 1 0*/
		
		int [][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		
		StringTokenizer st = null;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE; //신장 트리에 연결된 정점에서 자신으로의 최소간선 비용
		}
		
		int result = 0;
		minEdge[0] =0; //0을 시작정점으로 처리하기 위해 0 세팅
		
		for(int c=0; c<N; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex =0;
//			신장 트리에 연결되지 않은 정점중 minEdge비용이 최소인 정점
			for(int i=0; i< N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			result += min;
			visited[minVertex] = true;
			
			for(int i=0; i< N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] !=0 && minEdge[i] >adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
			
			System.out.println(result);
			
			
			
		}
		
		
	}

}














