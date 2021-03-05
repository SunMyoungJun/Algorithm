import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int N,M,MAX=Integer.MIN_VALUE;
	static int[] check;
	static int[][] party;
	static List<Integer> t_person = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> arr1 = new ArrayList<ArrayList<Integer>>();
		check = new int[N+1];
		st = new StringTokenizer(br.readLine());
		int trueknow = Integer.parseInt(st.nextToken());
		party = new int[M][];
		for(int i=0;i<trueknow;i++) {
			check[Integer.parseInt(st.nextToken())] = -1001;   //진실을 아는사람 -1001
		}
		int temp=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			temp = Integer.parseInt(st.nextToken());
			arr1.add(new ArrayList<Integer>());
			party[i] = new int[temp];
			for(int j=0;j<temp;j++) {
				arr1.get(i).add(j, Integer.parseInt(st.nextToken())); 
				party[i][j] = arr1.get(i).get(j);
			}
		}

		boolean tf = false;
		while(true) {
			if(tf ==true)
				break;
			for(int i=0; ; i++) {
				if(i >= arr1.size())
					break;

				for(int j=0;j<arr1.get(i).size(); j++) {
					if(check[arr1.get(i).get(j)] == -1001) {  //한명이라도 진실을 아는놈이면 모두 진실(-1001)로 바꿔줌
						for(int k=0;k<arr1.get(i).size();k++) {
							if(check[arr1.get(i).get(k)] != -1001) {
								check[arr1.get(i).get(k)] = -1001;
								tf = true;
							}
						}
						break;
					}
				}
			}

			if(tf ==true)
				tf = false;
			else
				tf = true;
		}


		int cnt=0;
		boolean tf2 = false;
		for(int i=0; i<party.length;i++) {
			tf2 = false;
			for(int j=0;j<party[i].length;j++) {
				if(check[party[i][j]] ==-1001) {
					tf2 = true;
					break;
				}
			}
			if(tf2 == false)
				cnt++;
		}

		System.out.println(cnt);
	}
}