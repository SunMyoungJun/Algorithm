import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dy = {0,-1,0,1};
		int[] dx = {1,0,-1,0};
		int x=0,y=0,d=0,g=0,size=0,num=0,cnt =0;

		int N = Integer.parseInt(br.readLine());
		boolean[][] check = new boolean[101][101];
		for(int t=0;t<N;t++) {
			List<Integer> point = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			check[y][x] = true;  //시작점
			point.add(d);   //시작 방향 삽입
			while(g-- !=0) {
				size = point.size()-1;


				for(int i=size;i>=0;i--) {
					num = (point.get(i) +1)%4;
					point.add(num);
				}

			}		
			for(int i=0;i<point.size();i++) {  //point 리스트로 좌표 체크
				num = point.get(i);
				y = y+dy[num];
				x = x+dx[num];

				if(y<0 || y>100 || x<0 || x>100)
					continue;

				check[y][x] = true;
			}
		}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(check[i][j] ==false || check[i][j+1] ==false ||
						check[i+1][j] ==false || check[i+1][j+1] ==false) {
						continue;
				}
				
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}


