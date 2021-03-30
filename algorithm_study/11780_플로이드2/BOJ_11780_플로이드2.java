import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer>[][] vertex = new ArrayList[n+1][n+1];
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[n+1][n+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==j)
					map[i][j] = 0;
				else {
					map[i][j] = Integer.MAX_VALUE >>1;
				}
				vertex[i][j] = new ArrayList<Integer>();
			}
		}
		int start=0,end=0,edge=0;
		StringTokenizer st =null;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			
			if(map[start][end] > edge) {
				vertex[start][end].clear();
				vertex[start][end].add(start);
				vertex[start][end].add(end);
				map[start][end] = edge;
			}		
		}
		
		int num =0;
		
		for(int k=1;k<n+1;k++) {
			for(int i=1;i<n+1;i++){
				if(k==i)
					continue;
				for(int j=1;j<n+1;j++) {
					if(i==j || j==k)
						continue;
					num = map[i][k]+map[k][j];
					
					if(map[i][j] >num) {
						map[i][j] = num;
						vertex[i][j].clear();
						for(int t=0;t<vertex[i][k].size();t++) {
							vertex[i][j].add(vertex[i][k].get(t));
						}
						for(int t=1;t<vertex[k][j].size();t++) {
							vertex[i][j].add(vertex[k][j].get(t));
						}
					}
				}
			}
		}
		
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		int size=0;
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				size = vertex[i][j].size();
				if(size ==0) {
					sb.append("0").append(" ");
				}
				else {
					sb.append(size).append(" ");
					for(int k=0;k<size;k++) {
						sb.append(vertex[i][j].get(k)).append(" ");
					}
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
