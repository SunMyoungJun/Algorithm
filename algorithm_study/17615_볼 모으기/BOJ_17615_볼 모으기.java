import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		int[] count = new int[4];
		int red=0,blue=0,left=0,right=0,min=Integer.MAX_VALUE;
		char leftball='0',rightball='0';
		
		String s = br.readLine();
		leftball = (s.charAt(0) == 'R') ? 'R' : 'B';   //1 :레드    // 2: 블루
		rightball = (s.charAt(length-1) == 'R') ? 'R' : 'B';   //1 :레드    // 2: 블루
		for(int i=0; i<s.length();i++){
			if(s.charAt(i) =='R') {
				red++;
				if(leftball =='R' && left == i)
					left++;	
			}
			else if(s.charAt(i) == 'B'){
				blue++;	
			if(leftball =='B' && left == i)
				left++;	
			}	
		}
		
		for(int i=s.length()-1 ; i>=0;i--) {
			if(s.charAt(i) =='R') {
				if(rightball =='R' && right == s.length()-1-i)
					right++;
				else
					break;
			}
			else if(s.charAt(i) == 'B'){
				if(rightball =='B' && right == s.length()-1-i)
					right++;	
				else
					break;
			}	
		}
		
		if(red == length || blue ==length){
			System.out.println("0");
			return;
		}
		count[0] = red - ((leftball =='R') ? left : 0);			//빨간공을 왼쪽으로	
		count[1] = red - ((rightball == 'R') ? right :0);			//빨간공을 오른쪽으로
		count[2] = blue - ((leftball =='B') ? left : 0); 		//파란공을 왼쪽으로
		count[3] = blue - ((rightball =='B') ? right : 0);		//파란공을 오른쪽으로
		
		for(int i=0;i<4;i++)
			min = (min < count[i]) ? min : count[i];
		
		System.out.println(min);
	}

}
