import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] map;
	static int[] dice = new int[7];
	static int[] dice2 = new int[7];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		 map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int k=0;
		while(st.hasMoreTokens()) {
			k = Integer.parseInt(st.nextToken());
			
			switch(k) { 
			case 1:  //우
				if(col+1 >=M)
					break;

				col = col+1;
				swap(row,col,dice[4],dice[2],dice[1],dice[6],dice[5],dice[3]);
				break;
				
			case 2:  //좌
				if(col-1 <0)
					break;
				
				col = col-1;
				swap(row,col,dice[3],dice[2],dice[6],dice[1],dice[5],dice[4]);
				break;
			case 3:  //상
				if(row-1<0)
					break;
				
				row = row -1;
				swap(row,col,dice[5],dice[1],dice[3],dice[4],dice[6],dice[2]);
				break;
			case 4:   //하
				if(row+1 >=N)
					break;
				
				row = row+1;
 				swap(row,col,dice[2],dice[6],dice[3],dice[4],dice[1],dice[5]);
				break;
			}
		}
		
	}
	static void swap(int row,int col,int one, int two, int three, int four, int five, int six) {
		dice2[1] = one;
		dice2[2] = two;
		dice2[3] = three;
		dice2[4] = four;
		dice2[5] = five;
		dice2[6] = six;
		deepcopy();
		
		if(map[row][col] ==0) {
			map[row][col] = dice[6];
		}
		else {
			dice[6] = map[row][col];
			map[row][col] =0;
		}
		
		System.out.println(dice[1]);
	}
	
	static void deepcopy() {
		for(int i=1;i<7;i++) {
			dice[i] = dice2[i];
		}
	}
}
