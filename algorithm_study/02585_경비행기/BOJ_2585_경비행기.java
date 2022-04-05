import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int[][] arr1;
	static boolean[] check;
	static Queue<int[]> q1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int x=0,y=0,start=0,mid=0,end=1415,result=0;;
		arr1 = new int[n+1][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr1[i][0] = x;
			arr1[i][1] = y;
		}
		arr1[n][0] = 10000;
		arr1[n][1] = 10000;
		while(start <=end) {
			mid = (start+end)/2;
			check = new boolean[n+1];
			q1 = new LinkedList<>();
			if(checking(mid)) {
				end=mid-1;
				result=mid;
			}
			else {
				start=mid+1;
			}
		}
		System.out.println(result);
	}
	static boolean checking(int yun) {
		int x1=0,y1=0,li=0,mok=0,dis=0;
		double distance=0;
		double temp=0;

		for(int i=0; i<n+1; i++) {
			x1 = arr1[i][0];
			y1 = arr1[i][1];
			distance = Math.sqrt(x1*x1 + y1*y1);
			dis = (int)Math.ceil(distance);
			
			if(dis%10 == 0) {
				mok = dis/10;
			}
			else {
				mok = dis/10+1;
			}

			if(mok >yun) {
				continue;
			}
			check[i] = true;
			q1.offer(new int[] {x1,y1});
		}
		if(q1.size() ==0) {
			return false;
		}
		int size=0,cnt=0;

		while(!q1.isEmpty()) {
			size = q1.size();
			for(int i=0; i<size; i++) {
				int[] p1 = q1.poll();

				if(p1[0] == 10000 && p1[1] == 10000) {
					return true;
				}
				for(int j=0; j<n+1; j++) {
					if(check[j] == true) {
						continue;
					}

					x1 = arr1[j][0];
					y1 = arr1[j][1];
					distance = Math.sqrt((x1-p1[0])*(x1-p1[0]) + (y1-p1[1])*(y1-p1[1]));
					dis = (int)Math.ceil(distance);
					
					if(dis%10 == 0) {
						mok = dis/10;
					}
					else {
						mok = dis/10+1;
					}

					if(mok >yun) {
						continue;
					}
					check[j] = true;
					q1.offer(new int[] {x1,y1});
				}
			}
			cnt++;
			if(cnt >k) {
				return false;
			}
		}
		return false;
	}
}