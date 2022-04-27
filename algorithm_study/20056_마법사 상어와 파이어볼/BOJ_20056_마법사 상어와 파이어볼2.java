import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static Queue<int[]> q1 = new LinkedList<>();
	static Queue<Node> q2 = new LinkedList<>();
	static ArrayList<Node>[][] arr1;
	static class Node {
		int r;
		int c;
		int m;
		int s;
		int d;
		public Node(int r,int c,int m,int s,int d) {
			this.r=r;
			this.c=c;
			this.m=m;
			this.s=s;
			this.d=d;
		}
	}
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr1 = new ArrayList[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr1[i][j] = new ArrayList<Node>();
			}
		}
		
		int r=0,c=0,m=0,s=0,d=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			arr1[r-1][c-1].add(new Node(r-1,c-1,m,s,d));
			q1.offer(new int[] {r-1,c-1});
		}
		while(K-- !=0) { 
			move();
			merge();
		}
		
		int rsize =0;
		int result=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				rsize = arr1[i][j].size();
				if(rsize >0) {
					for(int k=0;k<rsize; k++) {
						result+=arr1[i][j].get(k).m;
					}
				}
			}
		}
		System.out.println(result);
	}
	
	static void move() {
		int size = q1.size();
		int msize=0,tx=0,ty=0;
		Node e1;
		int[] p1;
		
		for(int i=0; i<size; i++) {
			p1 = q1.poll();
			msize = arr1[p1[0]][p1[1]].size();
			
			for(int j=0; j<msize; j++) {
				e1 = arr1[p1[0]][p1[1]].get(j); // m,s,d를 가짐
				tx = p1[0] + (dx[e1.d]*e1.s)%N;
				ty = p1[1] + (dy[e1.d]*e1.s)%N;
				tx = (tx <0) ? (N+tx) : (tx>=N) ? (tx%N) : tx;
				ty = (ty <0) ? (N+ty) : (ty>=N) ? (ty%N) : ty;
				q2.offer(new Node(tx,ty,e1.m,e1.s,e1.d));
			}
			arr1[p1[0]][p1[1]].clear();
		}
		q1.clear();
	}
	static void merge() {
		boolean[][] check = new boolean[N][N];
		int size2=q2.size();
		boolean flag1=false,flag2=false;
		int size3=0,mm=0,ss=0;
		
		int[] p1;
		Node e1;
		for(int i=0; i<size2; i++) {
			e1 = q2.poll();
			arr1[e1.r][e1.c].add(e1);
			q1.offer(new int[] {e1.r,e1.c});
		}
		size2=q1.size();
		for(int i=0; i<size2; i++) {
			p1 = q1.poll();
			if(check[p1[0]][p1[1]]) {
				continue;
			}
			mm=0; ss=0;
			size3 = arr1[p1[0]][p1[1]].size();
			check[p1[0]][p1[1]] = true;
			if(size3 ==1) {
				q1.offer(p1);
			}
			else if(size3 >1) {
				flag1=false; flag2=false;
				for(int j=0; j<size3;j++) {
					e1 = arr1[p1[0]][p1[1]].get(j);
					mm += e1.m;
					ss += e1.s;
					if(e1.d %2==0) {
						flag1 = true;
					}
					else {
						flag2 = true;
					}
				}
				arr1[p1[0]][p1[1]].clear();
				mm = mm/5;
				if(mm ==0) {
					continue;
				}
				
				ss = ss/size3;
				q1.offer(p1);
				if((flag1 && !flag2) ||(!flag1 && flag2)) {
					arr1[p1[0]][p1[1]].add(new Node(p1[0],p1[1],mm,ss,0));
					arr1[p1[0]][p1[1]].add(new Node(p1[0],p1[1],mm,ss,2));
					arr1[p1[0]][p1[1]].add(new Node(p1[0],p1[1],mm,ss,4));
					arr1[p1[0]][p1[1]].add(new Node(p1[0],p1[1],mm,ss,6));
				}
				else {
					arr1[p1[0]][p1[1]].add(new Node(p1[0],p1[1],mm,ss,1));
					arr1[p1[0]][p1[1]].add(new Node(p1[0],p1[1],mm,ss,3));
					arr1[p1[0]][p1[1]].add(new Node(p1[0],p1[1],mm,ss,5));
					arr1[p1[0]][p1[1]].add(new Node(p1[0],p1[1],mm,ss,7));
				}
			}
		}
	}
}