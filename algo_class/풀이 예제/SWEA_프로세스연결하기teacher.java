package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW프로세스연결하기teacher {
	static int N,max,totalCnt,min,map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static ArrayList<int[]> list;  //고려해야하는 코어만 담고 있는 리스트(가장자리 코어는 배제)
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC ; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0; //최대 연결 코어 개수
			min = Integer.MAX_VALUE; //최대 코어 연결 개수 같을때 전선의 최소 길이 합
			totalCnt =0; //총 관리해야하는 코어개수
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(i==0 || j==0 || i==N-1 || j==N-1) continue;  //가장자리 코어는 안봐도됨.
					if(map[i][j] ==1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				
				}
			}
			go(0,0);
			System.out.println("#"+tc+" "+min);
		}
		
		
	}
	
	//부분집합으로 품.
	private static void go(int index,int cCnt) {  // index : 부분집합에 고려할 코어 인덱스, cCnt : 연결된 코어 개수
		
		if(index == totalCnt) {
			int res = getLength(); // 높아진 전선의 길이 구하기
			
			if(max <cCnt) {
				max = cCnt;
				min = res;
			}
			else if(max == cCnt) 
				if(res<min) min = res;
			return ;
		}
		
		
		// 코어 선택 해서 전선을 놓아봄.(4방향으로 놓아보기)
		int[] cur = list.get(index);
		int r = cur[0]; //현재 행 좌표
		int c = cur[1]; // 현재 열 좌표
		
		for(int d =0; d<4;d++) {
			if(isAvailable(r, c, d)) {
				// 전선을 놓자.
				setStatus(r, c,d,2);
				// 다음 코어로 넘어가기
				go(index+1,cCnt+1);
//				놓았던 전선 되돌리기.
				setStatus(r,c,d,0);
			}
		}
		// 코어 비선택
		go(index+1,cCnt);
	}
	
	private static void setStatus(int r,int c, int d,int s) {
		int nr=r,nc=c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr >=N || nc <0 || nc >=N) break;
			map[nr][nc] = s; //전선을 놓았다가 뺏다가 상태를 0과 2중에서 들어옴.
		}
	}
	
	private static boolean isAvailable(int r, int c , int d) { //현재 행,열에서 방향으로 끝까지 갈수있는지 여부
		int nr=r,nc=c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr<0 || nr >=N || nc <0 || nc >=N) break; //계속 해당방향으로 직진해서 경계를 벗어남 -> 전선 연결 가능.
			if(map[nr][nc] ==1 || map[nr][nc] ==2) // 1 : 코어  // 2 : 전선 놓인 사리.
				return false;
				
		}
		
		return true;
		
	}
	
	
	
	private static int getLength() {
		int lCnt =0;
		for(int i=0;i < N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] ==2) lCnt++;
			}
		}
		return lCnt;
	}
	
	
	
	
	
	
}

