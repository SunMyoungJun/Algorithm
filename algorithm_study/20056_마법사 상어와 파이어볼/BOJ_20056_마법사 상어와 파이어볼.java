import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static ArrayList<ArrayList<ArrayList<fire>>> arr1;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static Queue<fire> q1 = new LinkedList<fire>();
	static class fire {
		int r,c,m,s,d;

		public fire(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr1 = new ArrayList<ArrayList<ArrayList<fire>>>();
		for(int i=0;i<N+1;i++) {
			arr1.add(new ArrayList<ArrayList<fire>>());
			for(int j=0;j<N+1;j++) {
				arr1.get(i).add(new ArrayList<fire>());
			}
		}
		
		int r=0,c=0,m=0,s=0,d=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			q1.offer(new fire(r,c,m,s,d));
		}
		
		bfs();
		int sum=0;
		fire ff;
		while(!q1.isEmpty()) {
			ff = q1.poll();
			sum +=ff.m;
		}
		System.out.println(sum);
	}
	
	static void bfs() {
		fire f;
		int r=0,c=0,m=0,s=0,d=0;
		int tx=0,ty=0;
		while(K-- !=0) {
			
			while(!q1.isEmpty()) {
				f = q1.poll();
				r = f.r;
				c = f.c;
				m = f.m;
				s = f.s;
				d = f.d;
				
				for(int i=0;i<s;i++) {
					r = (r+ dx[d])%N;
					c = (c+ dy[d])%N;
			
					if(r==0) {
						r = N;
					}
					if(c==0) {
						c =N;
					}
				}
				tx = r;
				ty = c;
				arr1.get(tx).get(ty).add(new fire(tx,ty,m,s,d));			
			}
			
			int tf =0;
			for(int i=0;i<N+1;i++) {
				for(int j=0;j<N+1;j++) {
					if(arr1.get(i).get(j).size() ==1) {  //같은 칸에 불이 1개일 때
						q1.offer(arr1.get(i).get(j).get(0));
					}
					else if(arr1.get(i).get(j).size() >1){
						firecheck(i,j);
						
					}
				}
			}
			
			for(int i=0;i<N+1;i++) {   //초기화
				for(int j=0;j<N+1;j++) {
					arr1.get(i).get(j).clear();
				}
			}
		}
	}
	
	static void firecheck(int r,int c) {
		int tr=0,tc=0,tm=0,ts=0,td=0;
		int temp = arr1.get(r).get(c).get(0).d;  //첫번째 불의 방향
		boolean tf = false;
		for(int i=0; i<arr1.get(r).get(c).size();i++) {
			if(temp %2 != (arr1.get(r).get(c).get(i).d)%2) {  //불의 방향이 다를 때 
				tf = true;
			}			
			tm += arr1.get(r).get(c).get(i).m;
			ts += arr1.get(r).get(c).get(i).s;
		}
		
		tm = tm/5;
		ts = ts/ arr1.get(r).get(c).size();
		
		if(tm ==0)
			return;
		
		
		if(tf == true) {  //파이어볼 방향 홀짝같지 않음.
			q1.offer(new fire(r,c,tm,ts,1));
			q1.offer(new fire(r,c,tm,ts,3));
			q1.offer(new fire(r,c,tm,ts,5));
			q1.offer(new fire(r,c,tm,ts,7));
		}
		else {   //파이어볼 방향 모두 홀수 또는 모두 짝수
			q1.offer(new fire(r,c,tm,ts,0));
			q1.offer(new fire(r,c,tm,ts,2));
			q1.offer(new fire(r,c,tm,ts,4));
			q1.offer(new fire(r,c,tm,ts,6));
		}
	}	
}