package 삼성준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20061모노미노도미노2 {
	static int N,sum;
	static int t,x,y;
	static int[][] green,blue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		green = new int[6][4];
		blue = new int[4][6];
		while(N-- !=0) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());


			if(t==1) { //1개
				oneMove();
			}
			else if(t==2) { // 1*2 블록
				oneTwoMove();
			}
			else { // 2*1 블록
				twoOneMove();
			}
			removeBlock();
		}

		int result=0;

		for(int i=0; i<4; i++) {
			for(int j=0; j<6; j++) {
				if(blue[i][j] ==1) {
					result++;
				}
				if(green[j][i] ==1) {
					result++;
				}
			}
		}


		System.out.println(sum);
		System.out.println(result);
	}


	static void removeBlock() {

		int cnt=0;

		int idx=5;
		int idx0=0,idx1=0;

		while(idx >=0) {
			cnt=0;
			idx0=0; idx1=0;
			for(int i=0; i<4; i++) {
				if(green[idx][i] ==1) {
					cnt++;
				}

				if(idx==1 && green[idx][i] ==1) {
					idx1=1;
					break;
				}
				if(idx==0 && green[idx][i]==1) {
					idx0=1;
					break;
				}
			}

			if(idx0+idx1 >0) {
				for(int t=0; t<idx0+idx1; t++) {
					for(int i=0; i<4; i++) {
						for(int j=5; j>0; j--) {
							green[j][i] = green[j-1][i];
						}
						green[0][i]=0;
					}
				}
				idx=6;
			}



			else if(cnt ==4) {
				for(int i=0; i<4; i++) {
					for(int j=idx; j>0; j--) {
						green[j][i] = green[j-1][i];
					}
					green[0][i]=0;
				}
				sum++;
				idx++;
			}
			idx--;
		}

		///////////////////////////////////////////////////////////////
		idx=5;
		while(idx >=0) {
			cnt=0;
			idx0=0; idx1=0;
			for(int i=0; i<4; i++) {
				if(blue[i][idx] ==1) {
					cnt++;
				}

				if(idx==1 && blue[i][idx] ==1) {
					idx1=1;
					break;
				}
				if(idx==0 && blue[i][idx]==1) {
					idx0=1;
					break;
				}
			}

			if(idx0+idx1 >0) {
				for(int t=0; t<idx0+idx1; t++) {
					for(int i=0; i<4; i++) {
						for(int j=5; j>0; j--) {
							blue[i][j] = blue[i][j-1];
						}
						blue[i][0] = 0;
					}
				}
				idx=6;
			}

			else if(cnt==4) {
				for(int i=0; i<4; i++) {
					for(int j=idx; j>0; j--) {
						blue[i][j] = blue[i][j-1];
					}
					blue[i][0] = 0;
				}
				idx++;
				sum++;
			}
			idx--;
		}
	}





	static void oneMove() {

		boolean flag=false;
		for(int i=0; i<5; i++) {
			if(green[i][y] ==0 && green[i+1][y] ==1) {
				green[i][y] = 1;
				flag=true;
				break;
			}
		}

		if(!flag) {
			green[5][y] =1;
		}

		flag = false;
		for(int i=0; i<5; i++) {
			if(blue[x][i]==0 && blue[x][i+1] ==1) {
				blue[x][i] = 1;
				flag = true;
				break;
			}
		}

		if(!flag) {
			blue[x][5] = 1;
		}
	}

	static void oneTwoMove() {
		boolean flag = false;
		for(int i=0; i<=5; i++) {
			if(green[i][y] == 1 || green[i][y+1] ==1) {
				flag = true;
				green[i-1][y] = 1;
				green[i-1][y+1] = 1;
				break;
			}
		}

		if(!flag) {
			green[5][y] = 1;
			green[5][y+1] = 1;
		}

		flag = false;
		for(int i=0; i<=5; i++) {
			if(blue[x][i] ==1) {
				flag= true;
				blue[x][i-2] = 1;
				blue[x][i-1] = 1;
				break;
			}
		}

		if(!flag) {
			blue[x][4] = 1;
			blue[x][5] = 1;
		}
	}

	static void twoOneMove() {
		boolean flag = false;

		for(int i=0; i<=5; i++) {
			if(green[i][y] ==1) {
				flag = true;
				green[i-2][y] =1;
				green[i-1][y] =1;
				break;
			}
		}

		if(!flag) {
			green[4][y]=1;
			green[5][y]=1;
		}
		flag=false;


		for(int i=0; i<=5; i++) {
			if(blue[x][i]==1 || blue[x+1][i] ==1) {
				flag = true;
				blue[x][i-1]=1;
				blue[x+1][i-1]=1;
				break;
			}
		}

		if(!flag) {
			blue[x][5] =1;
			blue[x+1][5] =1;
		}
	}

}
