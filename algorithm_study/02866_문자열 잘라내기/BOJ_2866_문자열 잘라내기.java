import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException	 {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] mat = new char[R][C];
		Map<String,Integer> map = new HashMap<>();
		int cnt=0;

		for(int i=0; i<R; i++) {
			String s= br.readLine();
			for(int j=0; j<C; j++) {
				mat[i][j] = s.charAt(j);
			}
		}
		
		int start = 0,end = R-1;
		int mid =0;
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		while(start <= end) {
			flag = false;
			mid = (start+end)/2;
			for(int i=0; i<C; i++) {
				sb.setLength(0);
				for(int j=mid; j<R; j++) {
					sb.append(mat[j][i]);
				}
				if(map.get(sb.toString()) != null) {
					flag = true;
					break;
				}
				else {
					map.put(sb.toString(), 1);
				}
			}
			
			if(flag) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
			
			
		}
		
		if(flag) {
			System.out.println(mid-1);
		}
		else {
			System.out.println(mid);
		}

	}

}
