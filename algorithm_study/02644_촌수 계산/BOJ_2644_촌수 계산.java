import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int N1,N2;
	static boolean[] check;
	static ArrayList<Integer>[] arr1;
	static Queue<Integer> q1 = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr1 = new ArrayList[n+1];
		check = new boolean[n+1];
		for(int i=0;i<n+1;i++) {
			arr1[i] = new ArrayList<Integer>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		N1 = Integer.parseInt(st.nextToken());
		N2 = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());

		int n1=0,n2=0;

		while(m-- !=0) {
			st = new StringTokenizer(br.readLine());

			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			arr1[n1].add(n2);
			arr1[n2].add(n1);
		}


		q1.offer(N1);
		bfs();

	}

	static void bfs() {
		int size = 0;
		int num =0;
		int cnt =0;

		while(!q1.isEmpty()) {
			size = q1.size();


			for(int t=0;t<size;t++) {
				num = q1.poll();

				if(num == N2) {
					System.out.println(cnt);
					return;
				}
				else if(check[num] ==true)
					continue;
				
				check[num] = true;
				for(int i=0;i<arr1[num].size();i++) {
					q1.offer(arr1[num].get(i));
				}
			}
			cnt++;
		}
		System.out.println("-1");
		return;
	}
}