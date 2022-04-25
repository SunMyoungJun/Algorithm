import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K,len,cnt;
	static int[][] arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		len=N*2;
		cnt=0;
		arr1 = new int[len+1][3];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<len+1;i++) {
			arr1[i][0] = i; // 컨테이너번호
			arr1[i][1] = Integer.parseInt(st.nextToken()); // 내구도
			arr1[i][2] = 0; // 로봇 있는지 여부
		}
		
		int level=1;
		
		while(true) {
			
			rotate();
			move();
			add();
			
			if(cnt>=K) {
				break;
			}
			level++;
		}
		
		System.out.println(level);
	}
	static void add() {
		
		if(arr1[1][1] >0) {
			arr1[1][1]--;
			if(arr1[1][1]==0) {
				cnt++;
			}
			arr1[1][2]=1;
		}
	}
	
	static void move() {
		
		int[] p1;
		int idx=0;
		for(int i=N; i>1; i--) {
			if(arr1[i-1][2] ==1 && arr1[i][2] ==0 && arr1[i][1]>0) {
				arr1[i][2] = 1;
				arr1[i-1][2]=0;
				if(--arr1[i][1] ==0) {
					cnt++;
				}
				if(i==N) {
					arr1[i][2]=0;
				}
			}
		}
	}
	
	static void rotate() {
		int n1=0,n2=0,n3=0;
		int a1=0,a2=0,a3=0;
		n1 = arr1[1][0];
		n2 = arr1[1][1];
		n3 = arr1[1][2];
		for(int i=2; i<len+1; i++) {
			a1 = arr1[i][0];
			a2 = arr1[i][1];
			a3 = arr1[i][2];
			arr1[i][0] = n1;
			arr1[i][1] = n2;
			arr1[i][2] = n3;
			if(i==N && arr1[i][2]==1) {
				arr1[i][2]=0;
			}
			n1 = a1;
			n2 = a2;
			n3 = a3;
		}
		arr1[1][0] = n1;
		arr1[1][1] = n2;
		arr1[1][2] = n3;
	}
}