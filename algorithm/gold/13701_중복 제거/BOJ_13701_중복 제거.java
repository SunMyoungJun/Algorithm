import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BitSet b = new BitSet();
		int count = st.countTokens();
		int temp1 =0;
		for(int i=0;i<count;i++)
		{
			temp1=Integer.parseInt(st.nextToken());
			if(b.get(temp1))
				{
					continue;
				}
			else
			{
				b.set(temp1);
				bw.write(temp1+" ");
			}
		}
		
		bw.flush();
		bw.close();
//		
	}

}
