import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,W;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		int[] fall = new int[T];
		for(int i=0;i<T;i++) {
			fall[i] = Integer.parseInt(br.readLine());
		}
		
		int[][][] dp = new int[W+1][T][3];  /// 0열 : 먹은 자두 수  //1열 : 현재 나의 위치( 1번나무 밑 or 2번 나무 밑) //2열 남은 움직임 횟수
		
		int count=0,count2=0;
		
		for(int i=0; i<W+1;i++) {
			count =i; //남은 움직임 횟수
			count2 = 1; //위치  // 1번 : 첫번쨰  // 나무2번 : 2번째 나무
			for(int j=0;j<T;j++) {
				if(i ==0) {  // 애초에 움직일 수 없다고 가정했을 때
					dp[i][j][0] = (fall[j]==1) ? ++dp[i][j][0] : dp[i][j][0];
					dp[i][j][1] =1;
					dp[i][j][2] =0;
					continue;
				}
				
				if(count2 == fall[j]) {
					if(j==0) 
						dp[i][j][0] ++;
					
					else 
						dp[i][j][0] = dp[i][j-1][0] +1;
			
					dp[i][j][1] = fall[j]; 
					dp[i][j][2] = count;

				}
				else if(count2 != fall[j]) {  //현재 위치랑 자두 위치 다를때
					if(count !=0) { //남은 움직임 횟수 있다면
						if(j==0)
							dp[i][j][0]++;  //잡은 자두 증가
						else
							dp[i][j][0] = dp[i][j-1][0] +1;
						
						dp[i][j][1] = fall[j]; //위치 변경
						count2 = fall[j];
						dp[i][j][2] = --count;   //움직임 횟수 감소
					}
					else {
						if(dp[i-1][j][0] >= dp[i][j-1][0]) {
							dp[i][j][0] = dp[i-1][j][0];
							dp[i][j][1] = dp[i-1][j][1];
							count2 = dp[i-1][j][1];
							dp[i][j][2] = dp[i-1][j][2]+1; //바로 위 남은횟수
							count = dp[i-1][j][2]+1; //바로 위 남은횟수
						}
						else { 
							dp[i][j][0] = dp[i][j-1][0];
							dp[i][j][1] = dp[i][j-1][1];
							dp[i][j][2] = dp[i][j-1][2];
						}
					}
				}
			}
		}
		System.out.println(dp[W][T-1][0]);
	}
}