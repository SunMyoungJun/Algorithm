import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,yo,taxiR,taxiC;
	static int sr1,sc1,er1,ec1,syo;

	static PriorityQueue<Node> pq1;
	static int[][] map;
	static int[][][] person;
	static boolean[][] check1;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class Node {
		int r;
		int c;
		int yoyo;
		
		public Node(int r, int c, int yoyo) {
			this.r = r;
			this.c= c;
			this.yoyo = yoyo;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		yo = Integer.parseInt(st.nextToken());
		person = new int[N+1][N+1][2];
		map = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		taxiR = Integer.parseInt(st.nextToken());
		taxiC = Integer.parseInt(st.nextToken());
		
		
		int sr=0,sc=0,er=0,ec=0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			map[sr][sc] = 2; // 사람 있다.
			
			person[sr][sc][0] = er;
			person[sr][sc][1] = ec;
					
		}

		
		pq1 = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.r == o2.r) {
					return (o1.c > o2.c) ? 1: -1;
				}
				return (o1.r > o2.r) ? 1: -1;
			}
		});
		
		
		syo = yo;
		int cnt=0;
		while(true) {
			sr1=-1; sc1=-1; // 찾아갈 승객 번호
			if(!findPerson()) {
				System.out.println("-1");
				break;
			}
			er1 = person[sr1][sc1][0];
			ec1 = person[sr1][sc1][1];
			
			if(!findEnd()) {
				System.out.println("-1");
				break;
			}
			
			cnt++;
			
			if(cnt == M) {
				System.out.println(syo);
				break;
			}
			
			
			
			
			
		}
	}
	
	
	static boolean findEnd() {
		
		// syo 써야함
		Queue<Node> q1 = new LinkedList<>();
		boolean[][] check2 = new boolean[N+1][N+1];
		q1.offer(new Node(sr1,sc1,0));
		check2[sr1][sc1] = true;
		int tx=0,ty=0;
		while(!q1.isEmpty()) {
			Node e1 = q1.poll();
			
			if(e1.yoyo > syo) {
				return false;
			}
			
			if(e1.r == er1 && e1.c == ec1) {
				taxiR = e1.r;
				taxiC = e1.c;
				syo += e1.yoyo;
				return true;
			}
			
			
			for(int d=0; d<4; d++) {
				tx = e1.r + dx[d];
				ty = e1.c + dy[d];
				
				if(tx<=0 || tx>N || ty<=0 || ty>N || map[tx][ty] == 1 || check2[tx][ty] == true) {
					continue;
				}
				
				check2[tx][ty] = true;
				q1.offer(new Node(tx,ty,e1.yoyo+1));
				
				
				
				
			}
			
			
			
		}
		
		return false;
	}
	
	
	
	
	
	static boolean findPerson() {
		pq1.clear();
		Queue<Node> q1 = new LinkedList<>();
		q1.offer(new Node(taxiR,taxiC,0));
		int size=0,tx=0,ty=0;
		boolean flag = false;
		check1 = new boolean[N+1][N+1];
		check1[taxiR][taxiC] = true;
		while(!q1.isEmpty()) {
			size = q1.size(); 
			
			for(int i=0; i<size; i++) {
				Node e1 = q1.poll();
				
				if(e1.yoyo >syo) {
					return false;
				}
				
				if(map[e1.r][e1.c]== 2) {
					pq1.offer(new Node(e1.r,e1.c,e1.yoyo));
					flag = true;
				}
				for(int d=0; d<4; d++) {
					tx = e1.r + dx[d];
					ty = e1.c + dy[d];
					
					if(tx<=0 || tx>N || ty<=0 || ty>N || map[tx][ty] ==1 || check1[tx][ty] == true) {
						continue;
					}
					check1[tx][ty] = true;
					q1.offer(new Node(tx,ty,e1.yoyo+1));
				}
			}
			if(flag) {
				break;
			}
		}
		
		if(pq1.size() ==0) {
			return false;
		}
		
		while(!pq1.isEmpty()) {
			Node e1 =pq1.poll();
			
			map[e1.r][e1.c]= 3; 
			sr1= e1.r;
			sc1 = e1.c;
			
			syo = syo - e1.yoyo;
			break;
		}
		
		return true;
		
		
		
	}

}
