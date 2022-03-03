import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,min=Integer.MAX_VALUE;
	static int[][] map1,map2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		map1 = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int x=1; x<N+1; x++) {
			for(int y=1; y<N+1; y++) {
				for(int d1=1; d1<N+1; d1++) {
					for(int d2=1; d2<N+1; d2++) {
						if(x+d1+d2 >N || y+d2 >N || y-d1 <1) {
							continue;
						}
						
		
						map2 = new int[N+1][N+1];
						divide(x,y,d1,d2);
						sumResult();
						
					}
				}
			}
		}
		
		System.out.println(min);
	}
	
	
	static void sumResult() {
		int[] temp = new int[6];
		int idx=0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				idx = map2[i][j];
				idx = (idx ==0) ? 5: idx;
				temp[idx] += map1[i][j];
			}
		}
		Arrays.sort(temp);
		int sum = temp[5] - temp[1];
		min = (min < sum) ? min : sum;
		
	}
	
	
	
	static void fiveDivde(int x,int y,int d1,int d2) {
		int val=0;
		while(val <=d1) {
			map2[x+val][y-val] = 5;
			map2[x+d2+val][y+d2-val] = 5;
			val++;
		}
		
		val=0;
		while(val <=d2) {
			map2[x+val][y+val] = 5;
			map2[x+d1+val][y-d1+val] = 5;
			val++;
		}
		for(int i=x+1; i<x+d1+d2; i++) {
			boolean flag = false;
			for(int j=1; j<=N; j++) {
				if(map2[i][j] == 5 && !flag) {
					flag = true;
				}
				else if(map2[i][j] == 5 && flag) {
					break;
				}
				if(flag && map2[i][j] == 0) {
					map2[i][j] = 5;
				}
			}
		}
		
	}
	
	
	static void divide(int x,int y,int d1,int d2) {
		//5번 경계값 넣기
		fiveDivde(x,y,d1,d2);
		
		for(int i=1; i<x+d1; i++) { // 1번 선거구
			for(int j=1; j<=y; j++) {
				if(map2[i][j] == 5) {
					continue;
				}
				map2[i][j] = 1;
			}
		}
		
		for(int i=1; i<=x+d2; i++) { // 2번 선거구
			for(int j=y+1; j<=N; j++) {
				if(map2[i][j] == 5) {
					continue;
				}
				map2[i][j] = 2;
			}
		}
		
		for(int i=x+d1; i<=N; i++) {
			for(int j=1; j<y-d1+d2; j++) {
				if(map2[i][j] == 5) {
					continue;
				}
				map2[i][j] = 3;
			}
		}
		
		
		for(int i=x+d2+1; i<=N; i++) {
			for(int j=y-d1+d2; j<=N; j++) {
				if(map2[i][j] == 5) {
					continue;
				}
				map2[i][j] = 4;
			}
		}
		
		
		
		
	}
	
	

}
