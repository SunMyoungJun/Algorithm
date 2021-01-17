import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main{

	public static void main(String[] args) throws IOException {
		Stack<Integer> sk = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		int count =0,emp=0;
		while(test !=0)
		{
			st = new StringTokenizer(br.readLine());
			String st2 = st.nextToken();	
			if(st2.equals("push"))
			{
				sk.push(Integer.parseInt(st.nextToken()));
				count++;
			}
			else if(st2.equals("top"))
			{
				if(sk.empty()==true)
					System.out.println("-1");
				else
					System.out.println(sk.peek());	
			}
				
			else if(st2.equals("size"))
				System.out.println(count);
			else if(st2.equals("pop"))
			{
				if(sk.empty()==true)
					System.out.println("-1");
				else
				{
					System.out.println(sk.pop());
					count--;
				}
				
			}
			else if(st2.equals("empty"))
			{
				
				emp = (sk.isEmpty()==true) ? 1:0;
				System.out.println(emp);
			}
			
			test--;
		}
	}

}
