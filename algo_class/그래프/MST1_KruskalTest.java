import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST1_KruskalTest {
	
	static class Edge implements Comparable<Edge> {
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (this.weight > o.weight) ? 1: -1;
		}
		
		
	}
	
	
	
	static int V,E;
	static int parents[];
	static Edge[] edgeList;
	
	
	static void make() { // 크기가 1인 단위집합을 만든다(처음 원소들은 모두 자기 자신이 대장임).
		for(int i=0;i<V;i++) { 
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {  //리턴값 있는 이유 : 찾은 대장 값을 리턴하면서 전부 대장 값으로 대입하면서 경로 압축 됨.
		if(parents[a] ==a)  //내가 대장일 때 
			return a;
		
//		return parents[a] = findSet(parents[a]);   //path compression 한거  // 밑에 세줄 이거 한줄로
		int temp = findSet(parents[a]);
		parents[a] = temp;
		return temp;
	}
	
	
	static boolean union(int a,int b) {  //a,b가 합쳐지면 true, 대장을 찾았더니 같은 집합이엿다면 false
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) { //두 집합이 같은 집합일 때
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;       // boolean타입으로 true냐 false판단하는 이유는 나중에 응용문제에서 사용될 수있어서 그럼.
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];
		edgeList = new Edge[E];
		
		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from,to,weight);
		}
		
//		1.간선리스트 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);
		
		make();
		int result =0;  //가중치 합
		int count =0; // 선택한 간선 수
		
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) { //싸이클이 발생하지 않았다면
				result += edge.weight;
				count++;
				
				if(count == V-1) {  //최소비용신장트리 완성됐으면 더이상 간선선택안함.
					break;
				}
			}
		}
		System.out.println(result);
	}
}