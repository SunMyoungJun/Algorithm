import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
	static boolean[] check;
	static class temper {
		int low;
		int high;

		public temper(int low,int high) {
			this.low = low;
			this.high = high;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int LOW=0,HIGH=0;
		temper[] tm = new temper[N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			LOW = Integer.parseInt(st.nextToken());
			HIGH = Integer.parseInt(st.nextToken());
			tm[i] = new temper(LOW,HIGH);
		}
		
		Arrays.sort(tm,new Comparator<temper>() {

			@Override
			public int compare(temper o1, temper o2) {
				if(o1.high == o2.high) {
					return (o1.low > o2.low) ? 1: -1;
				}
				
				return (o1.high > o2.high) ? 1: -1;
			}

			
		});

		int cnt=1;
		int thigh = tm[0].high;
		for(int i=1;i<N;i++) {
			if(thigh < tm[i].low) {
				cnt++;
				thigh = tm[i].high;
			}
		}
	
		System.out.println(cnt);
		
	}
}
