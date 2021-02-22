import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr1 = new int [6][2];
		int maxindex =-1;
		int max = -1;
		StringTokenizer st;
		BitSet bs = new BitSet();
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<6;i++) {
			st = new StringTokenizer(br.readLine());
			arr1[i][0] = Integer.parseInt(st.nextToken());
			arr1[i][1] = Integer.parseInt(st.nextToken());
			if(max < arr1[i][1]) {
				max = arr1[i][1];
				maxindex = i;
			}
		}
		
		int temp1 = (maxindex+1) % 6;
		int temp2 = (maxindex+5) % 6;
		int sum =0;
		if(arr1[temp1][1] > arr1[temp2][1]) {
			sum = max * arr1[temp1][1];
			temp2 = (temp1+3) %6;
			temp1 = (temp1+2) %6;
		}
		else {
			sum = max * arr1[temp2][1];
			temp1 = (temp2+4) %6;
			temp2 = (temp2+3) %6;
		}
		sum = sum - arr1[temp1][1] * arr1[temp2][1];
		sum = sum * num;
		
		System.out.println(sum);
	}
}