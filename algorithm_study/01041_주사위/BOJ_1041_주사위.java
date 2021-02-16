import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static long N;
	static int temp1,temp2,temp3;
	static long MIN1 = Long.MAX_VALUE;
	static long MIN2 = Long.MAX_VALUE;
	static long[] dice = new long[7];
	static int[] doubledice = new int[2];
	static int[] tripledice = new int[3];
	static boolean[][] dicecheck = new boolean[7][7];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long minnum=Long.MAX_VALUE;
		long maxnum = 0;
		for(int i=1;i<7;i++) {
			dice[i] = Integer.parseInt(st.nextToken());
			minnum = (minnum < dice[i]) ? minnum : dice[i];
			maxnum = (maxnum >dice[i]) ? maxnum : dice[i];
		}
		
		dicecheck[1][6] = true; //마주 보는 면은 같이오면안됨.
		dicecheck[2][5] = true;
		dicecheck[3][4] = true;
		
		dfs(0,1);
		dfs2(0,1);
		long sum =0;  //MIN1 : 2면이 최소인값. // MIN2 : 3면이 최소인값.  // minnum : 1면이 최소인값.
		sum = sum + MIN1 * 4 * (N-1) + MIN1 * (N*N - ((N*N-(4*N-4))+4)); // 2면 정육면체 총합
		sum = sum + MIN2*4;  //가장 위층 세면이 보이는 정육면체 4개
		sum = sum + minnum * (N-2) * 4 * (N-1) + minnum* (N*N - (4*N-4));  // 1면 정육면체 총합.
		
		if(N ==1) {
			int tempsum=0;
			for(int i=1;i<7;i++) {
				if(maxnum != dice[i]) {
					tempsum += dice[i];
				}
			}
			System.out.println(tempsum);
			return;
		}
		System.out.println(sum);
		
		
		
	}
	
	static void dfs(int cnt,int start) {  //2면이 최소인 값 찾기.
		if(cnt ==2) {
			temp1 = doubledice[0];
			temp2 = doubledice[1];
			
			if(dicecheck[temp1][temp2] ==false) { //마주보는 면일때 안됨.
				MIN1 = (MIN1 < dice[temp1]+dice[temp2]) ? MIN1 : dice[temp1]+dice[temp2];
			}
			
			
			return;
		}
		
		for(int i=start;i <7;i++) {
			doubledice[cnt] = i;
			dfs(cnt+1,i+1);
		}
	}
	
	static void dfs2(int cnt,int start) {  //3면이 최소인 값 찾기.
		if(cnt ==3) {
			temp1 = tripledice[0];
			temp2 = tripledice[1];
			temp3 = tripledice[2];
			//마주보는 면이 포함되어 있으면 안됨.
			if(dicecheck[temp1][temp2] ==false && dicecheck[temp1][temp3] ==false && dicecheck[temp2][temp3]==false)
				MIN2 = (MIN2 < dice[temp1]+dice[temp2]+dice[temp3]) ? MIN2 : dice[temp1]+dice[temp2]+dice[temp3];
			
			return;
		}
		
		for(int i=start;i <7;i++) {
			tripledice[cnt] = i;
			dfs2(cnt+1,i+1);
		}
	}
}