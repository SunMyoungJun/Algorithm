import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int L,C;
	static Character[] alpa;
	static Character[] temp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb= new StringBuilder();
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpa = new Character[C];
		temp = new Character[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			alpa[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpa);

		dfs(0,0,0,0);     // 자음개수 , 모음개수 , 전체개수 ,시작 인덱스
		System.out.println(sb.toString());
	}

	
	static void dfs(int con,int vow,int cnt, int idx) { // 자음개수 , 모음개수 , 전체개수 ,시작 인덱스
		if(cnt ==L) {
			if(vow >=1 && con >=2) {
				for(int i=0;i<L;i++) {
					sb.append(temp[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=idx; i<C;i++) {
			temp[cnt] = alpa[i];
			if(alpa[i] == 'a'||alpa[i] == 'e' ||alpa[i] == 'i' ||alpa[i] == 'o' ||alpa[i] == 'u')
				dfs(con,vow+1,cnt+1,i+1);
			else
				dfs(con+1,vow,cnt+1,i+1);
		}
	}
}
