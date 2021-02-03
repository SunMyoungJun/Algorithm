import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		int NN=0,M=0,N=0,a=0,count=0;
		int[][] arr1;
		boolean[][] check;
		for(int t =1;t<=test;t++)
		{
			a=0; count=1;
			NN = Integer.parseInt(br.readLine());
			 check = new boolean[NN][NN];
			N=NN;
			M=NN;
			arr1 = new int[NN][NN];
			int round = (NN %2 ==1) ? NN/2 +1 : NN/2;

			for(int k=0;k<round;k++)
			{
				for(int i=a;i<N;i++) {
					if(check[a][i] == true)
						continue;
					check[a][i] = true;
					arr1[a][i] = count;
					count++;
				}
				for(int i=a;i<N;i++){
					if(check[i][N-1] == true)
						continue;
					check[i][N-1] = true;
					arr1[i][N-1] = count;
					count++;
				}

				for(int i=N-1;i>=a;i--) {
					if(check[N-1][i] ==true)
						continue;
					check[N-1][i] = true;
					arr1[N-1][i] = count;
					count++;
				}

				for(int i=N-1; i>=a;i--) {
					if(check[i][a] ==true)
						continue;

					check[i][a] =true;
					arr1[i][a] = count;
					count++;

				}

				a++;
				N--;

			}
			System.out.println("#"+t);
			for(int i=0;i<arr1.length;i++)
			{
				for(int j=0;j<arr1[i].length;j++)
				{
					System.out.print(arr1[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
