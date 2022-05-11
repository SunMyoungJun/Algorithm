import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int r,c,k,R,C;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		map = new int[3][3];
		for(int i=0; i<3; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		R=3; C=3;
		if(R>r && C>c && map[r][c] == k) {
			System.out.println("0");
		}
		else {
			while(cnt !=101) {

				R = map.length;
				C = map[0].length;

				if(R >=C) {
					RRR();
				}
				else {
					CCC();
				}
				cnt++;
				R = map.length;
				C = map[0].length;
				if(R>r && C>c && map[r][c] ==k) {
					break;
				}
			}
			if(cnt==101) {
				System.out.println("-1");
			}
			else {
				System.out.println(cnt);
			}
		}
	}

	static void RRR() {
		int[][][] num = new int[R][101][2];
				
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] ==0) {
					continue;
				}
				num[i][map[i][j]][0] = map[i][j];
				num[i][map[i][j]][1]++;
			}
		}
		int rr=0,cc=0,count=0;
		int temp1=0,temp2=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<101; j++) {
				rr=j;
				for(int k=j+1; k<101; k++) {
					if(num[i][rr][1] ==0) {
						rr=k;
					}
					else if(num[i][k][1] !=0 && num[i][rr][1] > num[i][k][1]) {
						rr = k;
					}
					else if(num[i][rr][1] == num[i][k][1]) {
						if(num[i][rr][0] > num[i][k][0]) {
							rr=k;
						}
					}
				}
				
				if(num[i][rr][1] ==0 && num[i][j][1]==0) {
					break;
				}
				temp1 = num[i][rr][0];
				temp2 = num[i][rr][1];
				num[i][rr][0] = num[i][j][0];
				num[i][rr][1] = num[i][j][1];
				num[i][j][0] = temp1;
				num[i][j][1] = temp2;
			}
		}

		int[][] temp;
		int max=0;
		List<Integer>[] arr1 = new ArrayList[R];
		for(int i=0; i<R; i++) {
			temp = num[i];
			arr1[i] = new ArrayList<>();
			for(int j=0; j<101; j++) {
				if(temp[j][1]==0) {
					break;
				}
				arr1[i].add(temp[j][0]);
				arr1[i].add(temp[j][1]);
			}
			max = Math.max(max, arr1[i].size());
		}

		max = (max >100) ? 100 : max;
		map = new int[R][max];
		
		int size=0;
		for(int i=0; i<R; i++) {
			size = arr1[i].size();
			size = (size>100) ? 100 : size;
			for(int j=0; j<size; j++) {
				map[i][j] = arr1[i].get(j);
			}
		}
	}

	static void CCC() {
		int[][][] num = new int[C][101][2];
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				if(map[j][i] ==0) {
					continue;
				}
				num[i][map[j][i]][0] = map[j][i];
				num[i][map[j][i]][1]++;
			}
		}
		int rr=0,cc=0,count=0;
		int temp1=0,temp2=0;
		for(int i=0; i<C; i++) {
			for(int j=0; j<101; j++) {
				rr=j;
				for(int k=j+1; k<101; k++) {
					if(num[i][rr][1] ==0) {
						rr=k;
					}
					else if(num[i][k][1] !=0 && num[i][rr][1] > num[i][k][1]) {
						rr = k;
					}
					else if(num[i][rr][1] == num[i][k][1]) {
						if(num[i][rr][0] > num[i][k][0]) {
							rr=k;
						}
					}
				}
				
				if(num[i][rr][1] ==0 && num[i][j][1]==0) {
					break;
				}
				temp1 = num[i][rr][0];
				temp2 = num[i][rr][1];
				num[i][rr][0] = num[i][j][0];
				num[i][rr][1] = num[i][j][1];
				num[i][j][0] = temp1;
				num[i][j][1] = temp2;
			}
		}

		int[][] temp;
		int max=0;
		List<Integer>[] arr1 = new ArrayList[C];
		for(int i=0; i<C; i++) {
			temp = num[i];
			arr1[i] = new ArrayList<>();
			for(int j=0; j<101; j++) {
				if(temp[j][1]==0) {
					break;
				}
				arr1[i].add(temp[j][0]);
				arr1[i].add(temp[j][1]);
			}
			max = Math.max(max, arr1[i].size());
		}

		max = (max >100) ? 100 : max;
		map = new int[max][C];
		
		int size=0;
		for(int i=0; i<C; i++) {
			size = arr1[i].size();
			size = (size>100) ? 100 : size;
			for(int j=0; j<size; j++) {
				map[j][i] = arr1[i].get(j);
			}
		}
	}
}