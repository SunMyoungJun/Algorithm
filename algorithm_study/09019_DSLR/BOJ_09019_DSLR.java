import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<reg> q1 = new LinkedList<reg>();
	static int A,B;
	static boolean[] check;
	static class reg {
		int num;
		String order;
		
		public reg(int num,String order) {
			this.num = num;
			this.order = order;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		check = new boolean[10002];
		while(test-- !=0) {
			Arrays.fill(check, false);
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			check[A] = true;
			q1.offer(new reg(A,""));   //시작
			bfs();		
			q1.clear();
		}
	}
	
	static void bfs() {
		reg rg;
		while(!q1.isEmpty()) {
			rg = q1.poll();
			
			if(funcD(rg))
				return;
			if(funcS(rg))
				return;
			if(funcL(rg))
				return;
			if(funcR(rg))
				return;
		}
	}
	
	static boolean funcD(reg rg) {
		int tnum = rg.num * 2 % 10000;
		if(tnum == B) {
			System.out.println(rg.order+"D");
			return true;
		}
		if(check[tnum] == false) {
			q1.offer(new reg(tnum, rg.order +"D"));
			check[tnum] = true;
		}
		return false;
	}

	static boolean funcS(reg rg) {
		int tnum = (rg.num -1 == -1) ? 9999 : rg.num -1;
		if(tnum == B) {
			System.out.println(rg.order+"S");
			return true;
		}
		if(check[tnum] == false) {
			q1.offer(new reg(tnum, rg.order+"S"));
			check[tnum] = true;
		}
		return false;
	}
	
	static boolean funcL(reg rg) {
		int tnum =0;

		if(rg.num /1000 !=0) 
			tnum = (rg.num - (rg.num/1000)*1000)*10 + rg.num/1000;  //왼쪽 회전
		
		else 
			tnum = rg.num *10;
		
		if(tnum ==B) {
			System.out.println(rg.order+"L");
			return true;
		}
		
		if(check[tnum] == false && tnum !=0) {
			q1.offer(new reg(tnum, rg.order+"L"));
			check[tnum] = true;
		}
		return false;
	}
	
	static boolean funcR(reg rg) {
		int tnum =0;
		
		if(rg.num /1000 !=0)
			tnum = rg.num /10 + rg.num % 10 * 1000;  //오른쪽으로 회전
	
		else
			tnum = rg.num % 10 * 1000 + rg.num/10;
		
		if(tnum ==B) {
			System.out.println(rg.order+"R");
			return true;
		}
		
		if(check[tnum] == false && tnum !=0)  {// 일의 자리면 안넣음.
			q1.offer(new reg(tnum,rg.order+"R"));
			check[tnum] = true;
		}
		return false;
	}		
}