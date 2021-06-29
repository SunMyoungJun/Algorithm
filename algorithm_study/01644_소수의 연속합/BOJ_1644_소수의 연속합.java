import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		boolean[] check= new boolean[N+1];

		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		Queue<Integer> q1 = new LinkedList<Integer>();
		for(int i=2; i<N+1; i++) {
			if(check[i] == false) {
				arr1.add(i);
				for(int j=i; j<N+1; j=j+i) {
					check[j] = true;
				}
			}
		}


		int size = arr1.size();
		int sum=0,cnt=0,idx=0;

		
		while(idx < size || !q1.isEmpty()) {
			if(sum < N) {
				if(idx >=size) {
					break;
				}
				q1.offer(arr1.get(idx));
				sum += arr1.get(idx++);
			}
			else if(sum == N) {
				cnt++;
				sum -= q1.poll();
			}
			else {
				sum -= q1.poll();
			}
		}
		
		
		
		
		
		System.out.println(cnt);



	}

}
