import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Stack<Integer> sk1 = new Stack<>();
		String s = br.readLine();
		int num=0;
		for(int i=0; i<N; i++) {
			num = s.charAt(i) -'0';
			if(sk1.size() ==0) {
				sk1.push(num);
			}
			else {
				while(true) {
					if(sk1.size() ==0 || K == 0 || sk1.peek() >= num) {
						sk1.push(num);
						break;
					}
					else {
						sk1.pop();
						K--;
					}
				}
			}
		}
		
		while(K != 0) {
			sk1.pop();
			K--;
		}
		
		int size = sk1.size();
		StringBuilder sb = new StringBuilder();
		
		while(!sk1.isEmpty()) {
			sb.append(sk1.pop());
		}
		
		System.out.println(sb.reverse().toString());
		

	}

}
