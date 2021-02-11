import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr1 = new ArrayList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		for(int i=0;i<N;i++) {
			arr1.add(i+1);
		}
		int num1=0,count=0,start=0;
		sb.append("<");
		while(count != N) {
			
			if(count ==N-1) {
				sb.append(arr1.get((start+K-1)%arr1.size()));
				break;
			}
			sb.append(arr1.get((start+K-1)%arr1.size())).append(",").append(" ");
			count++;
			arr1.remove((start+K-1)%arr1.size());
			start = (start+K-1)%(arr1.size()+1);
		}
		
		sb.append(">");
		System.out.println(sb.toString());
	}
}
