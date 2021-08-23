import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String s;
		int s2;
		int flag=0;
		int n1=0;
			for(int t=0; t<M;t++) {
				st = new StringTokenizer(br.readLine());
				s = st.nextToken();
				
				switch(s) {
				case "add" :
					s2 = Integer.parseInt(st.nextToken());
					flag = flag | 1 <<s2;
					break;
					
				case "remove" :
					s2 = Integer.parseInt(st.nextToken());
					flag = ((flag & 1 <<s2) !=0) ? flag ^ 1<<s2 : flag;
				
					break;
				
				case "check" :
					s2 = Integer.parseInt(st.nextToken());
					n1 = ((flag & 1<<s2) !=0) ? 1 : 0; 
					sb.append(n1).append("\n");
					break;
				
				case "toggle" :
					s2 = Integer.parseInt(st.nextToken());
					flag = ((flag | 0<<s2) !=0) ? flag ^ 1<<s2 : flag | 1<<s2; 
					break;
				
				case "all" :
					for(int i=1;i<21;i++) {
						flag = flag | 1<<i;
					}
					break;
					
				case "empty" :
					for(int i=1;i<21;i++) {
						flag = flag & 0<<i;
					}
					break;
				}	
			}
			System.out.println(sb.toString());
		}
}