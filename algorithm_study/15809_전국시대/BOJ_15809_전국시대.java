import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N,M,O,P,Q;
	static int[] nation;
	static int[] soldier;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nation = new int[N];
		soldier = new int[N];
		for(int i=0; i<N; i++) {
			nation[i] =i;
			soldier[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			O = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken())-1;
			Q = Integer.parseInt(st.nextToken())-1;
			
			if(O == 1) { // 동맹
				union(P,Q,0);
			}
			else { // 싸움
				union(P,Q,1);
			}	
			
		}
		
		Arrays.sort(soldier);
		int cnt =0;
		int size = soldier.length;
		for(int i=0; i<size; i++) {
			if(soldier[i] !=0 ) {
				cnt++;
				if(i == size-1) {
					sb.append(soldier[i]).append("\n");
				}
				else {
					sb.append(soldier[i]).append(" ");
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb.toString());
		
		

	}
	
	
	static int findSet(int num) {
		if(nation[num] == num) {
			return num;
		}
		return nation[num] = findSet(nation[num]);
	}
	
	static void union(int num1, int num2,int flag) {
		num1 = findSet(num1);
		num2 = findSet(num2);
		
		
		if(flag == 0) {
			nation[num1] = num2;
			soldier[num2] += soldier[num1];
			soldier[num1] = 0;
		}
		else {
			if(soldier[num1] > soldier[num2]) {
				nation[num2] = num1;
				soldier[num1] -=soldier[num2];
				soldier[num2] = 0;
			}
			else if(soldier[num1] == soldier[num2]) {
				nation[num1] = -1;
				nation[num2] = -1;
				soldier[num1] = 0;
				soldier[num2] = 0;
			}
			else {
				nation[num1] = num2;
				soldier[num2] -=soldier[num1];
				soldier[num1] = 0;
			}
		}

	}
	
	

}
