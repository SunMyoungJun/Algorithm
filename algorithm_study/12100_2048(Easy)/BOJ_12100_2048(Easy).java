import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int max = -1;
//	static String[] dir = {"TOP","RIGHT","BOTTOM","LEFT"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = (max < map[i][j]) ? map[i][j] : max;
			}
		}
		
		
		dfs(0,map);
		System.out.println(max);
	}
	
	
	
	static void dfs(int cnt, int[][] map) {
		if(cnt == 5) {
			return;
		}
		
		
		int[][] temp = new int[N][N];
		for(int d=0; d<4; d++) { //위 , 오른쪽, 아래 , 왼쪽
			
			temp = slide(d,map);
			dfs(cnt+1,temp);
		}
		
		
		
	}
	
	
	static int[][] slide(int dir,int[][] map) {
		int[][] temp = new int[N][N];
		boolean[][] check = new boolean[N][N];
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		if(dir ==0) {
			for(int j=0; j<N; j++) {
				for(int i=0; i<N; i++) {
					if(temp[i][j] == 0) {
						continue;
					}
					int tt=0;
					int row=-1,col=-1;
					boolean flag = false;
					for(int t=0; t<i; t++) {
						if(temp[t][j] == 0) { // 벽으로 밀 수 있을 때
							tt=t;
							flag = true;
							break; // 맞을 것
						}
						else { // 0이 아닐 때 제일 가까운 인덱스 찾기
							row =t;
							col =j;
						}
					}
					if((row!=-1 && col!=-1) &&check[row][col]==false && temp[row][col] == temp[i][j]) { // 아직 한번도 안합쳐서 합칠 수 있을 때
						temp[row][col] = temp[i][j] *2;
						max = (max > temp[row][col]) ? max : temp[row][col];
						check[row][col] = true;
						temp[i][j] = 0;
					}
					else if(flag) { // 빈공간으로 밀 수 있을 때
						temp[tt][j] = temp[i][j];
						temp[i][j] = 0;
					}
					
				}
			}
			
			
			
			
		}
		else if(dir ==1) {
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>=0; j--) {
					if(temp[i][j] == 0) {
						continue;
					}
					int row=-1,col=-1;
					int tt=0;
					boolean flag = false;
					for(int t=N-1; t>j; t--) {
						if(temp[i][t] == 0) { // 벽으로 밀 수 있을 때
							tt=t;
							flag = true;
							break; // 맞을 것
						}
						else { // 0이 아닐 때 제일 가까운 인덱스 찾기
							row =i;
							col =t;
						}
					}
					if((row!=-1 && col!=-1) && check[row][col]==false && temp[row][col] == temp[i][j]) { // 아직 한번도 안합쳐서 합칠 수 있을 때
						temp[row][col] = temp[i][j] *2;
						max = (max > temp[row][col]) ? max : temp[row][col];
						check[row][col] = true;
						temp[i][j] = 0;
					}
					else if(flag) { // 빈공간으로 밀 수 있을 때
						temp[i][tt] = temp[i][j];
						temp[i][j] = 0;
					}
					
				}
			}
		}
		else if(dir ==2) {
			for(int j=0; j<N; j++) {
				for(int i=N-1; i>=0; i--) {
					if(temp[i][j] == 0) {
						continue;
					}
					int row=-1,col=-1;
					int tt=0;
					boolean flag = false;
					for(int t=N-1; t>i; t--) {
						if(temp[t][j] == 0) { // 벽으로 밀 수 있을 때
							tt=t;
							flag = true;
							break; // 맞을 것
						}
						else { // 0이 아닐 때 제일 가까운 인덱스 찾기
							row =t;
							col =j;
						}
					}
					if((row!=-1 && col!=-1) && check[row][col]==false && temp[row][col] == temp[i][j]) { // 아직 한번도 안합쳐서 합칠 수 있을 때
						temp[row][col] = map[i][j] *2;
						max = (max > temp[row][col]) ? max : temp[row][col];
						check[row][col] = true;
						temp[i][j] = 0;
					}
					else if(flag) { // 빈공간으로 밀 수 있을 때
						temp[tt][j] = temp[i][j];
						temp[i][j] = 0;
					}
					
				}
			}
		}
		else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[i][j] == 0) {
						continue;
					}
					int row=-1,col=-1;
					int tt=0;
					boolean flag = false;
					for(int t=0; t<j; t++) {
						if(temp[i][t] == 0) { // 벽으로 밀 수 있을 때
							tt=t;
							flag = true;
							break; // 맞을 것
						}
						else { // 0이 아닐 때 제일 가까운 인덱스 찾기
							row =i;
							col =t;
						}
					}
					if((row!=-1 && col!=-1) && check[row][col]==false && temp[row][col] == temp[i][j]) { // 아직 한번도 안합쳐서 합칠 수 있을 때
						temp[row][col] = temp[i][j] *2;
						max = (max > temp[row][col]) ? max : temp[row][col];
						check[row][col] = true;
						temp[i][j] = 0;
					}
					else if(flag) { // 빈공간으로 밀 수 있을 때
						temp[i][tt] = temp[i][j];
						temp[i][j] = 0;
					}
					
				}
			}
		}
		
		
		return temp;
	}

}
