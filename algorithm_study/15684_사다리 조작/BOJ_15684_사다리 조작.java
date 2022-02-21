import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,H,size;
	static int[][] check;
	static ArrayList<int[]> arr1 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		check = new int[H+1][N+1];
		int x=0,y=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			check[x][y] = 1; // 오른쪽으로 뻗음
			check[x][y+1] = 2; // 왼쪽으로 뻗음
		}
		
		for(int i=1; i<H+1; i++) {
			for(int j=1; j<N; j++) {
				arr1.add(new int[] {i,j});
			}
		}
		size =arr1.size();
		for(int i=0; i<4; i++) {
			if(dfs(i,0,0)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println("-1");
		return;
	}
	
	static int move(int val) {
		int row=1;
		while(row <= H) {
			if(check[row][val] ==0) {
				row++;
			}
			else if(check[row][val] ==1) {
				row++;
				val++;
			}
			else {
				row++;
				val--;
			}
		}
		return val;
	}
	
	static boolean checkedTrue() {
		int num=0;
		for(int i=1; i<N+1; i++) {
			num = move(i);
			if(num != i) {
				return false;
			}
		}
		return true;
	}
	
	static boolean dfs(int K, int cnt,int idx) {
		if(cnt == K) {
			if(checkedTrue()) {
				return true;
			}
			return false;
		}
		int[] p1;
		
		for(int i=idx; i<size; i++) {
			p1 = arr1.get(i);
			if(check[p1[0]][p1[1]-1] != 1 && check[p1[0]][p1[1]] == 0 && check[p1[0]][p1[1]+1] == 0) {
				check[p1[0]][p1[1]] = 1;
				check[p1[0]][p1[1]+1] = 2;
				if(dfs(K,cnt+1,i+1)) {
					return true;
				}
				check[p1[0]][p1[1]] = 0;
				check[p1[0]][p1[1]+1] = 0;
			}
		}
		return false;
	}
}