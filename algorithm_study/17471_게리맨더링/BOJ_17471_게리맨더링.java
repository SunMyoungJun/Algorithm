import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] person;
	static int N,value=Integer.MAX_VALUE;
	static boolean[] check1;
	static ArrayList<ArrayList<Integer>> arr1 = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		person = new int[N+1];
		check1 = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N+1;i++) {
			arr1.add(new ArrayList<Integer>());
		}

		int num1=0;
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());

			for(int j =1;j<num1+1;j++) {
				arr1.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		dfs(0,1);
		if(value == Integer.MAX_VALUE)
			value = -1;

		System.out.println(value);
	}

	static void dfs(int cnt,int start) {
		if(cnt == N-1) {
			return;
		}

		for(int i=start; i<N+1;i++) {
			check1[i] = true;
			int truenum =0,falsenum=0;
			for(int j=1;j<check1.length;j++) {
				if(check1[j] ==true)
					truenum++;
				else
					falsenum++;
			}

			connect(truenum,falsenum);  //연결 여부 확인

			dfs(cnt+1,i+1);
			check1[i] = false;
		}

	}

	static void connect(int truenum,int falsenum) {
		boolean[] check2 = new boolean[N+1];  
		boolean[] check3 = new boolean[N+1];
		boolean[] check4 = new boolean[N+1];
		Queue<ArrayList<Integer>> q1 = new LinkedList<>();
		System.arraycopy(check1, 0,check2, 0,check1.length); // 내가 묶은 지역들만 true 되있는거 복사
		int temptrue =0,tempfalse=0;


		for(int i=1;i<N+1;i++) {
			if(check2[i] == true) {
				//				int tnum =i;
				//				int startnum=0;
				if(truenum ==1) {
					check3[i] = true;
					break;
				}
				q1.offer(arr1.get(i));				
				break;
			}
		}
		ArrayList<Integer> p1 = new ArrayList<>();
		while(!q1.isEmpty()) {
			p1 = q1.poll();

			for(int i=0;i<p1.size();i++) {
				if(check3[p1.get(i)] ==true || check2[p1.get(i)] ==false)
					continue;

				check3[p1.get(i)] =true;
				q1.offer(arr1.get(p1.get(i)));
			}
		}

		for(int i=1;i<check3.length;i++) {
			if(check3[i] ==true) {
				temptrue++;
			}
		}

		if(temptrue != truenum) {
			return;
		}
		q1.clear();


		for(int i=1;i<N+1;i++) {
			if(check2[i] == false) {					// true끼리 한팀 false끼리 한팀 .
				if(falsenum ==1) {
					check4[i] = true;
					break;
				}
				q1.offer(arr1.get(i));				
				break;
			}
		}
		
		//////////////
		while(!q1.isEmpty()) {
			p1 = q1.poll();

			for(int i=0;i<p1.size();i++) {
				if(check4[p1.get(i)] ==true || check2[p1.get(i)] ==true)
					continue;

				check4[p1.get(i)] =true;
				q1.offer(arr1.get(p1.get(i)));
			}
		}

		for(int i=1;i<check4.length;i++) {
			if(check4[i] ==true) {
				tempfalse++;
			}
		}

		if(tempfalse != falsenum) {
			return;
		}
		q1.clear();

		////////////////////////////////////// 
		int sum1=0,sum2=0;
		for(int i=1; i<N+1; i++) {
			if(check2[i] == true) {
				sum1 +=person[i];
			}
			else
				sum2 +=person[i];
		}
		value = (value < Math.abs(sum1 -sum2)) ? value : Math.abs(sum1-sum2);
	}
}	