package year2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1092배 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr1.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i=0; i<M; i++) {
			arr2.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr1);
		Collections.sort(arr2);

		int cnt=0;

		if(arr1.get(N-1) < arr2.get(M-1)) {
			System.out.println("-1");
			return;
		}
		int idx2=0;
		a:while(true) {
			idx2 = arr2.size()-1;
			if(idx2 == -1) {
				break;
			}
			for(int i=N-1; i>=0; i--) {
				if(arr1.get(i) < arr2.get(idx2)) {
					i++;
					idx2--;
				}
				else if(arr1.get(i) >= arr2.get(idx2)) {
					arr2.remove(idx2--);
				}
				
				if(idx2 == -1) {
					break;
				}

			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
