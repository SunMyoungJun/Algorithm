import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> sk = new Stack();
		int count=0;
				
		String sen = br.readLine();
		char beforeC ='0';
		int sum=0;
		int temp=0;
		for(int i=0;i<sen.length();i++)
		{
			if(sen.charAt(i) == '(')
			{
				beforeC = '(';
				count++;
				sk.push(count);
			}
			else //          )일 때
			{
				if(beforeC ==')')
				{
					sum = sum+1;
					temp = sk.pop(); //안씀 꼭대기 삭제할라고
				}
				else
				{
					sum = sum+ sk.pop()-1;
				}
				beforeC =')';	
				count--;
			}
		}
		System.out.println(sum);
	}

}
