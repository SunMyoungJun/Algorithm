import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static char[] map;
	static char[][] map2 = new char[5][9];
	static boolean[] check = new boolean[13];
	static boolean[] check2 = new boolean[13];
	static boolean tf;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12];
		int cnt=0;
		String s;
		for(int i=0;i<5;i++) {
			s = br.readLine();
			for(int j=0;j<9;j++) {
				map2[i][j] = s.charAt(j);
				if(s.charAt(j) !='.') {
					map[cnt] = s.charAt(j);
					if(map[cnt] !='x') {      //  알파벳일때  체크2(변하지않게) true 대입.
						check2[cnt] = true;
						check[s.charAt(j)-64] = true;
					}
					cnt++;
				}
			}
		}
		dfs(0);
		for(int i=0;i<5;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(map2[i][j]);
			}
			System.out.println();
		}
	}

	
	static void result() {
		int cnt =0;
		map2[0][4] = map[cnt++];
		for(int i=1;i<8;i=i+2)
			map2[1][i] = map[cnt++];
		map2[2][2] = map[cnt++];
		map2[2][6] = map[cnt++];
		for(int i=1;i<8;i=i+2)
			map2[3][i] = map[cnt++];
		
		map2[4][4] = map[cnt];
		
		
	}
	
	static void dfs(int cnt) {
		
		if(cnt ==12) {
			tf = true;
			result();
			return;
		}
		
		if(tf ==true)
			return;
		if(map[cnt] !='x')
			dfs(cnt+1);
		
		for(int i=1;i<13;i++) {
			if(check[i] ==true || check2[cnt] ==true)
				continue;
			map[cnt] = (char)(i+64);
			if(cnt ==0 || cnt == 2 || cnt == 5 || cnt == 7) {
				if(!one())
					continue;
			}
			if(cnt == 0 || cnt == 3 || cnt == 6 || cnt == 10) {
				if(!two())
					continue;
			}
			if(cnt == 7 || cnt == 8 || cnt == 9 || cnt == 10 ) {
				if(!three())
					continue;
			}
			if(cnt == 1  || cnt == 5 || cnt == 8 || cnt == 11 ) {
				if(!four())
					continue;
			}
			if(cnt == 4 || cnt == 6 || cnt == 9 || cnt == 11 ) {
				if(!five())
					continue;
			}
			if(cnt == 1 || cnt == 2 || cnt == 3 || cnt == 4 ) {
				if(!six())
					continue;
			}
			check[i] = true;
			dfs(cnt+1);
			check[i] = false;
			if(tf ==true)
				return;
		}
		
		if(check2[cnt] == false)
			map[cnt] ='x';
		
		
	}
	
	
	static boolean one() {
		int sum=0;
		if(map[0] !='x' && map[2] !='x' && map[5] !='x' && map[7] !='x') {
			sum = map[0] +map[2] + map[5] + map[7] - 256;  //64 * 4 를 뻄.
			if(sum == 26)
				return true;
			else
				return false;
		}
			
		return true;
			
	}
	static boolean two() {
		int sum=0;
		if(map[0] !='x' && map[3] !='x' && map[6] !='x' && map[10] !='x') {
			sum = map[0] +map[3] + map[6] + map[10] - 256;  //64 * 4 를 뻄.
			if(sum == 26)
				return true;
			else
				return false;
		}
			
		return true;
		
	}
	static boolean three() {
		int sum=0;
		if(map[7] !='x' && map[8] !='x' && map[9] !='x' && map[10] !='x') {
			sum = map[7] +map[8] + map[9] + map[10] - 256;  //64 * 4 를 뻄.
			if(sum == 26)
				return true;
			else
				return false;
		}
			
		return true;
	}
	static boolean four() {
		int sum=0;
		if(map[1] !='x' && map[5] !='x' && map[8] !='x' && map[11] !='x') {
			sum = map[1] +map[5] + map[8] + map[11] - 256;  //64 * 4 를 뻄.
			if(sum == 26)
				return true;
			else
				return false;
		}
			
		return true;
	}
	static boolean five() {
		int sum=0;
		if(map[4] !='x' && map[6] !='x' && map[9] !='x' && map[11] !='x') {
			sum = map[4] +map[6] + map[9] + map[11] - 256;  //64 * 4 를 뻄.
			if(sum == 26)
				return true;
			else
				return false;
		}
			
		return true;
		
	}
	static boolean six() {
		int sum=0;
		if(map[1] !='x' && map[2] !='x' && map[3] !='x' && map[4] !='x') {
			sum = map[1] +map[2] + map[3] + map[4] - 256;  //64 * 4 를 뻄.
			if(sum == 26)
				return true;
			else
				return false;
		}
			
		return true;
	}
}