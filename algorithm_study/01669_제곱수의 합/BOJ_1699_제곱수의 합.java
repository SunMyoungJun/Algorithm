import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] soo = new int[N+1];
		soo[0] = 0;
		soo[1] = 1;
		int num=1;
		for(int i=2; i<N+1; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j<i;j++) {
				num = j*j;
				if(num > i) {
					break;
				}
				num = soo[i-num]+1;
				min = (num > min) ? min : num;
				
			}
			soo[i] = min;
		}
		
		System.out.println(soo[N]);
		
		
		
		
		
		

	}

}
