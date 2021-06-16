import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		long cnt=0;
		int start=1,mid=0,end=k;
		while(start <=end) {
			mid = (start+end)/2;
			cnt=0;
			for(int i=1; i<N+1; i++)
				cnt += Math.min(mid/i, N);

			if(cnt <k)
				start = mid+1;
			else
				end = mid-1;
		}
		System.out.println(end+1);
	}
}