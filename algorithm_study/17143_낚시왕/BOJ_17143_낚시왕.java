import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int R,C,M,weight,SUM,start=1,temp;
	static int tx,ty;
	static int[][][] map;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,1,-1};
	static shark tshark;
	static int tr,tc,ts,td,tz;
	
	static PriorityQueue<shark> q1 = new PriorityQueue<>(new Comparator<shark>() {
		@Override
		public int compare(shark o1, shark o2) {
			return o2.z-o1.z;
		}
	});	
	static class shark {
		int r,c,s,d,z;

		public shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1][3];  // s : 속력,d : 방향,z : 무게
		int r=0,c=0,s=0,d=0,z=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			map[r][c][0] =s;
			map[r][c][1] =d;
			map[r][c][2] =z;
		}
		
		while(start != C+1) {			
			//낚시왕이 한칸 이동하자
			fishing();
			mapclear(); // map에 있는 상어 정보 queue에 담고 map은 초기화
			move();  // queue에서 한개씩 꺼내서 움직임
			start++;
		}
		System.out.println(SUM);
	}
	
	static void fishing() {
		for(int i=0;i<R+1;i++) {
			if(map[i][start][2] !=0) {
				weight = map[i][start][2];  //지울 물고기 무게로 물고기판별할거라서 무게저장.
				SUM+=weight;
				break;
			}
		}
	}
	
	static void move() {
		while(!q1.isEmpty()) {
			tshark = q1.poll();
			tr = tshark.r;
			tc = tshark.c;
			ts = tshark.s;
			td = tshark.d;
			tz = tshark.z;
			
			if(tz == weight)
				continue;
						
			if(td == 1 || td == 2) { //상하인 경우
				ts = ts % ((R-1) *2);
			}
			else if(td==3 || td ==4) { //좌우인 경우
				ts = ts % ((C-1) *2);
			}
			
			for(int i=0;i<ts;i++) {
				tr =tr+dx[td];
				tc = tc+dy[td];
				if(tr<=0 || tr>R || tc<=0 || tc>C) {
					tr =tr-dx[td];   //벽에 부딪히면 다시 원래자리로 설정 
					tc = tc-dy[td];
					
					if(td ==1)
						td =2;
					else if(td ==2)
						td=1;
					else if(td==3)
						td=4;
					else if(td==4)
						td=3;
					tr =tr+dx[td];
					tc = tc+dy[td];
				}
			}
			
			if(map[tr][tc][2] !=0) {
				continue;
			}
				
			map[tr][tc][0] = ts;
			map[tr][tc][1] = td;
			map[tr][tc][2] = tz;
		}	
	}
	
	static void mapclear() {  //map에 있는 상어 정보를 다시 큐에 담으면서 map은 0으로 초기화
		
		for(int i=0;i<R+1;i++) {
			for(int j=0;j<C+1;j++) {
				if(map[i][j][2] !=0) {
					q1.offer(new shark(i,j,map[i][j][0],map[i][j][1],map[i][j][2]));
											// s : 속력,    d : 방향,     z : 무게
				}
				map[i][j][0] = 0;
				map[i][j][1] = 0;
				map[i][j][2] = 0;
			}
		}
	}
}