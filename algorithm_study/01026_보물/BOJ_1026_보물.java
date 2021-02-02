
import java.util.*;
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int co = sc.nextInt();
		Integer[] arr1 = new Integer[co];
		Integer[] arr2 = new Integer[co];
		for(int i=0; i<co; i++)
			arr1[i] = sc.nextInt();
		for(int i=0;i<co;i++)
			arr2[i] = sc.nextInt();
		
		Arrays.sort(arr1,Collections.reverseOrder());
		Arrays.sort(arr2);
		int sum=0;
		
		for(int i=0; i<arr1.length; i++)
			sum += arr1[i] * arr2[i];
				
		
		System.out.println(sum);
	}
}
