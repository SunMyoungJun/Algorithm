import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Integer>[] arr1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int computer = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[computer+1];
		arr1 = new ArrayList[computer+1];
		
		for(int i=1; i<computer+1;i++) {
			arr1[i] = new ArrayList<Integer>();
		}
		
		int num1=0,num2=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			arr1[num1].add(num2);
			arr1[num2].add(num1);
		}
		
		
		Queue<Integer> q1 = new LinkedList<>();
		int cnt=0;
		check[1] = true;
		for(int i=0;i<arr1[1].size();i++) {
			num1 = arr1[1].get(i);
			q1.offer(num1);
			check[num1] = true;
			cnt++;
		}
		
		
		while(!q1.isEmpty()) {
			num1 = q1.poll();
		
			for(int i=0; i<arr1[num1].size(); i++) {
				num2 = arr1[num1].get(i);
				if(check[num2] == false) {
					check[num2] = true;
					q1.offer(num2);
					cnt++;
				}
			}	
		}
		
		System.out.println(cnt);
	
	}

}
