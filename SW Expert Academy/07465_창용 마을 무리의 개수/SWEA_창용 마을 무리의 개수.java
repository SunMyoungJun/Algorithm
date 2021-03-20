package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int N,M;
	static int[] parents;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int test = Integer.parseInt(br.readLine());
		int num1=0,num2=0;
		int cnt =0;
		boolean temp=false;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<test+1; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			check = new boolean[N+1];
			for(int i=1;i<N+1;i++) {  //makeSet
				parents[i] = i;
			}

			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				num1 = Integer.parseInt(st.nextToken());
				num2 = Integer.parseInt(st.nextToken());
				temp = union(num1,num2);
			}

			cnt = teamCount();
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int teamCount() {
		int cnt =0;
		int temp =0;

		for(int i=1;i<N+1;i++) {
			if(check[parents[i]] == true) {
				continue;
			}

			temp = find(parents[i]);

			if(check[temp] == false) {
				check[temp] = true;
				cnt++;
			}

		}



		return cnt;
	}



	static int find(int num) {

		if(parents[num] ==  num) {
			return num;
		}

		return parents[num] = find(parents[num]);


	}



	static boolean union(int num1,int num2) {
		int n1 = find(num1);
		int n2 = find(num2);

		if(n1 == n2) {
			return false;
		}

		parents[num2] = n1;
		return true;
	}






}
