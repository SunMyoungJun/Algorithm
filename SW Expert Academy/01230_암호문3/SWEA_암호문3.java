import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int t=1; t<11;t++) {
			List<Integer> arr1 = new ArrayList<>();
			int pass_len = Integer.parseInt(br.readLine());
			
			int x=0,y=0,s=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<pass_len;i++) {
				arr1.add(Integer.parseInt(st.nextToken()));
			}
			
			int R = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				String t1 = st.nextToken();
				if(t1.equals("I")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					
					while( y-- !=0) {
						arr1.add(x++,Integer.parseInt(st.nextToken()));
					}
				}
				else if(t1.equals("D")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					while( y-- !=0) {
						arr1.remove(x);
					}
				}		
				else if(t1.equals("A")) {
					y = Integer.parseInt(st.nextToken());
					
					while(y-- !=0) {
						arr1.add(arr1.size()-1,Integer.parseInt(st.nextToken()));
					}
				}
				
			}
			sb.append("#").append(t).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(arr1.get(i)).append(" ");
			}
			sb.append("\n");	
			arr1.clear();
		}
		System.out.println(sb.toString());
	}
}