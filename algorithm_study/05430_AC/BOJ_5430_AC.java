import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(test-- != 0) {
			String order = br.readLine();
			int number = Integer.parseInt(br.readLine());
			String nums = br.readLine();
			String[] num;
			int len = order.length();
			if(number > 1) {
				int flag=0;
				num = nums.substring(1,nums.length()-1).split(",");
				int fidx = 0;
				int eidx =num.length-1;
				int flag2 = 0;
				for(int i=0; i<len; i++) {
					if(order.charAt(i)=='D') {
						if(eidx - fidx <0) {
							sb.append("error").append("\n");
							flag2=-1;
							break;
						}
						else {
							if(flag == 0) {
								fidx++;
							}
							else {
								eidx--;
							}
						}
					}
					else if(order.charAt(i)=='R') {
						flag = (flag == 0) ? 1: 0;
					}
				}
				
				if(flag2 ==0) {
					sb.append("[");
					
					if(flag==0) {
						for(int i=fidx; i<=eidx; i++) {
							sb.append(num[i]);
							if(i==eidx) {
								break;
							}
							sb.append(",");
						}
					}
					else {
						for(int i=eidx; i>=fidx; i--) {
							sb.append(num[i]);
							if(i==fidx) {
								break;
							}
							sb.append(",");
						}
					}
					
					sb.append("]").append("\n");
				}
				
				
			}
			
			
			
			
			else if(number ==1) {
				num = new String[1];
				num[0] = nums.substring(1,nums.length()-1);
				int cnt=0;
				int flag2=0;
				for(int i=0; i<len; i++) {
					if(order.charAt(i)=='D') {
						cnt++;
						if(cnt == 2) {
							sb.append("error").append("\n");
							flag2=-1;
							break;
						}
						
					}
				}
				
				if(flag2 == 0) {
					if(cnt ==1) {
						sb.append("[").append("]").append("\n");

					}
					else {
						sb.append("[").append(num[0]).append("]").append("\n");

					}
				}
				
			}
			
			else { // 0일 떄
				int cnt=0;
				int flag2=0;
				for(int i=0; i<len; i++) {
					if(order.charAt(i)=='D') {
						cnt++;
						if(cnt == 1) {
							sb.append("error").append("\n");
							flag2=-1;
							break;
						}
					}
				}
				if(flag2==0) {
					sb.append("[]").append("\n");
				}
			}
			
			
			
			
		}
		
		System.out.println(sb.toString());
	}

}
