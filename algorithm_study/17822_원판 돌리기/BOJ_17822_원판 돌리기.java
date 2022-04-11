import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,T;
	static int x,d,k;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(T-- !=0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			rotate();
			if(!findIn()) {
				divide();
			}
		}
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>0) {
					sum +=map[i][j];
				}
			}
		}
		System.out.println(sum);
	}

	static void divide() {
		double sum=0;
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>0) {
					cnt++;
					sum +=map[i][j];
				}
			}
		}

		double value = sum/cnt;

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] ==0) {
					continue;
				}
				if(map[i][j] > value) {
					map[i][j]--;
				}
				else if(map[i][j] < value){
					map[i][j]++;
				}
			}
		}
	}

	static boolean findIn() {

		boolean[][] check = new boolean[N][M];
		boolean flag = false;
		for(int i=0; i<N; i++) { 
			for(int j=0; j<M;j++) {
				if(map[i][j] == map[i][(j+1)%M]) {
					check[i][j] = true;
					check[i][(j+1)%M] =  true;
					if(map[i][j] !=0) {
						flag = true;
					}
				}
			}
		}
		for(int i=0;i<M; i++) {
			for(int j=0; j<N-1; j++) {
				if(map[j][i] == map[j+1][i]) {
					check[j][i] = true;
					check[(j+1)%N][i] = true;
					if(map[j][i] !=0) {
						flag = true;
					}
				}
			}
		}

		if(!flag) {
			return false;
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(check[i][j]) {
					map[i][j] = 0;
				}
			}
		}
		return true;
	}

	static void rotate() { // x : 배수 , d : 방향, k : 칸수

		int[][] temp = new int[N][M];

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp[i][j] = map[i][j];
			}
		}

		int idx=0;
		k= (d==0) ? k : -k;
		for(int i=(x-1); i<N; i=i+x) {
			for(int j=0; j<M; j++) {
				
				idx = (j+k)%M;
				idx = (idx <0) ? M+idx : idx;
				temp[i][idx] = map[i][j];
				
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M;j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
}