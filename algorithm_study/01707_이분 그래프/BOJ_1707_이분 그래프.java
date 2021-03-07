import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { 
	static ArrayList<ArrayList<Integer>> arr1 = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> q1 = new LinkedList<Integer>();
	static int[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		int V=0,E=0,V1=0,V2=0;

		while(K-- !=0) {  //테스트
			int tf =0;
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			check = new int[V+1];

			for(int i=0;i<V+1;i++) {
				arr1.add(new ArrayList<Integer>());
			}

			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				V1 = Integer.parseInt(st.nextToken());
				V2 = Integer.parseInt(st.nextToken());
				arr1.get(V1).add(V2);
				arr1.get(V2).add(V1);
			}

			for(int i=0; i<arr1.size();i++) {
				if(arr1.get(i).size() !=0 && check[i] ==0) {
					check[i] = 2;
					q1.offer(i);
					if(!bfs()) {
						System.out.println("NO");
						tf =1;
						break;
					}
				}
			}
			if(tf ==0)
				System.out.println("YES");
			
			arr1.clear();
			q1.clear();
		}
	}
	
	static boolean bfs() {
		int temp =1, num=0,checknum=0,size=0;

		while(!q1.isEmpty()) {
			size = q1.size();
			for(int t=0;t<size;t++) {
				num = q1.poll();
				for(int i=0;i<arr1.get(num).size();i++) {
					checknum = arr1.get(num).get(i);

					if(check[checknum] ==0) { //아직 이분할 안된거면 temp값(1 또는 2) 으로 분할함
						q1.offer(checknum);
						check[checknum] =temp;
					}
					else if(check[checknum] == temp)
						continue;
					else
						return false;
				}
			}
			temp = (temp ==1) ? 2 : 1;
		}
		return true;
	}
}