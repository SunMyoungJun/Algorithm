import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static int[] square = new int[11];
	static int[][] map;
	static int N;
	static ArrayList<int[]> arr1 = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[10][10];
		for(int i=1;i<10;i++) {
//			s = br.readLine();
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					arr1.add(new int[] {i,j});
					N++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(dfs(0)) {
			for(int i=1;i<10;i++) {
				for(int j=1;j<10;j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}



	static boolean dfs(int cnt) {
		int tx=0,ty=0;
		if(cnt == N) {
			return true;
		}

		int[] p1 = arr1.get(cnt);
		tx = p1[0];
		ty = p1[1];
		
		for(int i=1;i<10;i++) {
			map[tx][ty] = i;
			if(checkOk(tx,ty)) {
				if(dfs(cnt+1)) {
					return true;
				}
			}
			map[tx][ty] = 0;
		}
		
		return false;

	}


	static boolean checkOk(int row,int col) {
		boolean[] check = new boolean[10];   // 가로
		boolean[] check2 = new boolean[10];  // 세로  
		for(int i=1;i<10;i++) {			
			if(map[row][i] !=0 && check[map[row][i]] == false) { // row행의 1~9번 열까지 중복여부를 체크하는거
				check[map[row][i]] = true;  // 9번에 true
			}
			else if(map[row][i] !=0 && check[map[row][i]] == true) {
				return false;
			}
			
			
			
			
			
			if(map[i][col] !=0 && check2[map[i][col]] == false) {
				check2[map[i][col]] = true;
			}
			else if(map[i][col] !=0 && check2[map[i][col]] == true){
				return false;
			}
		}
		
		
		
		
		
		
		
		if(row<=3 && col<=3) {
			if(!checkArea(1,1)) {   
				return false;
			}
		}
		else if(row<=3 && col<=6) {
			if(!checkArea(1,4)) {
				return false;
			}
		}
		else if(row<=3 && col<=9) {
			if(!checkArea(1,7)) {
				return false;
			}
		}
		else if(row<=6 && col<=3) {
			if(!checkArea(4,1)) {
				return false;
			}
		}
		else if(row<=6 && col<=6) {
			if(!checkArea(4,4)) {
				return false;
			}
		}
		else if(row<=6 && col<=9) {
			if(!checkArea(4,7)) {
				return false;
			}
		}
		else if(row<=9 && col<=3) {
			if(!checkArea(7,1)) {
				return false;
			}
		}
		else if(row<=9 && col<=6) {
			if(!checkArea(7,4)) {
				return false;
			}
		}
		else if(row<=9 && col<=9) {
			if(!checkArea(7,7)) {
				return false;
			}
		}
		return true;
	}

	
	

	private static boolean checkArea(int n, int m) {  // 1 1 3 3  1그거야
		boolean[] check3 = new boolean[10];

		for(int i=n; i<=n+2;i++) {
			for(int j=m; j<=m+2;j++) {
				if(map[i][j] ==0) {
					continue;
				}
				if(check3[map[i][j]] == false) {
					check3[map[i][j]] = true;
				}
				else {
					return false;
				}
			}
		}
		
		
		return true;
		
	}

}
