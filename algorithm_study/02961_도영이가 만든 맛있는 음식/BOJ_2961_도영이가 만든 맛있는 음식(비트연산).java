import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N,MIN = Integer.MAX_VALUE;
	static int[][] taste1;
	static int[][] taste2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		taste1 = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			taste1[i][0] = Integer.parseInt(st.nextToken());  //신맛
			taste1[i][1] = Integer.parseInt(st.nextToken());  //쓴맛
		}
		
		Bit(1<<N);
		System.out.println(MIN);

	}
	
	static void Bit(int bitcount) {
		int sin=1,ssn=0;
		for(int flag=1; flag<bitcount;flag++) {
			sin=1; ssn=0;
			for(int i=0; i<N; i++) {
				if((flag & 1<<i) !=0)  {
					sin *=taste1[i][0];
					ssn += taste1[i][1];
				}
			}
			MIN = (MIN < Math.abs(sin-ssn)) ? MIN : Math.abs(sin-ssn);
		}
		
		
	}

}
