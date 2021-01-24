import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
public class Main{

	public static void main(String[] args) throws IOException {
		LinkedList<Integer> dq = new LinkedList<Integer>();
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String test = br.readLine();
		int itest = Integer.parseInt(test);
		
		while(itest !=0)
		{
			String s = br.readLine();
			String[] ss = s.split(" ");
			
			if(ss[0].equals("push"))
			{
				Integer sss = Integer.parseInt(ss[1]);
				dq.add(sss);
			}
			else if(ss[0].equals("pop"))
			{
				 if(dq.isEmpty() == true)
					 bw.write("-1\n");
				 else
					 bw.write(dq.poll().toString()+"\n");
			}
			else if( ss[0].equals("size"))
				bw.write(dq.size()+"\n");
			else if( ss[0].equals("empty"))
			{
				if(dq.isEmpty() == true)
					bw.write("1\n");
				else
					bw.write("0\n");
			}
			else if(ss[0].equals("front"))
			{
				if(dq.peek() ==null)
					bw.write("-1\n");
				else
					bw.write(dq.peek()+"\n");
			}
			else if(ss[0].contentEquals("back"))
			{
				if(dq.isEmpty() ==true)
					bw.write("-1\n");
				else
					bw.write(dq.getLast().toString()+"\n");
			}
			itest--;
		}
			
		bw.flush();

	}

}
