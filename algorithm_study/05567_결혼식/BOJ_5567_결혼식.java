import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int n1=0,n2=0;
		ArrayList<Integer>[] arr1 = new ArrayList[N+1];
		boolean[] check = new boolean[N+1];
		ArrayList<Integer> oneArr = new ArrayList<>();
		
		for(int i=0; i<N+1; i++) {
			arr1[i] = new ArrayList<Integer>();
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			
			if(n1 == 1) {
				oneArr.add(n2);
			}

			arr1[n1].add(n2);
			arr1[n2].add(n1);
		}
		
		check[1] = true;
		int size = oneArr.size();
		int cnt=0,size2=0;
		
		for(int i=0; i<size; i++) {
			size2 = arr1[oneArr.get(i)].size();
			if(check[oneArr.get(i)] == false) {
				cnt++;
				check[oneArr.get(i)] = true;
			}
			for(int j=0; j<size2; j++) {
				if(check[arr1[oneArr.get(i)].get(j)] == false) {
					cnt++;
					check[arr1[oneArr.get(i)].get(j)] = true;
				}
			}
		
		}
		
		System.out.println(cnt);
		
		
	}

}
