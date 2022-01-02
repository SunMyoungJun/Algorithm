import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N,C,M;
	static class Node {
		int start;
		int end;
		int box;
		
		public Node(int start,int end, int box) {
			this.start = start;
			this.end = end;
			this.box = box;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		int[] house = new int[N+1];
		
		for(int i=0; i<N+1; i++)
			house[i] = C;
		
		ArrayList<Node> arr1 = new ArrayList<>();
		int start = 0,end=0,box=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			box = Integer.parseInt(st.nextToken());
			arr1.add(new Node(start,end,box));
		}
		
		Collections.sort(arr1,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.end != o2.end)
					return (o1.end > o2.end) ? 1: -1;
				else
					return (o1.start > o2.start) ? 1: -1;
			}
		});
		
		int sum=0;
		for(int i=0; i<M; i++) {
			Node e1 = arr1.get(i);
			start = e1.start;
			end = e1.end;
			box = e1.box;
			int min = 100001;
			for(int j=start; j<end; j++) 
				min = Math.min(house[j], min);
			
			if(min >= box) {
				for(int j=start; j<end; j++) 
					house[j] -= box;
				sum += box;

			}
			else {
				for(int j=start; j<end; j++)
					house[j] -= min;
				sum += min;
			}
		}	
		System.out.println(sum);
	}
}