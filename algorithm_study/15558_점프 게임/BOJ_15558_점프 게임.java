import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,k,cnt;
	static int[][] line;
	static boolean[][] check;
	static Queue<user> q1 = new LinkedList<user>();
	static class user {
		int x,y,LR;
		
		public user(int x,int LR) {
			this.x = x;
			this.LR = LR;  // 0 : 왼쪽    // 1: 오른쪽
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		line = new int[2][N+1];
		check = new boolean[2][N+1];
		check[0][0] = true;
		check[1][0] = true;
		check[0][1] = true;
		String s = br.readLine();
		for(int i=0;i<s.length();i++) {
			line[0][i+1] = s.charAt(i)-48;
		}
		s = br.readLine();
		for(int i=0;i<s.length();i++) {
			line[1][i+1] = s.charAt(i)-48;
		}
		
		q1.offer(new user(1,0));  //  (1,1) 왼쪽 줄 시작
		if(!bfs()) 
			System.out.println("0");
		
		else 
			System.out.println("1");
		
	}
	
	static boolean bfs() {
		user user1;
		int size=0,where=0;
		while(!q1.isEmpty()) {
			cnt++;
			size = q1.size();
			for(int i=0;i<size;i++) {
				user1 = q1.poll();
				
				if(user1.x < cnt) 
					continue;
				
				
				if(user1.x+1>N) {
					return true;
				}
				
				where = user1.LR;
				if(line[where][user1.x+1] ==1 && check[where][user1.x+1] ==false) {  //한칸 앞
					check[where][user1.x+1] = true;
					q1.offer(new user(user1.x+1,where));
				}
				
				if(line[where][user1.x-1] ==1 && check[where][user1.x-1] ==false ) { //한칸 뒤
					check[where][user1.x-1] = true;
					q1.offer(new user(user1.x-1,where));
				}
				
				where = (user1.LR+1) %2;
				
				if(user1.x +k >N) {
					return true;
				}
				if(line[where][user1.x+k] ==1 && check[where][user1.x+k] ==false) { //다른 줄 k번 앞
					check[where][user1.x+k] = true;
					q1.offer(new user(user1.x+k,where));
				}				
			}
		}
		return false;
	}
}