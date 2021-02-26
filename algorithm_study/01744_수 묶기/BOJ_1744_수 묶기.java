import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<Integer> arr1 = new ArrayList<Integer>();
	static ArrayList<Integer> arr2 = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int temp=0,sum=0;
		for(int i=0;i<N;i++) {
			temp = Integer.parseInt(br.readLine());
			if(temp >0)
				arr1.add(temp);
			else
				arr2.add(temp);
		}

		if(arr2.size() %2 ==1)
			arr2.add(1);
		
		Collections.sort(arr1,(o1,o2)->o2-o1);
		Collections.sort(arr2,(o1,o2)->o1-o2);
		
		for(int i=0;i<arr1.size();i++) {
			if(i+1<arr1.size() && arr1.get(i+1)!=1) {
				sum = sum + arr1.get(i) * arr1.get(i+1);
				i++;
			}
			else 
				sum = sum + arr1.get(i);
		}
		for(int i=0;i<arr2.size();i=i+2) 
			sum = sum + (arr2.get(i) * arr2.get(i+1));
		
		System.out.println(sum);
	}
}