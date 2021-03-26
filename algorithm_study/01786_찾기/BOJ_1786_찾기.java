import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();
		int[] fail = new int[pattern.length()];
		int failsize = pattern.length();
		StringBuilder sb = new StringBuilder();
		int idx=1;
		for(int j=0;j<failsize;j++) {  // 실패함수 만들기
			if(idx == failsize)
				break;
			if(pattern.charAt(idx) != pattern.charAt(j)) {
				if(j ==0) {
					fail[idx] = 0;
					j = j-1;
					idx++;
					continue;
				}
				j = fail[j-1]-1;
			}
			else {
				fail[idx] = j+1;
				idx++;
			}
		}

		int textsize = text.length();
		idx = 0;
		int cnt =0;
		int sum=0;
		for(int i=0;i<textsize;i++) {
			if(text.charAt(i) == pattern.charAt(cnt)) {
				cnt++;
			}
			else {					
				if(cnt !=0) {  // 처음으로 돌아가는거 아닐때는 다시한번 비교 , 0일떄는 i도 다음꺼부터 비교
					cnt = fail[cnt-1];
					i--;
				}
			}
					
			if(cnt == failsize) {  // 패턴 길이와 같은 길이의 text를 찾았을 때
				sb.append(i-failsize+2).append(" ");
				//i = i-failsize+1;
				sum++;
				cnt =fail[cnt-1];
			}
			
		}
		System.out.println(sum);
		System.out.println(sb.toString());
	}
}