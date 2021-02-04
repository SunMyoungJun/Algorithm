import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569토마토 {

	static class tomato {
		int height;
		int row;
		int col;

		public tomato(int height,int row,int col) {
			this.height = height;
			this.row = row;
			this.col = col;
		}
	}

	static int[][][] check;
	static int m,n,h,day;
	static int[] drow = {-1,0,1,0,0,0};  // 위 -우-아래-좌-앞-뒤
	static int[] dcol = {0,1,0,-1,0,0};
	static int[] dheight ={0,0,0,0,1,-1};

	static Queue<tomato> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); //열
		n = Integer.parseInt(st.nextToken()); //행
		h = Integer.parseInt(st.nextToken()); //높이
		check = new int[h][n][m];
		int zero =0;
		for(int t=0;t<h;t++) {
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					check[t][i][j] = Integer.parseInt(st.nextToken());
					if(check[t][i][j] ==1)
						q.offer(new tomato(t,i,j));
					else if(check[t][i][j] ==0)            //들어올때 익지않은 토마토 갯수
						zero++;
				}
			}
		}
		//////////////입력 포문 끝

		if(zero ==0) {   //들어온 토마토가 다 익어있는 상태라면 0출력
			System.out.println(zero);
			return;
		}
		
		while(!q.isEmpty()) {
			int same = q.size();  //레벨

			for(int i=0;i<same;i++) {
				bfs(q.poll());
			}

			day++;

		}

		for(int t=0;t<h;t++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(check[t][i][j] == 0){
						System.out.println("-1");
						return;
					}
				}
			}
		}
		System.out.println(day-1);

	}  /// 메인문 끝

	static void bfs(tomato tom) {
		tomato T = tom;   //현재 토마토의 좌표
		int row = T.row;
		int col = T.col;
		int height = T.height;
		int temprow=0,tempcol=0,tempheight=0;
		for(int i=0;i<6;i++) {   //6방위 토마토 체크   
			tempheight = height+dheight[i]; 
			temprow = row+drow[i];
			tempcol = col+dcol[i];
			if(tempheight<0 || tempheight >=h || temprow<0 || temprow >=n || tempcol <0 || tempcol >=m)
				continue;
			if(check[tempheight][temprow][tempcol] ==0) { //인접 토마토가 익지 않은 토마토일 떄
				q.offer(new tomato(tempheight,temprow,tempcol));
				check[tempheight][temprow][tempcol] =1;
			}
		}
	}

}
