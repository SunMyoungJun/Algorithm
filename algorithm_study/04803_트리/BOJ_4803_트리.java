import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static int n1,n2;
	static int[] val;
	static boolean[] check;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int test=1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if(N==0 && M==0) {
				break;
			}

			val = new int[N+1];
			check = new boolean[N+1];
			int cnt=0;
			for(int i=1; i<N+1; i++) {
				val[i] =i;
			}

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				n1 = Integer.parseInt(st.nextToken());
				n2 = Integer.parseInt(st.nextToken());

				union(n1,n2);

			}


			for(int i=1; i<N+1; i++) {
				flag = false;
				checkSet2(i);
			}

			for(int i=1; i<N+1; i++) {
				findSet2(i);
			}


			for(int i=1; i<N+1; i++) {
				if(check[i] == false && val[i] ==i) {
					cnt++;
				}
			}

			sb.append("Case ").append(test++);
			if(cnt ==0) {
				sb.append(": No trees.\n");
			}
			else if(cnt ==1) {
				sb.append(": There is one tree.\n");
			}
			else {
				sb.append(": A forest of ").append(cnt).append(" trees.\n");
			}


		}


		System.out.println(sb.toString());

	}



	static int findSet(int num) {
		if(val[num] == num) {
			return num;
		}
		return findSet(val[num]);
	}
	static int findSet2(int num) {
		if(val[num] == num) {
			return num;
		}
		return val[num] = findSet(val[num]);
	}
	
	static boolean checkSet2(int num) {
		if(check[num] == true) {
			flag = true;
		}
		
		if(val[num] == num) {
			check[num] = flag;
			return flag;
		}
		
		return check[num] = checkSet2(val[num]);
		
	}
	
	static void checkSet(int num) {
		if(val[num] == num) {
			check[num] = true;
			return;
		}
		check[num] = true;
		checkSet(val[num]);
	}


	static void union(int num1,int num2) {
		int n1 = findSet(num1);
		int n2 = findSet(num2);

		if(n1 == n2) {
			checkSet(num1);
			checkSet(num2);
		}
		
		n1 = findSet2(num1);
		n2 = findSet2(num2);
		
		val[n1] = n2;
		
	}

}
