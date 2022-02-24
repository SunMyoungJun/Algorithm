import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test=0,num=0,sum=0,max=-10001, max2 = -10001;
		while(true) {
			test = Integer.parseInt(br.readLine());
			if(test == 0) 
				break;
			sum=0; max=-10001; max2 = -10001;
			while(test-- !=0) {
				num = Integer.parseInt(br.readLine());
				max2 = (max > num) ? max : num;
				if(num >=0) {
					sum += num;
					max = (max >= sum) ? max : sum;
				}
				else {
					if(sum + num < 0) 
						sum=0;
					else {
						sum += num;
						max = (max >= sum) ? max : sum;
					}
				}
			}
			if(max == -10001) 
				max = max2;
			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}