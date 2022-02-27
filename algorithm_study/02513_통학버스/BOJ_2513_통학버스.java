import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int cnt;
		public Node(int x,int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Node> pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (o1.x > o2.x) ? 1: -1;
			}
		});
		PriorityQueue<Node> pq2 = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (o1.x < o2.x) ? 1: -1;
			}
		});
		
		int N = Integer.parseInt(st.nextToken()); // 아파트 단지 수
		int K = Integer.parseInt(st.nextToken()); // 통학버스 정원
		int S = Integer.parseInt(st.nextToken()); // 학교의 위치
		int X=0,people=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			people = Integer.parseInt(st.nextToken());
			
			if(X >S) {
				pq2.offer(new Node(X,people));
			}
			else {
				pq1.offer(new Node(X,people));
			}
		}
		
		int sum=0,count=0,distance=0;
		boolean flag=false;
		while(!pq1.isEmpty()) {
			count = K;
			flag = false;
			while(!pq1.isEmpty()) {
				Node e1 = pq1.poll();
				if(!flag) {
					flag = true;
					distance = S - e1.x; // 거리 1번
				}
				if(e1.cnt < count) {
					count-=e1.cnt;
				}
				else if(e1.cnt == count) {
					break;
				}
				else {
					pq1.offer(new Node(e1.x,e1.cnt-count));
					break;
				}
			}
			sum += (distance)*2;
		}
		
		while(!pq2.isEmpty()) {
			count = K;
			flag = false;
			while(!pq2.isEmpty()) {
				Node e1 = pq2.poll();
				if(!flag) {
					flag = true;
					distance = e1.x - S; // 거리 1번
				}
				if(e1.cnt < count) {
					count-=e1.cnt;
				}
				else if(e1.cnt == count) {
					break;
				}
				else {
					pq2.offer(new Node(e1.x,e1.cnt-count));
					break;
				}
			}
			sum += (distance)*2;
		}
		System.out.println(sum);
	}
}