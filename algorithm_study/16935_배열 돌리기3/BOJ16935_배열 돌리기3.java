import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] mat;
	static int[][] tmat,tmat2; // 5,6번
	static int[][] tmat3;  //3,4번
	static int N,M,R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		mat = new int[100][100];
		tmat3 = new int[100][100]; //3,4번 연산시 사용
		tmat = new int[100][100];   // 5,6번 연산시 사용
		tmat2 = new int[100][100];   // 5,6번 연산시 사용
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}




		//명령어 받아야함
		st = new StringTokenizer(br.readLine());
		int n=0;
		while(st.hasMoreTokens()) {
			n = Integer.parseInt(st.nextToken());

			switch(n) {
			case 1 :
				UpDown();
				break;

			case 2 : 
				LeftRight();
				break;
				
			case 3 :
				RightRotate();
				break;
			case 4 :
				RightRotate();
				RightRotate();
				RightRotate();
				break;
			case 5 :
				GroupRight();
				break;
			case 6 :
				GroupLeft();
				break;
			}
		}


		for(int i=0;i<N;i++) {   //배열 확인용
			for(int j=0;j<M;j++) {
				System.out.print(mat[i][j] +" ");
			}
			System.out.println();
		}



	}


	static void UpDown() {
		int temp=0;
		for(int i=0;i<N/2;i++) {

			for(int j=0;j<M;j++) {
				temp = mat[i][j];
				mat[i][j] = mat[N-1-i][j];
				mat[N-1-i][j] = temp;
			}
		}
	}

	static void LeftRight() {
		int temp=0;
		for(int i=0;i<M/2;i++) {

			for(int j=0;j<N;j++) {
				temp = mat[j][i];
				mat[j][i] = mat[j][M-1-i];
				mat[j][M-1-i] = temp;
			}
		}
	}


	static void GroupRight() {

		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				tmat[i][j] = mat[i][j+M/2];
				mat[i][j+M/2] = mat[i][j];
			}
		}
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				tmat2[i][j] = mat[i+N/2][j+M/2];
				mat[i+N/2][j+M/2] = tmat[i][j];
			}
		}
		
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				tmat[i][j] = mat[i+N/2][j];
				mat[i+N/2][j] = tmat2[i][j];
			}
		}
		
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				mat[i][j] = tmat[i][j];
			}
		}
	}

	static void GroupLeft() {

		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				tmat[i][j] = mat[i+N/2][j];
				mat[i+N/2][j] = mat[i][j];
			}
		}

		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				tmat2[i][j] = mat[i+N/2][j+M/2];
				mat[i+N/2][j+M/2] = tmat[i][j];
			}
		}

		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				tmat[i][j] = mat[i][j+M/2];
				mat[i][j+M/2] = tmat2[i][j];
			}
		}

		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				mat[i][j] = tmat[i][j];
			}
		}

	}

	static void RightRotate() {
		int temp=0;

		if(N<=M) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					tmat3[j][M-1-i] = mat[i][j];
				}
			}
		}
		else {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					tmat3[j][N-1-i] = mat[i][j];
				}
			}
		}

		temp = Math.abs(N-M);
		if(N <M) {
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					mat[i][j] = tmat3[i][temp+j];
				}
			}

		}

		else if(N >=M) {
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					mat[i][j] = tmat3[i][j];
				}
			}

		}
		temp = N;
		N =M;
		M =temp;



	}	
}
