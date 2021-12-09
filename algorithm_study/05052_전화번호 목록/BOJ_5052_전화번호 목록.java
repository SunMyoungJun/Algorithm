import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(test-- !=0) {
			int count = Integer.parseInt(br.readLine());
			boolean flag=true;
			String[] bun = new String[count];
			for(int i=0; i<count; i++) {
				bun[i] = br.readLine();
			}
			
			Arrays.sort(bun);
			
			
			for(int i=0; i<count-1;i++) {
				if(bun[i+1].startsWith(bun[i])) {
					flag= false;
					break;
				}
			}
			
			sb.append((flag ? "YES\n" : "NO\n"));
	
			
			
			
		}
		
		
			System.out.println(sb.toString());
	}

}
