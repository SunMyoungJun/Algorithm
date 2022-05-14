import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K,minFish=Integer.MAX_VALUE;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[N-1][i] = Integer.parseInt(st.nextToken());
			minFish = Math.min(minFish, map[N-1][i]);
		}

		int cnt=1;
		while(true) {
			plusFish();
			leftBlock();
			upDateFish();
			map = line();
			banBlock();
			upDateFish();
			map = line();
			if(minMax()) {
				break;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	
	static boolean minMax()  {
		int min=Integer.MAX_VALUE;
		int max =0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) {
					continue;
				}
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		minFish = min;
		if(max-min <=K) {
			return true;
		}
		return false;	
	}
	
	
	static void banBlock() {


		int mok = N/2;
		int idx = mok-1;
		for(int i=0; i<mok; i++) {
			map[N-2][i] = map[N-1][idx--];
		}

		for(int i=mok; i<N; i++) {
			map[N-1][i-mok] = map[N-1][i];
			map[N-1][i]=0;
		}

		mok = mok/2;
		idx=N-1-2;
		int idx2 = mok-1;

		for(int i=N-2; i<=N-1; i++) {
			idx2=mok-1;
			for(int j=0; j<mok; j++) {
				map[idx][idx2--] = map[i][j];
				map[i][j] = map[i][j+mok];
				map[i][j+mok] = 0;
			}
			idx--;
		}
	}

	static int[][] line() {
		int[][] temp = new int[N][N];

		int idx=0;


		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {
				if(map[j][i] ==0) {
					continue;
				}
				temp[N-1][idx++] = map[j][i];
			}
		}
		return temp;
	}

	static void upDateFish() {

		int[][] temp = new int[N][N];

		int mok=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				mok = (Math.abs(map[i][j] - map[i][j+1]))/5;
				if(mok>0 && map[i][j+1] !=0) {
					if(map[i][j] > map[i][j+1]) {
						temp[i][j] -= mok;
						temp[i][j+1] +=mok;
					}
					else {
						temp[i][j]+=mok;
						temp[i][j+1] -=mok;
					}
				}
				if(i+1 ==N) {
					continue;
				}
				mok = (Math.abs(map[i][j] - map[i+1][j]))/5;
				if(mok>0 && map[i][j] !=0) {
					if(map[i][j] > map[i+1][j]) {
						temp[i][j] -= mok;
						temp[i+1][j] +=mok;
					}
					else {
						temp[i][j]+=mok;
						temp[i+1][j] -=mok;
					}
				}

			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}
	static void leftBlock() {
		map[N-2][0] = map[N-1][0];
		for(int i=0; i<N-1; i++) { // 일단 한칸은 끌어올리기
			map[N-1][i] = map[N-1][i+1];
		}
		map[N-1][N-1]=0;
		while(true) {
			int n1=0,n2=0,n3=0; // 높이가 몇인지, 그런게 몇개인지
			for(int i=N-1; i>=0; i--) {
				if(map[i][0] >0) {
					n1++;
				}
				else {
					break;
				}
			}

			for(int i=0; i<N; i++) {
				if(map[N-2][i] >0) {
					n2++;
				}
				if(map[N-1][i]>0) {
					n3++;
				}

			}
			if(n2+n1 > n3) {
				break;
			}

			int idx=N-2,idx2=n2;
			for(int i=n2-1; i>=0; i--) {
				for(int j=N-1; j>=N-n1; j--) {
					map[idx][idx2++] = map[j][i];
					map[j][i]=0;
				}
				idx2=n2;
				idx--;
			}

			boolean flag=false;
			int idx3=0;
			for(int i=N-1; i>=N-n2-1;i--) {
				flag=false;
				idx3=0;
				for(int j=0; j<N-1; j++) {
					if(!flag && map[i][j+1] >0) {
						flag=true;
					}
					if(flag && map[i][j+1]>0) {
						map[i][idx3++] = map[i][j+1];
						map[i][j+1]=0;
					}
				}
			}
		}
	}

	static void plusFish() {
		for(int i=0; i<N; i++) {
			if(map[N-1][i] == minFish) {
				map[N-1][i]++;
			}
		}
	}
}