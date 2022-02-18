import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException	 {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int cnt=0,num=0,min1=0,min2=0,idx=0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean[] check = new boolean[101];
		int[][] student = new int[101][2]; // 0 : 추천 횟수 , 1 : 최신 


		for(int i=1; i<A+1; i++) {
			num = Integer.parseInt(st.nextToken());
			if(check[num] == true) {
				student[num][0]++;
			}
			else if(cnt < N) {
				cnt++;
				check[num] = true;
				student[num][0]++;
				student[num][1] = i;
			}
			else {
				min1 = 1001;
				min2 = A+1;
				idx=0;
				for(int j=1; j<101; j++) {
					if(check[j] == false) {
						continue;
					}


					if(min1 > student[j][0]) {
						min1 = student[j][0];
						min2 = student[j][1];
						idx= j;
					}
					else if(min1 == student[j][0]  && min2 > student[j][1]) {
						min1 = student[j][0];
						min2 = student[j][1];
						idx= j;
					}
				}

				check[num] = true;
				check[idx] = false;
				student[idx][0] =0;
				student[idx][1] = 0;
				student[num][0]++;
				student[num][1] = i;

			}

		}

		ArrayList<Integer> arr1 = new ArrayList<>();


		for(int i=1; i<101; i++) {
			if(check[i] == true) {
				arr1.add(i);
			}
		}

		Collections.sort(arr1);

		int size = arr1.size();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			sb.append(arr1.get(i)).append(" ");
		}


		System.out.println(sb.toString());



	}

}
