import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static int[][] bun;
	static int[][] map;
	static boolean[][] check;
	static List<Integer>[][] arr1;
	static PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return (o1[2] > o1[2]) ? 1: -1;
		}
	});
	
	static class Node {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x=0,y=0,z=0,result=0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr1 = new ArrayList[N+1][N+1];
		
		
		map = new int[N+1][N+1];
		bun = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				bun[i][j] = Integer.parseInt(st.nextToken());
				arr1[i][j] = new ArrayList<>();
				map[i][j] = 5;
			}
		}
		
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			arr1[x][y].add(z);
		}
		
		
		while(K-- !=0) {
			arraySort();
			ageage(); // 나이증가
			arraySort();
			bunSick();
			plusBun();
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(arr1[i][j].size() >0) {
					result += arr1[i][j].size();
				}
				
			}
		}
		System.out.println(result);
		
		
	}
	
	static void plusBun() {
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				map[i][j] += bun[i][j];
			}
		}
	}
	
	
	static void bunSick() {
		
		int[] p1;
		int tx=0,ty=0;
		while(!pq1.isEmpty()) {
			p1 = pq1.poll();
			
			for(int d=0;d<8;d++) {
				tx = p1[0] + dx[d];
				ty = p1[1] + dy[d];
				
				if(tx<=0 || tx>N || ty<=0 || ty>N) {
					continue;
				}
				arr1[tx][ty].add(1);
			}
			
		}
		
		
		
		
	}
	
	
	static void ageage() {
		int size=0;
		int age=0,cnt=0;
		check = new boolean[N+1][N+1];
		
		
		for(int i=1 ;i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				cnt=0;
				size = arr1[i][j].size();
				for(int z=0;z<size;z++) {
					age = arr1[i][j].get(z+cnt);
					if(check[i][j] == false) {
						if(map[i][j] < age) {
							check[i][j] = true;
							map[i][j]+=age/2;
							arr1[i][j].remove(z+cnt);
							cnt--;
							continue;
						}
						
						map[i][j] -= age;
						arr1[i][j].remove(z+cnt);
						cnt--;
						arr1[i][j].add(++age);
						if(age>=5 && age%5==0) {
							pq1.offer(new int[] {i,j,age});
						}
					}
					else {
						map[i][j]+=age/2;
						arr1[i][j].remove(z+cnt);
						cnt--;
					}
				}
			}
		}
	}
	
	
	
	static void arraySort() {
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				Collections.sort(arr1[i][j],new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return (o1 > o2) ? 1: -1;
					}
				});
			}
		}
	}

}
