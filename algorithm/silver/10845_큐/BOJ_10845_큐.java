import java.util.LinkedList;
import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		LinkedList<Integer> dq = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		test+=1;
		while(test !=0)
		{
			String s = sc.nextLine();
			String[] ss = s.split(" ");
			
			if(ss[0].equals("push"))
			{
				Integer sss = Integer.parseInt(ss[1]);
				dq.add(sss);
			}
			else if(ss[0].equals("pop"))
			{
				 if(dq.isEmpty() == true)
					System.out.println("-1");
				 else
					 System.out.println(dq.poll());
				
			}
			else if( ss[0].equals("size"))
				System.out.println(dq.size());
			else if( ss[0].equals("empty"))
			{
				if(dq.isEmpty() == true)
					System.out.println("1");
				else
					System.out.println("0");
			}
			else if(ss[0].equals("front"))
			{
				if(dq.peek() ==null)
					System.out.println("-1");
				else
					System.out.println(dq.peek());
			}
			else if(ss[0].contentEquals("back"))
			{
				if(dq.isEmpty() ==true)
					System.out.println("-1");
				else
				System.out.println(dq.getLast());	
			}
			test--;
		}
			
				
	}

}
