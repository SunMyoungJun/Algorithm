import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());  // 트럭의 수
		int W = Integer.parseInt(st.nextToken());  // 다리길이
		int L = Integer.parseInt(st.nextToken());  // 다리 최대 하중
		
		st = new StringTokenizer(br.readLine());
		int[][] truck = new int[n][2];
		for(int i=0;i<n;i++) {
			truck[i][0] = Integer.parseInt(st.nextToken());
			truck[i][1] = W;
		}
		
		int cnt =0,idx=0,end=0,sum=0;
		while(true) { // 트럭이 다리 모두 지날동안
			boolean flag=false;
			sum=0;
			for(int i=idx; i<=end;i++) {
				if(idx >end) { //종료 조건
					break;
				}
				if(sum + truck[i][0] >L) {
					flag = true;
					break;
				}
				sum += truck[i][0];
				truck[i][1]--;  // 트럭이 다리에서 없어질  남은 시간
				if(truck[i][1] ==0) {
					idx++;
				}
			}
			if(!flag && end != n-1) { //트럭이 다리위에 더 올라갈수 있다면 고려해야할 트럭 갯수 1개 추가(단 마지막 트럭시 제외)
				end ++;
			}
			cnt++;

			if(idx > end) {  //종료 조건
				break;
			}
		}
		
		System.out.println(cnt+1);
		
	}

}
