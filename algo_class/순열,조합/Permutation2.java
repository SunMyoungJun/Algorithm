package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class MS_1t {
	static int N,R;
	static int[] map;
	static int[] res;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int t = 1; t<=TC;t++) {
			N = sc.nextInt();
			R = sc.nextInt();
			map = new int[N];
			res = new int[R];
			v = new boolean[N];
			for(int i=0; i<N; i++) {
				map[i] = sc.nextInt();
			}
			//입력 확인하자.
//			System.out.println(Arrays.toString(map));
			System.out.println("#"+t);
			perm(0);
		}
	}
	private static void perm(int cnt) {
//		종료조건
		if(cnt ==R) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
//		실행 & 실행+재귀호출
		for(int i=0; i<N; i++) {
			if(v[i]) {
				continue;
			}
			res[cnt] = map[i];
			v[i] = true;
			perm(cnt+1);			
			v[i] = false;
		}
		
//		재귀호출
		
		
		
	}

}
