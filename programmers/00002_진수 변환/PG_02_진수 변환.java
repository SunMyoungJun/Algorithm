package algorithm;


public class PG_kakao_2 {

	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		
		
		int cnt=0;
		StringBuilder sb = new StringBuilder();
		while(n !=0) {
			sb.append(n%k);
			n = n/k;
		}
		String jinso = sb.reverse().toString();
		sb = new StringBuilder();
	
		int jinso_len = jinso.length();
		
		for(int i=0; i<jinso_len; i++) {
			if(jinso.charAt(i) != '0') {
				sb.append(jinso.charAt(i));
			}
			else if(jinso.charAt(i) == '0') {
				if(sb.length() !=0) {
					long num = Long.parseLong(sb.toString());
					if(num == 1) {
						sb = new StringBuilder();

						continue;
					}
					if(checkSosu(num)) {
						cnt++;
					}
					else {
						
					}
					sb = new StringBuilder();
				}
			}
			
		}
		
		if(sb.length() !=0) {
			int num = Integer.parseInt(sb.toString());
			if(num !=1 && checkSosu(num)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static boolean checkSosu(long num) {
		if(num ==2) {
			return true;
		}

		for(long i=2; i*i<=num; i++) {
			if(num%i ==0) {
				return false;
			}
		}
		return true;
	}

}
